
public class GenericMethod {

    public static <T extends Comparable<T>> boolean isIn(T x,T[] y) {
        for(int i = 0; i < y.length; i++) {
            if(x.equals(y[i])) return true;
        }
        return false;
    }

    public static void main (String[] args) {
        String x = "one";
        String[] y = {"two", "three", "one", "five"};
        if(isIn(x, y)) {
            System.out.println("There");
        } else {
            System.out.println("Not There");
        }
        
    }
}
