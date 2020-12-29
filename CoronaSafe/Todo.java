import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// File Utility class for accessing the file system based on the file object
final class FileUtils {
    private FileUtils() {

    }

    // Method to create a new FileWriter
    public static FileWriter getFileWriter(File file) throws IOException  {
        return new FileWriter(file, true);
    }

    // Method to create a new FileReader
    public static FileReader getFileReader(File file) throws IOException  {
        return new FileReader(file);
    }
}

class TodoUtil {
    private final File TODO = new File("todo.txt"); // File Object to store TODO's
    private final File DONE = new File("done.txt"); // File Object to store completed Tasks

    // Usage instructions
    public String getUsageInstructions() {
        StringBuilder builder = new StringBuilder()
                .append("Usage :-\n")
                .append("$ ./todo add \"todo item\"  # Add a new todo\n")
                .append("$ ./todo ls               # Show remaining todos\n")
                .append("$ ./todo del NUMBER       # Delete a todo\n")
                .append("$ ./todo done NUMBER      # Complete a todo\n")
                .append("$ ./todo help             # Show usage\n")
                .append("$ ./todo report           # Statistics`;\n");
        return builder.toString();
    }

    // Accepts a file Object and returns contents of that file in a List
    private List<String> getContents(File file) {
        List<String> strings = new ArrayList<>();
        if(!file.exists()) return strings;
        try(BufferedReader reader = new BufferedReader(FileUtils.getFileReader(file))) {
            String thisLine;
            while ((thisLine = reader.readLine()) != null) {
                strings.add(thisLine);
            }
        } catch (IOException ex) {
            System.out.println("Unable to open File");
            System.out.println(ex.getMessage());
        }
        return strings;
    }

    // Utility function for todo list using which we can get contents and delete existing content of the file
    private List<String> addTodoUtil() {
        List<String> contents = getContents(TODO);
        try {
            new FileWriter(TODO).close();
        } catch (IOException ex) {
            System.out.println("Unable to Modify the File");
        }
        return contents;
    }

    // This method will return number of lines a.k.a number of tasks in given file
    private int getCount(File file) {
        return getContents(file).size();
    }

    // This method is used to add tasks to the todo
    public void addTodo(String todo) {
        try(FileWriter todoWriter = FileUtils.getFileWriter(TODO)) {
            List<String> contents = addTodoUtil();
            todoWriter.write(todo);
            todoWriter.write(System.lineSeparator());
            for(String content : contents) {
                todoWriter.write(content);
                todoWriter.write(System.lineSeparator());
            }
            System.out.printf("Added todo: \"%s\"", todo);
        } catch (IOException ex) {
            System.out.println("Unable to add TODO");
        }
    }

    // This method lists all the tasks in the todo.txt file
    public void listTodo() {
        if(getCount(TODO) == 0) {
            System.out.println("There are no pending todos!");
            return;
        }
        List<String> contents = getContents(TODO);
        int sizeTracker = getCount(TODO);
        for(String content : contents) {
            System.out.printf("%s %s\n", "[" + (sizeTracker--) + "]", content);
        }
    }

    // This is a helper function used to mark a task as done, as well as for deleting a task from todo list
    private String removeFromTodo(int todoNumber) {
        List<String> contents = addTodoUtil();
        String done = contents.get(contents.size() - todoNumber);
        try(FileWriter todoWriter = FileUtils.getFileWriter(TODO); ) {
            for(String content : contents) {
                if(!content.equals(done)) {
                    todoWriter.write(content);
                    todoWriter.write(System.lineSeparator());
                }
            }
        } catch (IOException ex) {
            System.out.println("Unable to Modify");
        }
        return done;
    }

    // This method will remove a task from todo.txt and add it to done.txt
    public void markAsDone(int todoNumber) {
        if(todoNumber < 1 || getCount(TODO) < todoNumber || getCount(TODO) == 0) {
            System.out.printf("Error: todo #%d does not exist.", todoNumber);
            return;
        }
        String done = "x " + LocalDate.now() + " " + removeFromTodo(todoNumber);
        try(FileWriter doneWriter = FileUtils.getFileWriter(DONE)) {
            doneWriter.write(done);
            doneWriter.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Unable to mark done");
        }
        System.out.printf("Marked todo #%d as done.\n", todoNumber);
    }

    // This method will just remove the task from todo.txt without adding it to done.txt
    public void deleteTodo(int todoNumber) {
        if(todoNumber < 1 || getCount(TODO) < todoNumber || getCount(TODO) == 0) {
            System.out.printf("Error: todo #%d does not exist. Nothing deleted.", todoNumber);
            return;
        }
        removeFromTodo(todoNumber);
        System.out.printf("Deleted todo #%d\n", todoNumber);
    }

    // This will report our Current status of todo
    public void reportTodo() {
        System.out.printf("%s Pending : %d Completed : %d", LocalDate.now(), getCount(TODO), getCount(DONE));
    }
}

public class Todo {

    public static void main(String[] args) {
        TodoUtil todoUtil = new TodoUtil();
        if(args.length < 1 || args[0].equals("help")) {
            String instructions = todoUtil.getUsageInstructions();
            System.out.println(instructions);
        }
        else if(args[0].equals("add")) {
            if(args.length < 2) {
                System.out.println("let expected = \"Error: Missing todo string. Nothing added!\";");
                return;
            }
            todoUtil.addTodo(args[1]);
        }
        else if(args[0].equals("ls")) {
            todoUtil.listTodo();
        }
        else if(args[0].equals("done")) {
            if(args.length < 2) {
                System.out.println("let expected = \"Error: Missing NUMBER for marking todo as done.\";");
                return;
            }
            todoUtil.markAsDone(Integer.parseInt(args[1]));
        }
        else if(args[0].equals("del")) {
            if(args.length < 2) {
                System.out.println("let expected = \"Error: Missing NUMBER for deleting todo.\";");
                return;
            }
            todoUtil.deleteTodo(Integer.parseInt(args[1]));
        }
        else if(args[0].equals("report")) {
            todoUtil.reportTodo();
        }
    }
}