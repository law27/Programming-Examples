
class NewThread implements Runnable {
    Thread t;
    static int num = 0;

    NewThread() {
        ++num;
        t = new Thread(this, num + " Child");
        t.start();
    }

    public void run() {
        try {
            for(int i = 1; i <= 5; i++) {
                System.out.println(t);
                Thread.sleep(1000);
            }
        } catch(Exception e) {

        }
        System.out.println("Child Excited");
    }
}

public class CreatingThread {
    public static void main (String[] args) {
        new NewThread();

        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Main: " + i);
                Thread.sleep(1000);
            } 
        } catch(Exception e) {
        }
    }
}
