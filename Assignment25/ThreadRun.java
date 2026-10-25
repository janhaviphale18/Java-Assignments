class ThreadImp1 implements java.lang.Runnable {

    public void run() {
        System.out.println("Hi");
    }
}

public class ThreadRun {

    public static void main(String[] args) {

        ThreadImp1 t1 = new ThreadImp1();
        ThreadImp1 t2 = new ThreadImp1();
        Thread t = new Thread(t1);
        Thread tt = new Thread(t2);
        t.start();
        tt.start();

    }
}