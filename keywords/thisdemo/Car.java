package keywords.thisdemo;

/**
 * this can be used to refer current class instance variable.
 * this can be used to invoke current class method (implicitly)
 * this() can be used to invoke current class constructor.
 * this can be passed as an argument in the method call.
 * this can be passed as argument in the constructor call.
 * this can be used to return the current class instance from the method.
 */
public class Car {
    public String make;
    public int year;

    // to specifically denote that the instance variable is used instead of static or local variable
    void setMake(String make) {
        this.make = make;
    }

    String getMake() {
        return this.make;
    }

    // used to refer the constructors
    public Car(String make) {
        this(make, 2023);
    }

    public Car(String make, int year) {
        this.make = make;
        this.year = year;
        // used to pass the current java instance as parameter
        yearAddOne(this);
    }

    // can be used to get the handle of the current class
    void printCls() {
        Class cls = this.getClass();
        System.out.println(cls.getName());
    }

    void yearAddOne(Car c) {
        ++c.year;
    }

    void printMakeYear() {
        System.out.println("Make: " + this.make + " Year: " + this.year);
        System.out.println("Make: " + make + " Year: " + year);
    }

    public static void main(String[] args) {
        Car obj = new Car("jeep");
        System.out.println(obj.year);

        obj.printMakeYear();
    }
}