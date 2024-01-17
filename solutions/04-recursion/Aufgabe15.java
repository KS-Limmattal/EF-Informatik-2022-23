import java.util.Arrays;

/*
 * Für die folgenden Probleme gäbe es grundsätzlich auch iterative (d.h. schleifenbasierte) Lösungen.
 * Sie sollen aber allesamt mit Rekursion gelöst werden - wenn möglich ohne Hilfsmethoden.
 * Falls nichts Anderes erwähnt, soll das Resultat zurückgegeben werden.
 * Schreibe wie gewohnt Testcode, der die Rückgabewerte ausgibt.
 * Zu erledigendes Minimum: Zwei von a-c) plus d)
 * 
 * a) Programmiere eine Methode fibonacci(), die für eine natürliche Zahl n die n-te Fibonacci-Zahl zurückgibt.
 *    Die Fibonacci-Zahlen sind die Zahlen der Folge 1, 1, 2, 3, 5, 8, 13, 21, 34..., die wie folgt definiert ist:
 *    fibonacci(0) = fibonacci(1) = 1
 *    fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2) für n > 1
 * 
 * b) Programmiere eine Methode countDigits(), die die Anzahl Stellen einer ganzen Zahl zurückgibt.
 * 
 * c) Euklidischer Algorithmus: Damit kann von zwei natürlichen Zahlen x und y der ggT berechnet werden:
 *    ggT(24, 81):
 *    81 / 24 -> Rest 9
 *    24 / 9  -> Rest 6
 *    9 / 6   -> Rest 3 <= ggT
 *    6 / 3   -> Rest 0
 *    => der letzte Rest ungleich 0 ist der ggT
 *    Programmiere eine rekursive Methode gcd() (greatest common divisor), die diesem Algorithmus folgt.
 * 
 * d) Spiegeln einer Zeichenfolge: Schreibe ein Programm verlan(), das eine Zeichenfolge invertiert.
 *    Tipp: Für einen String s kann mit
 *    char c = s.charAt(n)
 *    das Zeichen an der n-ten Stelle ausgelesen werden.
 *    Zeichen vom Typ char können danach ganz normal mit Hilfe von + mit Strings verbunden werden.
 *    Es soll kein Array gebraucht werden.
 * 
 * e) Schreibe eine Methode isPalindrome(), die kontrolliert, ob ein Wort ein Palindrom ist.
 *    Dabei kannst du die Methoden .toLowerCase() und .substring() benutzen.
 * 
 * f) Türme von Hanoi: Mache dich mit dem Problem vertraut und entwickle eine Methode move(height, fromPeg, toPeg, otherPeg),
 *    die Schritt für Schritt ausgibt, welche Scheibe von welchem Stab auf welchen verschoben wird.
 * 
 *    Zusatzaufgabe: Stelle jeden Schritt graphisch auf der Konsole dar.
 * 
 * g) Implementiere ein Sortierverfahren deiner Wahl rekursiv. Für welche Verfahren ist das überhaupt sinnvoll möglich?
 * 
 */

public class Aufgabe15 {
    static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static int countDigits(int n) {
        if (n / 10 == 0) {
            return 1;
        } else {
            return countDigits(n / 10) + 1;
        }
    }

    static int gcd(int x, int y) {
        if (x % y == 0) {
            return y;
        } else {
            return gcd(y, x % y);
        }
    }

    static String verlan(String s) {
        if (s.length() <= 1) {
            return s;
        } else {
            return s.charAt(s.length() - 1) + verlan(s.substring(1, s.length() - 1)) + s.charAt(0);
        }
    }

    static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            if (s.length() <= 2) {
                return true;
            } else {
                return isPalindrome(s.substring(1, s.length() - 1));
            }
        }
        return false;
    }

    static void move(int n, String fromPeg, String toPeg, String otherPeg) {
        if (n > 1) {
            move(n - 1, fromPeg, otherPeg, toPeg);
            System.out.printf("Bewege Scheibe %d von der %s zur %s.%n", n, fromPeg, toPeg);
            move(n - 1, otherPeg, toPeg, fromPeg);
        } else
            System.out.printf("Bewege Scheibe %d von der %s zur %s.%n", n, fromPeg, toPeg);
    }

    /*
     * Mergesort ist natürlicherweise rekursiv
     */
    public static void mergeSort(double[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        double[] leftArray = Arrays.copyOf(array, mid);
        double[] rightArray = Arrays.copyOfRange(array, mid, n);

        mergeSort(leftArray, mid);
        mergeSort(rightArray, n - mid);

        merge(array, leftArray, rightArray, mid, n - mid);
    }

    public static void merge(
            double[] array, double[] leftArray, double[] rightArray, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }
        while (i < left) {
            array[k++] = leftArray[i++];
        }
        while (j < right) {
            array[k++] = rightArray[j++];
        }
    }

    // TODO: add solutions from students

    public static void main(String[] args) {
        // Test-Code zu Aufgabe a)
        System.out.println("Aufgabe a)");
        System.out.println("fibonacci(5) = " + fibonacci(5));
        System.out.println();

        // Test-Code zu Aufgabe b)
        System.out.println("Aufgabe b)");
        System.out.println(-1250 + " has digits: " + countDigits(-1250));
        System.out.println();

        // Test-Code zu Aufgabe c)
        System.out.println("Aufgabe c)");
        System.out.println("gcd(24, 81) = " + gcd(24, 81));
        System.out.println();

        // Test-Code zu Aufgabe d)
        System.out.println("Aufgabe d)");
        System.out.println("verlan à l'envers: " + verlan("verlan"));
        System.out.println("moeuf à l'envers: " + verlan("moeuf"));
        System.out.println();

        // Test-Code zu Aufgabe e)
        System.out.println("Aufgabe e)");
        System.out.println("Ebbe: " + isPalindrome("Ebbe"));
        System.out.println("ahA: " + isPalindrome("ahA"));
        System.out.println("tebot" + isPalindrome("tebot"));
        System.out.println();

        // Test-Code zu Aufgabe f)
        System.out.println("Aufgabe f)");
        move(4, "Kupfersäule", "Goldsäule", "Silbersäule");
        System.out.println();

        // Test-Code zu Aufgabe g)
        System.out.println("Aufgabe g)");
        double[] a = { 5.4, 0.12, -22222, 121, -12.25, 0, 0.75, -5, 0, 500000, -1200 };
        double[] b = a.clone();
        mergeSort(b, b.length);
        System.out.println("MergeSort: " + Arrays.toString(b));
    }
}
