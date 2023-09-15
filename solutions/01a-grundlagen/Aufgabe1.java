/* In dieser Aufgabe übst du den Umgang mit Methoden, int-Variablen und Operationen. Eine Aufgabe zählt nur als vollständig,
    wenn sie Testcode aufweist.

    a) Schreibe eine Methode round(), die eine Zahl auf das nächstliegende Vielfache von 100 rundet.
    Der Wert 149 soll auf 100 gerundet werden, der Wert 150 auf 200 (mathematisch runden).
    Die Methode soll die Zahl als int entgegennehmen und das Ergebnis als int zurückgeben.
    Schreibe ausserdem Testcode in die main()-Methode, der demonstriert, dass die Methode funktioniert.

    b) Schreibe eine Methode hours(), die eine ganzzahlige Anzahl Sekunden entgegennimmt und sie in Stunden,
    Minuten und Sekunden umrechnet und auf der Konsole ausgibt. Die Eingabe 1234 soll z.B. zur Ausgabe "0:20:34" führen.
    Teste dein Programm mit vernünftigen Eingabewerten, zum Beispiel mit 0, 59, 60, 100, 3600 und 4000.

    c) Abstand zwischen zwei Punkten: Schreibe eine Methode distance(), die die x- und y-Koordinaten zweier Punkte als int-Argumente
    entgegennimmt und den Abstand zwischen ihnen berechnet und zurückgibt.
    Hinweis: Die ganzzahlige Wurzel einer Zahl x kannst du mit Math.sqrt(x) berechnen.

    d) Politikergehälter: Herr und Frau Clever sind Politiker_innen. Sie haben je ein Grundgehalt von 100'000 Euro.
    Dazu kommt eine Abgeordnetenpauschale von 40'000 für Herrn Clever und eine von 50'000 für Frau Clever.
    Zusätzlich bekommen sie für jede Rede 500 Euro (ab der 6. Rede 700 Euro) und für jede Stunde Sekretariatsarbeit 200 Euro.
    Schreibe für jede der beiden eine Methode, die das Gesamteinkommen aus den ausgeführten Reden und Arbeiten berechnet.
    (Löse das Problem ohne if-Verzweigung!)
 */

public class Aufgabe1 {

    public static int round(int n) {
        return (n + 50) / 100 * 100;
    }

    public static void hours(int s){
        System.out.println((s / 3600) + ":" + (s % 3600 / 60) + ":" + (s % 60));
    }

    public static int distance(int x1, int y1, int x2, int y2){
        return (int) (Math.sqrt(Powers.square(y2 - y1) + Powers.square(x2 - x1)));
        // geht natürlich auch ohne Powers.square, aber warum nicht nutzen, wenn wir es schon programmiert haben!
    }

    /*
     * Diese Methode ermöglicht es, Code-Wiederholungen zu vermeiden.
     */
    public static int salary(int allowance, int numberOfSpeeches, int officeHours){
        int excessSpeeches = 0;
        if (numberOfSpeeches > 5) { // geht leider nicht ohne if - Fehler in der Aufgabenstellung!
            excessSpeeches = numberOfSpeeches - 5;
        }
        return 100000 + allowance + numberOfSpeeches * 500 + excessSpeeches * 200 + officeHours * 200;
    }

    public static int salaryMrC(int numberOfSpeeches, int officeHours){
        return salary(40000, numberOfSpeeches, officeHours);
    }

    public static int salaryMrsC(int numberOfSpeeches, int officeHours){
        return salary(50000, numberOfSpeeches, officeHours);
    }

    public static void main(String[] args) {
        // Test-Code für Teilaufgabe a)
        System.out.println("Aufgabe a)");
        System.out.println(round(149));
        System.out.println(round(150));
        System.out.println();

        // Test-Code für Teilaufgabe b)
        System.out.println("Aufgabe b)");
        hours(0);
        hours(59);
        hours(60);
        hours(3600);
        hours(4000);
        System.out.println();

        // Test-Code für Teilaufgabe c)
        System.out.println("Aufgabe b)");
        System.out.println(distance(0, 0, 0, 0));
        System.out.println(distance(0, 10, 0, 0));
        System.out.println(distance(0, 0, 0, 10));
        System.out.println(distance(10, 10, 0, 0));
        System.out.println(distance(0, 0, 10, 10));
        System.out.println(distance(10, 0, 0, 10));
        System.out.println();

        // Test-Code für Teilaufgabe d)
        System.out.println(salaryMrC(0, 0));
        System.out.println(salaryMrC(2, 7));
        System.out.println(salaryMrC(7, 0));
        System.out.println(salaryMrsC(7, 2));
    }
}
