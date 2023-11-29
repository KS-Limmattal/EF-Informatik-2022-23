	import java.util.Arrays;
	
	public class ArrayTestsCodeLesen {
		
		static void test1() {
			double[] a;
			short[] b = new short[3];
			byte[] f = {0, 1};
			
			String[] c;
			String[] e = new String[b[0]];
			c = {"saith", "wyth", "naw"}; // Geht nicht, ist nur bei Neudeklaration möglich (wie Z. 8)
			String[] d = c;
			c = new int[2]; // Geht nicht, da c Typ String[] hat und deshalb nicht auf ein Array vom Typ int[] verweisen darf
			String[] e = new String[b[0]]; // Geht! b wurde mit {0, 0, 0} initialisiert. Deshalb ist b[0] == 0, und ein Array der Länge 0
			String[] e = new String[] {d}; // d ist nicht vom Typ String und kann deshalb nicht Element von e sein. Ausserdem wurde die Variable e bereits als String[] definiert und darf nicht nochmals definiert werden. Es gibt also zwei Fehler in dieser Zeile.
		}	
		
		static void test2() {
			String[] a = { "un", "dau", "tri", "pedwar", "pump", "chwech" };
			String[] b = a;
			a[1] = "one";
			System.out.println(Arrays.toString(a)); // [un, one, tri, pedwar, pump, chwech]
			System.out.println(Arrays.toString(b)); // [un, one, tri, pedwar, pump, chwech]
			b = new String[6];
			System.out.println(Arrays.toString(a)); // [un, one, tri, pedwar, pump, chwech] (b und a werden durch Z. 26 wieder entkoppelt)
			System.out.println(Arrays.toString(b)); // [null, null, null, null, null, null] (b ist nicht initialisiert. Ich würde auch ["", "", "", "", "", ""] gelten lassen)
		}
		
		static int[] test3(int n) {
			int[] output = new int[n - 1];
			for (int i = 0; i < n; i++) {
				output[i] = i;
			}
			return output;
		}
		
		static int binSearch(int[] a, int value) {
			int low = 0;
			int high = a.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (a[mid] == value) {
					return mid;
				} else if (a[mid] < value) {
					low = mid + 1;
				} else { // a[mid] > value
					high = mid - 1;
				}
			}
			return -1;
		}
		
		public static void main(String[] args) {
			// 1) Welche Zeilen sind gültig, welche geben eine Fehlermeldung und warum?
			test1();

			// 2) Was wird hier ausgegeben?
			test2();
			
			// 3) Was wird hier ausgegeben?
			Arrays.toString(test3(2)); // ArrayIndexOutOfBoundsException (Array hat Länge 1. Es werden aber die Elemente mit Indizes 0 bis 1 durchlaufen, wovon das letzte gar nicht existiert)
			
			int[] orderedList = new int[] {1, 3, 4, 8};
			// 4a) welche Variablen sind beim ersten Erreichen der Zeile 41 bzw. 43 definiert, und welchen Wert haben sie?
			// Z. 41 a = {1, 3, 4, 8}, value = 4, low = 0, high = 3
			// Z. 42 a = {1, 3, 4, 8}, value = 4, low = 2, high = 3, mid = 2
			System.out.println(binSearch(orderedList, 4));
			// 4b) dito?
			// Z. 41 a = {1, 3, 4, 8}, value = 2, low = 0, high = 3
			// Zeile wird nicht erreicht
			System.out.println(binSearch(orderedList, 2));
		}
	}
