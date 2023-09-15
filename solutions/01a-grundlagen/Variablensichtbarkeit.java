public class Variablensichtbarkeit {
    static int b = 2;

    static void test(int c) {
        // (3)
        c = 1;
        int a = c;
        b = 3;
        // (4)
    }

    public static void main(String[] args) {
        // (1)
        int a = 5;
        b = 7;
        // (2)
        test(a);
        // (5)
    }
}
