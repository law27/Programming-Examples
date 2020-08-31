class Temp<T> {
    T obj;

    public Temp(T o) {
        this.obj = o;
    }

    public T getObj() {
        return this.obj;
    }
}


class Temp1 extends Temp<String> {

   public Temp1(String o) {
       super(o);
   } 

   @Override
   public String getObj() {
       return obj;
   }
}


public class Bridge {
    public static void main (String[] args) {
        Temp1 t = new Temp1("Hello World");
        System.out.println(t.getObj());
    }
}
