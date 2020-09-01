
interface A {
    public int multiply(int n);
}

public class ExamplePara {
    public static void main (String[] args) {
        A a = (n) -> (n * n);

        System.out.println(a.multiply(10));
    }
}
