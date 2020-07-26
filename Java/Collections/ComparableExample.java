import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class User implements Comparable<User> {
    
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int compareTo(User o) {
        if(this.getAge() < o.getAge()) {
            return -1;
        } else if(this.getAge() > o.getAge()) {
            return 1;
        } else {
            return 0;
        }
    } 
}


public class ComparableExample {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Lawrance" ,20));
        users.add(new User("Karthick" ,18));
        users.add(new User("Rubesh" ,19));

        Collections.sort(users);

        users.forEach( e -> System.out.println(e.getName() + " " + String.valueOf(e.getAge()) ));
    }
}
