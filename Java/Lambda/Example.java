interface A {
    public int getTen();
} 


public class Example {
    public static void main (String[] args) {
       A ex = () -> 10; 
       System.out.println(ex.getTen());
    }
}
