
class GenericTrial<T> {
    T obj;

    GenericTrial(T o) {
        this.obj = o;
    }

    public T getObj() {
        return obj;
    }

    public void print() {
        System.out.println(obj.getClass().getSimpleName());
    }
}

class Temp<T,V> extends GenericTrial<T> {
   V temp;
   Temp(T obj, V temp) {
       super(obj);
       this.temp = temp;
   } 

   public void print() {
       System.out.println(temp.getClass().getSimpleName());
       super.print();
   }
}



public class GenericHierrarchy {
    public static void main (String[] args) {
        Temp<String, Integer> t = new Temp<String, Integer>("This", 25);
        t.print(); 
    }
}
