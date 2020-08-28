// BoundedTypes are useful Restrict a class to Accept only the Given Type
class Law<T extends Number> {
    T[] obj;

    Law(T[] o) {
        this.obj = o;
    }

    double computeAverage() {
        int n = obj.length;
        double val = 0;
        for(int i = 0; i < n; i++) {
            val += obj[i].doubleValue();
        } 
        return val / n; 
    }

}

public class BoundedTypes {
    public static void main (String[] args) {
       Integer[] a = { 1, 2, 3, 4, 5};
       Law<Integer> one = new Law<>(a);
       System.out.println(one.computeAverage());
    }
}
