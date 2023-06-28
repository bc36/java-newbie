package design.pattern.singleton;

// Java guarantees that each enumeration of an enumeration class is a singleton
public enum Singleton2 {
    INSTANCE;

    private String name = "hello";

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }
}
