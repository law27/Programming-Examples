public class ThreadingExample {
    public static void main (String[] args) {
        Thread thread  = Thread.currentThread();
        System.out.println(thread.getName());
        thread.setName("My Thread");
        System.out.println(thread);
        try {
            for(int i = 1; i <= 5; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
