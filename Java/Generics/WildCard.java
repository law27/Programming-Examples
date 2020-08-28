
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

    boolean sameAvg(Law<?> o) {
        if(computeAverage() == o.computeAverage()) {
            return true;
        } return false;
    }

}

public class WildCard {
    public static void main (String[] args) {
       Integer[] arr1 = {1, 2, 3, 4};
       Double[] arr2 = {1.0, 2.0, 3.0, 4.0};
       Law<Integer> one = new Law<>(arr1);
       Law<Double> two = new Law<>(arr2);
       System.out.println(one.sameAvg(two));

    }
}
