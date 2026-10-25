class ThreadImp1 extends java.lang.Thread {

    public void run() {
        System.out.println("Hi");
    }
}

public class ThreadStart {

    public static void main(String[] args) {

        ThreadImp1 t1 = new ThreadImp1();
        t1.start();
    }
}