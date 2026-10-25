class NumberThread extends Thread {
    private String threadName;

    NumberThread(String name) {
        threadName = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " : " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class Exercise1 {
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread("Thread 1");
        NumberThread t2 = new NumberThread("Thread 2");

        System.out.println("Thread 1 state: " + t1.getState());
        System.out.println("Thread 2 state: " + t2.getState());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Thread 1 state: " + t1.getState());
        System.out.println("Thread 2 state: " + t2.getState());
        System.out.println("Both threads completed.");
    }
}