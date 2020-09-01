interface Temp {
    public int multiply(int n);
}


public class VariableCapture {
    public static void main (String[] args) {
        int n = 10;
        Temp a = k -> {
            k *= n;
        //    ++n;
            return k;
        }; 
        System.out.println(a.multiply(10));
    }
}
