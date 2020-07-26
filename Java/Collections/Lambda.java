import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


public class Lambda {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Lawrance");
        list.add("Roman Reigns");
        list.add("Karthick");
        list.add("Seth Rollins");

        list.forEach(element -> System.out.println(element));

        List<String> linked = new LinkedList<>();
        linked.addAll(list);
        
        linked.forEach(element -> System.out.println(element));

    }
}
