import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;


class StudentComparator implements Comparator<Student> {
    public int compare(Student o1, Student o2) {
        return o1.getRollNo().compareTo(o2.getRollNo());
    }
}

class Student {
    private String name;
    private Integer rollNo;

    public Student(String name, Integer rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    
    public String getName() {
        return this.name;
    }

    public Integer getRollNo() {
        return this.rollNo;
    }

    public String toString() {
        return this.name + " - " + this.rollNo;
    }
} 

public class ComparatorExample {
    public static void main(String[] args) {
       List<Student> students = new ArrayList<>();
       students.add(new Student("Lawrance", 52));
       students.add(new Student("Kailas", 40));
       students.add(new Student("Karthick", 25));
       students.add(new Student("Rubesh", 9));

       Collections.sort(students, new StudentComparator());

       students.forEach(e -> System.out.println(e) );
    }
}
