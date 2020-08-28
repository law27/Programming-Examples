

class Cons {
    double val;

    <T extends Number> Cons(T arg) {
        val = arg.doubleValue();
    }

    public void print() {
        System.out.println(val);
    }
}


public class GenericConstructor {
    public static void main (String[] args) {
        Cons a = new Cons(4);
        a.print();
        Cons b = new Cons(22.0F);
        b.print();
    }
}
