package basics;

public class ObjToString {
    public static void main(String[] args) {
        Integer x = 5;
        x.toString();
        // System.out.println((String) x); // Cannot cast from Integer to String
        // Compile Error: incompatible types: Integer cannot be converted to String

        Object y = 5;
        y.toString();
        // System.out.println((String) y);
        // Can pass compilation checks, but have
        // java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String

        Cls z = new Cls();
        System.out.println(z.toString()); // basics.Cls@251a69d7
        System.out.println(String.valueOf(z)); // basics.Cls@251a69d7
        System.out.println("z = " + z); // z = basics.Cls@251a69d7
        // A reference id is printed.
        System.out.println(z.getClass().getName()); // basics.Cls
        System.out.println(z.getClass().getName() + "@" + Integer.toHexString(z.hashCode())); // basics.Cls@251a69d7
        // how we get the reference id

        // System.out.println((String) z); // Cannot cast from Cls to String

        Object o = new FakeObj();
        if (o instanceof FakeObj) {
            System.out.println(o.toString()); // qwert
            System.out.println(o.hashCode()); // 66
            // System.out.println((String) o); // java.lang.ClassCastException: class basics.FakeObj cannot be cast to class java.lang.
        }
    }
}

class Cls {
    // public String toString () {
    //     return "it's a z";
    // }
}

class FakeObj extends Object {
    @Override
    public String toString() {
        return "qwert";
    }

    @Override
    public int hashCode() {
        return 66;
    }
}