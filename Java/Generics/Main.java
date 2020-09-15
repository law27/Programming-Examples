import java.util.*;
public class Main {
    public static void main (String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(10);
        a.add(2);
        List<? super Integer> b = a;
    }
}
