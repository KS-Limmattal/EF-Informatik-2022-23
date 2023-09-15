public class Powers {
    
    /**
     * squares an integer number
     * @param base
     * @return the square of base
     */
    static int square(int base) {
        return base * base; //base ** 2 funktioniert in Java (im Gegensatz zu z.B. Python) nicht.
    }

    /**
     * cubes an integer number
     * @param base
     * @return the cube of base
     */
    static int cube(int base) {
        return base * square(base); // base * base * base geht natürlich auch :-)
    }
    
    public static void main(String[] args) {
        // Test-Code für Methode square()
        int a = 5;
        System.out.println("The square of " + a + " is " + square(a));

        // Test-Code für Methode cube()
        System.out.println("The cube of " + a + " is " + cube(a));


    }
}
