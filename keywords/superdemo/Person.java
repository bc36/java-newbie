package keywords.superdemo;

/**
 * super
 * 
 * 1. Parent class reference.
 *    Use the fields or methods of the parent class, 
 *    especially if there are duplicate naming with the subclass.
 * 
 * 2. Call parent constructor.
 *    If the parent class does not have a default constructor, 
 *    the child class must explicitly call super() with parameters in order 
 *    for the compiler to locate a suitable constructor for the parent class
 * 
 * The child class automatically gets all the fields of the parent class, 
 * and it is strictly forbidden to define fields that have the same name as the parent class!
 */
public class Person {
    // protected String THOUGHT = "Java is heavy";
    protected String name;
    protected int age;

    public Person() {
        this.name = "noname";
        this.age = 0;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Farmer f = new Farmer();
        System.out.printf("%s %d\n", f.name, f.age); // noname 0

        Student s = new Student("Bob", 3, "UCLA");
        System.out.printf("%s %d %s %s\n",
                s.name, s.age, s.school, s.getParentClassName()); // noname 0 UCLA noname

        Teacher t = new Teacher("Jack", 5);
        System.out.printf("%s %d %s %s\n",
                t.name, t.age, t.getParentClassName(), t.getName()); // null 5 Jack null

        Teacher w = new Teacher("Jack", 5, null);
        System.out.printf("%s %d %s %s\n",
                w.name, w.age, w.getParentClassName(), w.getName()); // Jack 5 noname Jack

    }
}

class Student extends Person {
    protected String school;

    public Student(String name, int age, String school) {
        this.school = school;
    }

    public String getParentClassName() {
        // They are the same here, because the 'Student' itself does not have a 'name' field.
        // The compiler will automatically locate the 'name' field of the parent class.

        // return this.name;
        // return super.name;
        return name;
    }
}

class Teacher extends Person {
    protected String name;

    public Teacher(String name, int age) {
        // System.out.println(""); // Constructor call must be the first statement in a constructor
        super(name, age);
    }

    public Teacher(String name, int age, String useless) {
        this.name = name;
        this.age = age;
    }

    public String getParentClassName() {
        return super.name;
    }

    public String getName() {
        return name;
    }
}

class Farmer extends Person {
    public Farmer() {
        // super(); // The compiler will automatically call super().

        // if the 'Person' class does not have a parameterless constructor 'Person()', there will be a Error
    }
}