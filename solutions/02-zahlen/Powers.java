public class Powers {
    
    /**
     * Squares an integer number
     * 
     * @param base the number to be squared
     * @return the square of base
     */
    static int square(int base) {
        return base * base;
    }
    
    
    static int cube(int base) {
        if (base > 8470) {
            System.out.println("Warning: The cube of " + base + " is outside of the range of int.");
        } else if (base == 0 || base == 1) {
            System.out.println("useless operation, but ok");
        } else {
            System.out.println("Nothing to worry about :-)");
        }
        return base * base * base;
    }
    

    static int power(int base, int n) {
        int power = 1;
        for (int i = 0; i < n; i++) {
            power = power * base;
        }
        // Alternative Lösung mit while:
        // int i = 0; //counter
        // while (i < n) { // repeats what is in {} as long as () is true
        //     power = power * base;
        //     i++; //short for "i = i + 1";
        // }
        return power;
    }


    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        System.out.println("The " + b + "-th power of " + a + " is " + power(a,b));
    }
}
