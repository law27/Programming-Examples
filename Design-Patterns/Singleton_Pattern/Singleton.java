package Singleton_Pattern;

public class Singleton {
    private static Singleton single;
    private String message;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if( single == null ) {
            single = new Singleton();
        }
        return single;
    }
    
    public void setMessage(String msg) {
        this.message = msg;
    }
    
    public String getMessage() {
        return this.message;
    }
}
