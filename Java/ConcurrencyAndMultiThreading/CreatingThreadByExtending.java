

class NewThread extends Thread {
    NewThread() {
        super("My Thread");
        System.out.println("Child thread " + this);
        start();
    }
    
    public void run() {
        try {
            for(int i = 0; i <= 5; i++) {
                System.out.println("Child : " + i);
                Thread.sleep(1000);
            }
        } catch(Exception e) {
        }
        System.out.println("Exiting Child");
    }
}





public class CreatingThreadByExtending {
    public static void main (String[] args) {
        new NewThread();

    }
}
