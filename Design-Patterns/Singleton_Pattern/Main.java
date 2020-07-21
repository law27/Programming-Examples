package Singleton_Pattern;

public class Main {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.setMessage("Hello World");
        System.out.println(instance.getMessage());  
    }
}
