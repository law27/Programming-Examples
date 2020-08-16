class CallMe {
    public void run(String msg) { // Without Synchronized the output is a Mess
        // Imagine this #Callme class was designed by a 3rd Party people So you have no access to this Function to add Synchronized !..
        // So the Solution is Add Synchronized Statement in The Calling Function
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getClass().getSimpleName());
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {

    Thread t;
    String msg;
    final CallMe obj;

    Caller(CallMe obj, String msg) {
        t = new Thread(this);
        this.msg = msg;
        this.obj = obj;
        t.start();
    }

    @Override
    public void run() {
        synchronized (obj) {
            obj.run(msg);
        }
    }
}

public class SyncrhonizedThread {
    public static void main(String[] args) {
        CallMe target = new CallMe();
        Caller c1 = new Caller(target, "Main");
        Caller c2 = new Caller(target, "Lawrance");
        Caller c3 = new Caller(target, "Sync");
        try {
            c1.t.join();
            c2.t.join();
            c3.t.join();
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }
}
