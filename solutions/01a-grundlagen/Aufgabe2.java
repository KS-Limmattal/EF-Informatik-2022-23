/* In dieser Aufgabe geht es um Boolesche Ausdrücke und if-Verzweigungen. Bei den Programmieraufgaben passe auf, 
 * ob eine Rückgabe (eines Werts an die aufrufende Zeile) oder eine Ausgabe (auf der Konsole) verlangt wird.
 * 
 * a) Schreibe eine Methode sort(), die drei Werte a, b, c entgegennimmt und der Grösse nach sortiert auf der
 * Konsole ausgibt.
 * 
 * b) Welche Werte werden den Variablen a, b und c in der Methode booleans() zugeordnet, wenn sie
 * mit den Argumenten x = -1, 0, 5 bzw. 10  * aufgerufen wird?
 * Du kannst (musst aber nicht) deine fertige Lösung mit Testcode überprüfen.
 * 
 * c) Vereinfache die folgenden Ausdrücke nach den Regeln von DeMorgan:
 *      !(x < y && y < z)
 *      (x != y) || !(y == z && y == x)
 *      !(x >= -3 && x <= 0) && 5 < x
 * 
 * d) Schreibe eine Methode triangle(), die die Seitenlängen a, b, c eines Dreiecks entgegennimmt und prüft, ob es
 *      - ein gültiges Dreieck
 *      - gleichseitig
 *      - gleichschenklig
 *      - rechtwinklig
 * ist. Beachte, dass ein Dreieck mehrere Bedingungen gleichzeitig erfüllen kann.
 * 
 * e) Datumsprüfung: Schreibe eine Methode isValidDate(), das ein Datum in Form dreier Zahlen day, month und year
 * entgegennimmt und als boolean zurückgibt, ob es sich um ein gültiges Datum handelt. Berücksichtige dabei auch
 * Schaltjahre. Ein Jahr ist ein Schaltjahr, wenn die Jahreszahl durch 4 teilbar ist. (Ausnahme: Jahre, die durch 100, 
 * aber nicht durch 400 teilbar sind, sind keine Schaltjahre.)
 */

public class Aufgabe2 {

    public static void sort(int a, int b, int c) {
        if (a < b) { // a < b
            if (b < c) { // a < b && b < c
                System.out.println(a + ", " + b + ", " + c);
            } else { // a < b && c <= b
                if (a < c) { // a < c && c <= b
                    System.out.println(a + ", " + c + ", " + b);
                } else { // c <= a && a < b
                    System.out.println(c + ", " + a + ", " + b);
                }
            }
        } else { // b <= a
            if (a < c) { // b <= a && a < c
                System.out.println(b + ", " + a + ", " + c);
            } else { // b <= a && c <= a
                if (b < c) { // b < c && c <= a
                    System.out.println(b + ", " + c + ", " + a);
                } else { // c <= b && b <= a
                    System.out.println(c + ", " + b + ", " + a);
                }
            }
        }
    }

    static void booleans(int x) { // sorry, y und z sind natürlich als Argumente unnötig :-|
        boolean a = x > 0 && x <= 10;
        boolean b = x < 5 || x > 9;
        boolean c = !(b || a);
        System.out.printf("For x=%d, a=%b, b=%b, c=%b\n", x, a, b, c);
        /*
         * Obige Zeile ist eine bequemere Möglichkeit,
         * System.out.println("For x=" + x + ", a=" + a + ", b=" + b + ", c=" + c);
         * zu schreiben. %d ist dabei ein Platzhalter für Ganzzahlwerte, %f für Gleitkommazahlen, %s für Strings,
         * %b für booleans, und \n markiert einen Zeilenwechsel.
         */
    }

    /*
     * Lösungen Teilaufgabe c)
     * x >= y || y >= z
     * x != y || y != z || y != x, was vereinfacht werden kann zu x != y || y != z
     * (x < -3 || x > 0) && 5 < x, was vereinfacht werden kann zu x > 5
     */

    static void triangle(int a, int b, int c) {
        System.out.print(a + ", " + b + ", " + c + ": ");
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.print("Ungültiges");
        } else {
            System.out.print("Gültiges");
            if (a == b && b == c) {
                System.out.print(" gleichseitiges");
            }
            if (a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a) {
                System.out.print(" rechtwinkliges");
            }
            if (a == b || a == c || b == c) {
                System.out.print(" gleichschenkliges");
            }
        }
        System.out.println(" Dreieck");
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            return false;
        }
        if (((month < 7 && month % 2 == 0) || (month > 8 && month % 2 == 1)) // month with less than 31 days
                && day == 31) {
            return false;
        }
        if (month == 2) { // february
            if (day == 30) {
                return false;
            }
            if (!(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) // no leap year
                    && day == 29) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test-Code für Teilaufgabe a)
        System.out.println("Aufgabe a)");
        sort(1, 2, 3);
        sort(1, 3, 2);
        sort(2, 1, 3);
        sort(2, 3, 1);
        sort(3, 1, 2);
        sort(3, 2, 1);
        System.out.println();

        // Test-Code für Teilaufgabe b)
        System.out.println("Aufgabe b)");
        booleans(-1);
        booleans(0);
        booleans(5);
        booleans(10);
        System.out.println();

        // Test-Code für Teilaufgabe d)
        System.out.println("Aufgabe d)");
        triangle(1, 2, 5);
        triangle(2, 3, 4);
        triangle(3, 4, 5);
        triangle(2, 2, 2);
        triangle(5, 5, 2);
        System.out.println();

        // Test-Code für Teilaufgabe e)
        System.out.println("Aufgabe e)");
        System.out.println(isValidDate(31, 1, 2023)); // true
        System.out.println(isValidDate(31, 2, 2023)); // false
        System.out.println(isValidDate(31, 3, 2023)); // true
        System.out.println(isValidDate(31, 4, 2023)); // false
        System.out.println(isValidDate(31, 5, 2023)); // true
        System.out.println(isValidDate(31, 6, 2023)); // false
        System.out.println(isValidDate(31, 7, 2023)); // true
        System.out.println(isValidDate(31, 8, 2023)); // true
        System.out.println(isValidDate(31, 9, 2023)); // false
        System.out.println(isValidDate(31, 10, 2023)); // true
        System.out.println(isValidDate(31, 11, 2023)); // false
        System.out.println(isValidDate(31, 12, 2023) + "\n"); // true

        System.out.println(isValidDate(28, 2, 2023)); // true
        System.out.println(isValidDate(29, 2, 2023)); // false
        System.out.println(isValidDate(29, 2, 2024)); // true
        System.out.println(isValidDate(29, 2, 1900)); // false
        System.out.println(isValidDate(29, 2, 2000)); // true
    }

}
