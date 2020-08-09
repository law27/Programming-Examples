import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map val = System.getenv();
        val.forEach((k, v) -> System.out.println(k + " : " +  v));
    }
}
