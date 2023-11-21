/*
 * Hier spielst du mit Ganzzahlen, Verzweigungen und Schleifen. Schreibe immer Testcode in der main()-Methode.
 * Achte darauf, ob eine Rückgabe oder eine Ausgabe gefordert ist.
 * 
 * a) Schreibe eine Methode crossSum(), die die Quersumme eines int-Arguments n zurückgibt.
 * 
 * b) Schreibe eine Methode primeFactorisation(), die eine positive int-Zahl n in ihre Primfaktoren zerlegt.
 * Die Methode soll die Zerlegung auf der Konsole ausgeben, z.B. für das Argument 12 soll auf der Konsole die Zeile
 * "Prime facorisation of 12 = 2 * 2 * 3" ausgegeben werden.
 * 
 * c) Ausprobieren statt denken:
 * Computer sind so schnell, dass sie gewisse Dinge einfach ausprobieren können. Password-Knackprogramme funktionieren 
 * nach diesem Prinzip.
 * Captain CiaoCiao blättert in der "Pirates Daily" und findet eine Denksportaufgabe: Er muss für die Buchstaben 
 * L, O, T und X jeweils eine Ziffer finden, damit die Rechnung XOL + LXX = TLT stimmt. Der Preis für das Rätsel ist ein 
 * alter Kompass, den will Captain CiaoCiao unbedingt gewinnen. Doch leider fehlt ihm die Lust zu denken.
 * 
 * Entwickle ein Programm tryAll(), das durch Ausprobieren aller Möglichkeiten eine Lösung findet.
 * Gib alle Lösungen aus und markiere die Lösungen, in denen X, O, L und T alle unterschiedlich sind.
 * 
 * d) Zinseszinstabelle:
 * Schreibe eine Methode compoundInterest() mit den Argumenten capital, interestRate (in Prozent) und term (in Jahren).
 * Erzeuge daraus eine Zinseszinstabelle, in der der Wert des Kapitals nach jedem Jahr der Laufzeit ausgegeben wird.
 * 
 * Zusatzaufgabe:
 * - Stelle das Kapital jeden Jahres mit zwei Nachkommastellen dar.
 * 
 * e) Berechnung von Pi:
 * Schreibe eine Methode pi(), die einen Integer digits entgegennimmt und Pi auf mindestens digits Stellen nach dem Komma
 * angenähert zurückgibt. Dabei soll die Madhava-Leibniz-Reihe gebraucht werden.
 * Tipp: Mit Math.abs() berechnest du den Betrag einer Zahl.
 * 
 * Zusatzaufgabe:
 * - Wie viele Stellen sind möglich? Was sind die limitierenden Faktoren, und kannst du sie umgehen/ ausschalten?
 * 
 * f) Weihnachtsbäume mit Schmuck darstellen:
 * Bald ist Weihnachten, und Bonny Brain möchte Weihnachtskarten drucken. Dafür sind Bäume unterschiedlicher Grösse nötig.
 * Schreibe eine Methode christmasTree(), die ein Argument width entgegennimmt und eine dreieckige Baumkrone mit der
 * maximalen Breite width Platz hat, wie folgt auf den Bildschirm zeichnet (im Beispiel ist width = 8 oder 9):
       *
      *o*
     ***o*
    *o*****
    
 * Beachte:
 * - Die Zentrierung wird durch Leerzeichen erreicht
 * - Die Blätter bestehen aus dem Multiplikationszeihen *
 * - Streue zufällig o-Zeichen in den Baum ein, die Weihnachtskugeln repräsentieren. Mit Math.random() erzeugst du 
 *   eine Zufallszahl zwischen 0 und 1.
 * 
 * Zusatzaufgabe:
 * - Schmücke den Baum weiter aus, z.B. mit einem Stamm, der sich an die Baumbreite anpasst, so dass es natürlich aussieht.
 *   Oder mit Kerzen oder Päckchen.
 */

public class Aufgabe8 {
      // Aufgabe a)
      public static int crossSum(int n) {
            int sum = 0;
            while (n != 0) {
                  sum += n % 10;
                  n = n / 10;
            }
            return sum;
      }

      // Aufgabe b)
      public static void primeFactorisation(int n) {
            System.out.print("Prime factorisation of " + n + " = ");
            int factor = 2;
            while (n != 1) {
                  if (n % factor == 0) {
                        System.out.print(factor);
                        n = n / factor;
                        if (n != 1) {
                              System.out.print(" * ");
                        }
                  } else {
                        factor++;
                  }
            }
            System.out.println();
      }

      // Aufgabe c)
      public static void tryAll() {
            for (int l = 0; l < 10; l++) {
                  for (int o = 0; o < 10; o++) {
                        for (int x = 0; x < 10; x++) {
                              for (int t = 0; t < 10; t++) {
                                    int xol = 100 * x + 10 * o + l;
                                    int lxx = 100 * l + 10 * x + x;
                                    int tlt = 100 * t + 10 * l + t;

                                    if ((xol + lxx) == tlt) {
                                          System.out.printf("l=%d, o=%d, x=%d, t=%d", l, o, x, t);
                                          if ((l != o) && (l != x) && (l != t) &&
                                                      (o != x) && (o != t) && (x != t)) {
                                                System.out.print(" (all digits different!)");
                                          }
                                          System.out.println();
                                    }
                              } // end for t
                        } // end for x
                  } // end for o
            } // end for l
      }

      // Aufgabe d)
      /*
       * This method formats a given double x as a String showing the value of x rounded to two decimals.
       */
      public static String getAsRoundedCurrency(double x) {
            long cents = Math.round(x * 100) % (Math.round(x) * 100);
            return Math.round(x) + "." + (cents < 10 ? "0" : "") + cents;
            /*
             * (cents < 10 ? "0" : "") 
             * ist ein sogenannter ternärer Operator. Er gibt einen String "0" oder "" zurück, je nachdem, ob der 
             * Ausdruck vor dem ? true oder false ist. (b ? s1 : s2) macht das Gleiche wie die folgende Methode,
             * einfach sehr viel kürzer:
             * 
             * public static String ternary(boolean b, String s1, String s2){
             *    String s;
             *    if b {
             *       s = s1;
             *    } else {
             *          s = s2;
             *    }
             *    return s;
             * }
             * 
             * Ternäre Operatoren existieren auch für andere Datentypen als String.
             */
      }

      /*
       * double ist hier die naheliegendste Wahl, da wir mit Kommazahlen arbeiten. In der Praxis würde aber wohl 
       * BigDecimal verwendet, da ja 0.1 in double nicht exakt gespeichert werden kann.
       * Eine Alternative ist, die Beträge in Hundertstel- oder Tausendstelrappen als int zu speichern und beim Ausgeben
       * in Franken und Rappen zu konvertieren. Nur ganze Rappen zu speichern ist bei sehr kleinen Frankenbeträgen oder 
       * Zinssätzen nicht die beste Wahl - zumindest wenn es um Schuldzinsen geht, wird die Bank es vermeiden, 
       * Zinsbeträge von Null zu verrechnen.
       */
      public static void compoundInterest(double capital, double interestRate, int term) {
            System.out.println("Compound interest of " + interestRate + "% on a capital of " + capital + " over " + term
                        + " years");
            for (int i = 0; i <= term; i++) {
                  capital = capital + capital * interestRate / 100;
                  System.out.println("Capital after " + i + " years = " + getAsRoundedCurrency(capital));
            }
      }

      /*
       * Aufgabe e)
       * - Genau genommen haben wir nicht die Garantie, dass digits Stellen korrekt sind, sondern dass der Fehler 
       *   kleiner als precision ist.
       * - Die Genauigkeit wird entweder ausgemessen wie in pi() oder ausgerechnet wie in pi2(). Je nachdem ergibt sich 
       *   eine while- oder eine for-Schleife.
       * - pi2() vermeidet ausserdem die Kompliziertheit des Vorzeichenwechsels durch Zusammenfassen jeder Addition mit der 
       *   folgenden Subtraktion. Das macht den Code nochmals einfacher als in pi(), und die Resultate minim genauer,
       *   da ein (negativer) Summand mehr berechnet wird.
       * Zusatzaufgabe:
       * - Wenn digits > 8 ist, wird int i einen integer overflow auslösen, da zu grosse Werte für i benötigt werden.
       *   Deshalb müssen wir für i den Datentyp long wählen, falls wir mehr digits als 8 berechnen wollen.
       * - 15 Dezimalstellen ist das double precision limit. pi(12) läuft auf meinem Computer ca. 3.5h, 
       *   d.h. pi(14) (=15 Stellen mit der Vorkommastelle) bräuchte ca. 14 Tage. Der Datentyp double ist also nicht der
       *   limitierende Faktor.
       */
      public static double pi(int digits) {  
            // calculate precision as a floating point number
            double precision = 1;
            for (int i = 0; i < digits; i++) {
                  precision = precision * 0.1;
            }
            precision = precision / 4;

            // approximating 1/4 Pi
            double sum = 0;
            double summand = 1;
            long i = 1;
            int sign = 1;
            while (Math.abs(summand) > precision) {
                  summand = sign * 1. / i;
                  sum = sum + summand;
                  sign = -sign;
                  i = i + 2;
            }

            return 4 * sum;
      }

      public static double pi2(int digits) {  
            // calculate how many elements of the series need to be calculated
            long n = 1;
            for (int i = 0; i < digits; i++) {
                  n = n * 10;
            }
            n = n * 4 + 2; // For 1/i < 1/n, we need to allow an i > n. Hence the "+ 2"

            // approximating 1/4 Pi
            double sum = 0;
            for (long i = 1; i < n; i = i + 4){
                  sum = sum + 1. / i - 1. / (i + 2);
            }

            return 4 * sum;
      }

      // Aufgabe f)
      public static void christmasTree(int width) {
            for (int stars = 1; stars <= width; stars += 2) {
                  int indentation = (width - stars - 1) / 2;
                  for (int i = 0; i < indentation; i++) {
                        System.out.print(' ');
                  }
                  for (int col = 0; col < stars; col++) {
                        System.out.print(Math.random() < 0.9 ? '*' : 'o'); // ternärer Operator, s. Lösung zu Aufgabe d)
                  }
                  System.out.println();
            }
      }

      public static void main(String[] args) {
            // Test-Code zu Aufgabe a)
            System.out.println("Aufgabe a)");
            int n = 1234;
            System.out.println("The cross sum of " + n + " is " + crossSum(n));
            System.out.println();

            // Test-Code zu Aufgabe b)
            System.out.println("Aufgabe b)");
            primeFactorisation(12);
            System.out.println();

            // Test-Code zu Aufgabe c)
            System.out.println("Aufgabe c)");
            tryAll();
            System.out.println();

            // Test-Code zu Aufgabe d)
            System.out.println("Aufgabe d)");
            double c = 1;
            double p = 3.5;
            int t = 10;
            compoundInterest(c, p, t);
            System.out.println();

            // Test-Code zu Aufgabe e)
            System.out.println("Aufgabe e)");
            for (n = 0; n < 10; n++){
                  System.out.println("Pi approximated to " + n + " digits with pi()  is " + pi(n));
                  System.out.println("Pi approximated to " + n + " digits with pi2() is " + pi2(n));
            }
            System.out.println();

            // Test-Code zu Aufgabe f)
            System.out.println("Aufgabe f)");
            christmasTree(8);
            System.out.println();
      }
}