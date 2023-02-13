
public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Usage: Main <num secs>");
            System.exit(1);
        }
        long milliseconds = Long.parseLong(args[0]) * 1000;
        MessageLog m1 = new MessageLog("hola", "hello", "ciao", "halo");
        Thread thread = new Thread(m1);
        thread.start();
        //thread.join();
        long acc = 0;
        while (thread.isAlive()) {
            Thread.sleep(100);
            acc += 100;
            if (acc > milliseconds) {
                thread.interrupt();
            }
        }
        thread.join();
        System.out.println("The end");
    }
}
