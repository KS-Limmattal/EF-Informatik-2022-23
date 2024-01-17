import java.util.Arrays;

/*
 * Schreibe wieder sinnvollen Testcode zu jeder Aufgabe. Du wirst dabei häufig System.out.println(Arrays.toString()) verwenden.
 * Wenn ein Array verändert werden soll, dann ist in der Regel gemeint, dass die Methode das veränderte Array als 
 * return-Wert zurückgibt.
 * Aufgaben mit einem + sind grundlegend und müssen von allen gelöst werden.
 * 
 * +a) Bonnie Brain hat die Einträge in der Piraten-Buchhaltung umgekehrt chronologisch statt chronologisch sortiert. 
 * Schreibe eine Methode invert(), die die Reihenfolge der Elemente in einem int-Array input umdreht.
 * 
 * +b) Schreibe ein Programm find(String s, String[] words), das einen String s in einem String-Array words sucht und 
 * den Index des ersten Fundes zurückgibt. Bei Nichtfund soll -1 zurückgegeben werden. Bitte von Hand programmieren 
 * und nicht auf die Java-Library zurückgreifen ;-)
 * 
 * c) Schreibe ein Programm sort(), das die Werte in einem double-Array aufsteigend sortiert. Eine ineffiziente, 
 * aber einfache Möglichkeit ist, benachbarte Elemente zu betrachten und jeweils zu vertauschen, wenn sie falsch 
 * zu einander stehen.
 *    Zusatzaufgabe: Implementiere ein effizientes Sortierverfahren (oder mehrere).
 * 
 * d) Berge zeichnen: Für die nächste Schatzsuche müssen Bonnie Brain und die Crew über Berge und Hügel gehen. Sie
 * bekommt vorher die Höhenmeter mitgeteilt und möchte sich vorher einen Eindruck vom Profil machen.
 *     Schreibe eine Methode printMountain(), die ein int-Array mit (nichtnegativen) Höhenmetern in eine 
 *     ASCII-Darstellung wie folgt umsetzt:
 * Das Array {0,1,1,2,2,3,3,3,4,5,4,3,2,2,1,0} soll dargestellt werden als eine der folgenden Darstellungen 
 * (links Einstiegsvariante, rechts fortgeschrittene Variante). Die Zahlen links müssen nicht zwingend dargestellt werden.
 * 5          *                  ^
 * 4         * *                / \
 * 3      ***   *            --/   \
 * 2    **       **        -/       -\
 * 1  **           *     -/           \
 * 0 *              *   /              \
 * 
 * +e) Ein magisches Quadrat ist ein Zahlenquadrat, in dem die Summe jeder Zeile, jeder Spalte und der beiden Diagonalen 
 * jeweils den gleichen Wert ergibt. Schreibe ein Methode isMagicSquare, die quadratisches Array von ganzen Zahlen als 
 * Argument entgegennimmt und zurückgibt, ob das Array ein magisches Quadrat ist.
 * { { 12, 6, 15, 1 },
                { 13, 3, 10, 8 },
                { 2, 16, 5, 11 },
                { 7, 9, 4, 14 }
        } ist ein magisches Quadrat
 * 
 * f) Mini-Sudoku auf gültige Lösung prüfen: Da Überfälle ziemlich anstrengend sind, braucht Captain CiaoCiao einen 
 * Ausgleich und beschäftigt sich mit Sudoku. Das Sudoku-Gitter lässt sich in neun 3x3-Blöcke zerlegen. In jedem 
 * dieser Blöcke muss jede Zahl von 1 bis 9 genau einmal vorkommen.
 *    Schreibe ein Programm isValidMiniSudoku, das ein zweidimensionales Array mit neun Elementen daraufhin testet, 
 * ob alle Zahlen von 1 bis 9 vorkommen.
 *    Beispiel:     int[][] array = {
                        { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 }
                    }
      ist eine gültige Sudoku-Belegung, int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 8 } } nicht.
      Das Programm soll true oder false zurückgeben und im Falle von false auf der Konsole ausgeben, was der Fehler 
      ist (im zweiten Beispiel etwa "missing: 9").
 * 
 * g) Conways Game of Life: Das Spiel basiert auf der folgenden Idee: Die Spielwelt besteht aus einer Matrix von Zellen, 
 * die entweder leben oder tot sind. Jede Zelle hat 8 Nachbarn, Randzellen haben die Zellen des gegenüberliegenden Randes 
 * als Nachbarn. Aus der momentanen Zellenpopulation kann man die Population in der nächsten Generation durch folgende 
 * Regeln berechnen:
 *    - Hat eine tote Zelle genau 3 lebende Nachbarn, erwacht sie zum Leben.
 *    - Hat eine lebende Zelle 2 oder 3 lebende Nachbarn, bleibt sie am Leben.
 *    - Alle anderen Zellen sterben.
 * Aufgabe:
 *    - Programmiere die Aufgabe in einer separaten Klasse GameOfLife.
 *    - Schreibe eine Methode createRandom(), das zwei Zahlen n und m entgegennimmt und eine zufällig gefüllte 
 *      boolean-Matrix der Dimension m*n zurückgibt.
 *    - Schreibe eine Methode getNextGeneration(), das eine zweidimensionale boolean-Matrix cells entgegennimmt und aus 
 *      der übergebenen Matrix die Matrix der nächsten Generation berechnet und zurückgibt.
 *    - Schreibe eine Methode printCells(), das eine zweidimensionale boolean-Matrix cells entgegennimmt und auf der 
 *      Konsole darstellt. Dabei sollen lebende Zellen mit @ dargestellt werden und tote entweder mit Leerschlag oder 
 *      mit einem Punkt.
 *    - Die main-Methode soll Zahlen m, n und numberOfGenerations definieren (wähle selbst sinnvolle Werte), eine 
 *      m*n-Generation erzeuge und sie auf der Konsole ausgeben. Danach soll sie numberOfGenerations Generationen 
 *      berechnen und ebenfalls ausgeben. Zwischen den Generationen kann mit TimeUnit.SECONDS.sleep(1); eine Pause 
 *      gemacht werden.
 */

public class Aufgabe11 {

    static int[] invert(int[] input) {
        int n = input.length;
        int[] output = new int[n];
        for (int i = 0; i < n; i++) {
            output[i] = input[n - i - 1];
        }
        return output;
    }

    static int find(String s, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (s == words[i]) {
                return i;
            }
        }
        return -1;
    }

    static double[] sort(double[] input) {
        if (input.length <= 1) { // Algorithmus unten gibt in diesem Fall einen Fehler, aber das Array ist dann
                                 // schon sortiert.
            return input;
        }
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] > input[i + 1]) {
                    sorted = false;
                    double temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                }
            }
        }
        return input;
    }

    public static void printMountain(int[] altitudes) {
        int maxAltitude = altitudes[0];

        for (int i = 0; i < altitudes.length; i++)
            if (altitudes[i] > maxAltitude)
                maxAltitude = altitudes[i];

        for (int height = maxAltitude; height >= 0; height--) {
            System.out.print(height + " ");
            for (int x = 0; x < altitudes.length; x++)
                System.out.print(altitudes[x] == height ? mountainChar(altitudes, x) : ' ');
            // Statt mountainChar(altitudes, x) muss für die einfache Lösung nur '*'
            // geschrieben werden.
            System.out.println();
        }
    }

    static char mountainChar(int[] altitudes, int index) {
        int previous = (index == 0) ? 0 : altitudes[index - 1];
        int current = altitudes[index];
        int next = (index < altitudes.length - 1) ? altitudes[index + 1] : -1;

        if (previous < current && current > next) {
            return '^';
        } else if (current < next) {
            return '/';
        } else if (current > next) {
            return '\\';
        }
        // current == next )
        return '-';
    }

    static boolean isMagicSquare(int[][] square) {
        int i, j, n = square.length;

        // --- magicSum = first diagonal sum 
        int magicSum = 0;
        for (i = 0; i < n; i++){
            magicSum += square[i][i];
        }

        // check second diagonal
        int secondDiagonalSum = 0;
        for (i = 0; i < n; i++){
            secondDiagonalSum += square[i][n - i - 1];
        }
        if (secondDiagonalSum != magicSum){
            return false;
        }
        
        // --- check rows and columns
        for (i = 0; i < n; i++) {
            int rowSum = 0;
            int columnSum = 0;
            for (j = 0; j < n; j++){
                rowSum += square[i][j];
                columnSum += square[j][i];
            }
            if (rowSum != magicSum || columnSum != magicSum){
                return false;
            }
        }
        return true;
    }

    static boolean isValidMiniSudoku(int[][] grid) {
        boolean isValid = true;
        for (int i = 1; i <= 9; i++) {
            boolean found = false;
            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    if (grid[row][column] == i) {
                        found = true;
                    }
                }
            }
            if (!found) {
                System.out.printf("missing: %d%n", i);
                isValid = false;
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        // Test-Code zu Aufgabe a)
        System.out.println("Aufgabe a)");
        int[] a = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(invert(a)));
        System.out.println();

        // Test-Code zu Aufgabe b)
        System.out.println("Aufgabe b)");
        String[] genesis = { "am", "Anfang", "schuf", "Gott", "Himmel", "und", "Erde", "und", "die", "Erde", "war",
                "wüst", "und", "leer" };
        System.out.println(find("und", genesis));
        System.out.println(find("oder", genesis));
        System.out.println();

        // Test-Code zu Aufgabe c)
        System.out.println("Aufgabe c)");
        double[] values = { 5, 4.3, 4.1, -4.1, 0, -1, 2 };
        System.out.println(Arrays.toString(values));
        System.out.println(Arrays.toString(sort(values)));
        System.out.println();

        // Test-Code zu Aufgabe d)
        System.out.println("Aufgabe d)");
        int[] mountain = { 0, 1, 1, 2, 2, 3, 3, 3, 4, 5, 4, 3, 2, 2, 1, 0 };
        printMountain(mountain);
        System.out.println();

        // Test-Code zu Aufgabe e)
        System.out.println("Aufgabe e)");
        int[][] magicSquare = new int[][] { { 12, 6, 15, 1 },
                { 13, 3, 10, 8 },
                { 2, 16, 5, 11 },
                { 7, 9, 4, 14 }
        };
        System.out.println(isMagicSquare(magicSquare));
        int[][] nonMagicSquare = new int[][] { { 1, 6, 15, 1 },
                { 13, 3, 10, 8 },
                { 2, 16, 5, 11 },
                { 7, 9, 4, 14 }
        };
        System.out.println(isMagicSquare(nonMagicSquare));
        System.out.println();

        // Test-Code zu Aufgabe f)
        System.out.println("Aufgabe f)");
        int[][] validSudoku = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(isValidMiniSudoku(validSudoku));
        int[][] invalidSudoku = new int[][] {
                { 1, 2, 3 },
                { 4, 2, 6 },
                { 7, 8, 8 }
        };
        System.out.println(isValidMiniSudoku(invalidSudoku));
    }
}
