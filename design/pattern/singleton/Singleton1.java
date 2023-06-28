package design.pattern.singleton;

public class Singleton1 {
    private static final Singleton1 INSTANCE = new Singleton1();

    // private constructor
    private Singleton1() {
        // do sth
    }

    // expose by static method
    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
