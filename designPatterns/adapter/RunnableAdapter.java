package designPatterns.adapter;

import java.util.concurrent.Callable;

public class RunnableAdapter implements Runnable { // step 1
    // Get old reference, step 2
    private Callable<?> callable;

    public RunnableAdapter(Callable<?> callable) {
        this.callable = callable;
    }

    // Implement new, step 3
    public void run() {
        try {
            callable.call(); // Using old methods to implement new methods
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}