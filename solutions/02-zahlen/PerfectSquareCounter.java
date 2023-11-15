/*
 * This program calculates how many perfect square numbers are contained in the interval from 1 to a given number i 
 * (1 and i included).
 * It separately counts the even perfect square numbers in the specified interval.
 */

public class PerfectSquareCounter {

    /**
     * Counter for the number of even perfect square numbers
     */
    static int evenPerfectSquareNumbers = 0;

    /**
     * Decides whether a number is a perfect square or not
     * 
     * @param number
     * @return whether number is a perfect square or not
     */
    private static boolean isPerfectSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt - Math.floor(sqrt) == 0;
    }

    /**
     * Calculates the number of perfect square numbers less or equal to i
     * The total count of perfect square numbers is returned while the number of
     * even perfect square numbers is stored
     * in the global variable evenPerfectSquareNumbers
     * 
     * @param i
     * @return count of perfect square numbers less or equal to i
     */
    public static int calculateCount(int i) {
        int perfectSquaresCount = 0;
        for (int number = 1; number <= i; number++) { // Edits: number = 1; number <= i;
            if (isPerfectSquare(number)) {
                perfectSquaresCount++;
                if (number % 2 == 0) { // Edit: == 0 instead of == 1
                    evenPerfectSquareNumbers++;
                }
            }
        }
        return perfectSquaresCount; // Edit: return the correct value
    }

    /**
     * Calculates and prints to the console the number of total and even
     * perfect square numbers less or equal to n
     * 
     * @param n
     */
    public static void printCount(int n) {
        System.out.println("Total Perfect Squares: " + calculateCount(n));
        System.out.println("Even Perfect Squares : " + evenPerfectSquareNumbers);
    }

    public static void main(String[] args) {
        // Test code
        printCount(10);
    }
}