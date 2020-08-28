class Law<T> {
    T obj;

    Law(T o) {
        this.obj = o;
    }

    T getObj() {
        return obj;
    }

    void showType() {
        System.out.println("Type is " + obj.getClass().getName());
    }
}


public class SimpleEx {
    public static void main (String[] args) {
        Law<Integer> a = new Law<>(10); 
        a.showType();
        Law<String> b = new Law<>("Lawrance");
        b.showType();
        Law<Boolean> c = new Law<>(true);
        c.showType();
    }
}
