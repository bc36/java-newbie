package basics;

public class FindMaximum {
    public static void main(String[] args) {
        // Find the max of 3 numbers in Java
        int a = 10;
        int b = 5;
        int c = 15;
        int mx;

        mx = Math.max(a, Math.max(b, c));
        System.out.printf("mx = %d\n", mx);

        b = 20;
        mx = java.util.Collections.max(java.util.Arrays.asList(a, b, c));
        System.out.printf("mx = %d\n", mx);

        a = 30;
        mx = java.util.stream.Stream.of(a, b, c).max(Integer::compareTo).get();
        System.out.printf("mx = %d\n", mx);

        // Performance Comparison
        long t1, t2;
        int loop;

        loop = 1000_000;
        t1 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            Math.max(a, Math.max(b, c));
        }
        t2 = System.currentTimeMillis();
        System.out.printf("t2 - t1 = %d\n", t2 - t1);

        t1 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            java.util.Collections.max(java.util.Arrays.asList(a, b, c));
        }
        t2 = System.currentTimeMillis();
        System.out.printf("t2 - t1 = %d\n", t2 - t1);

        t1 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            java.util.stream.Stream.of(a, b, c).max(Integer::compareTo).get();
        }
        t2 = System.currentTimeMillis();
        System.out.printf("t2 - t1 = %d\n", t2 - t1);
        /*
         * t2 - t1 = 10
         * t2 - t1 = 20
         * t2 - t1 = 51
         */

        loop = 1000_000_000;
        t1 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            Math.max(a, Math.max(b, c));
        }
        t2 = System.currentTimeMillis();
        System.out.printf("t2 - t1 = %d\n", t2 - t1);

        t1 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            java.util.Collections.max(java.util.Arrays.asList(a, b, c));
        }
        t2 = System.currentTimeMillis();
        System.out.printf("t2 - t1 = %d\n", t2 - t1);

        t1 = System.currentTimeMillis();
        for (int i = 0; i < loop; i++) {
            java.util.stream.Stream.of(a, b, c).max(Integer::compareTo).get();
        }
        t2 = System.currentTimeMillis();
        System.out.printf("t2 - t1 = %d\n", t2 - t1);
        /*
         * t2 - t1 = 6
         * t2 - t1 = 4085
         * t2 - t1 = 21097
         */

        return;
    }
}