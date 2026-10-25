class NumberPrinter {
    private int turn = 1;
    public synchronized void printOdd(int threadNumber) {
        for (int i = 1; i <= 5; i++) {
            while (turn != threadNumber) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        System.out.println("Thread" + threadNumber + " : " + i);
        turn = (turn % 3) + 1;
        notifyAll();
    }
}