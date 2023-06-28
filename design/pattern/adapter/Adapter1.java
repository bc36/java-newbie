package design.pattern.adapter;

import java.util.concurrent.Callable;

public class Adapter1 implements Callable<Long> {
    private long num;

    public Adapter1(long num) {
        this.num = num;
    }

    public Long call() throws Exception {
        long r = 0;
        for (long i = 1; i <= this.num; i++) {
            r = r + i;
        }
        System.out.println("Result: " + r);
        return r;
    }

    public static void main(String[] args) {
        Callable<Long> callable = new Adapter1(5);
        // Thread t1 = new Thread(callable); // compile error! it should be Runnable not Callable
        // t1.start();

        Thread t2 = new Thread(new RunnableAdapter(callable));
        t2.start();
    }
}
