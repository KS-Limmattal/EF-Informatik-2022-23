	import java.util.Arrays;
	
	public class ArrayTests {
		
		static void test1() {
			double[] a;
			short[] b = new short[3];
			byte[] f = {0, 1};
			
			String[] c;
			c = {"saith", "wyth", "naw"};
			String[] d = c;
			c = new int[2];
			String[] e = new String[b[0]];
			String[] e = new String[] {d};
		}	
		
		static void test2() {
			String[] a = { "un", "dau", "tri", "pedwar", "pump", "chwech" };
			String[] b = a;
			a[1] = "one";
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(b));
			b = new String[6];
			System.out.println(Arrays.toString(a));
			System.out.println(Arrays.toString(b));
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
			Arrays.toString(test3(2));
			
			int[] orderedList = new int[] {1, 3, 4, 8};
			// 4a) welche Variablen sind beim ersten Erreichen der Zeile 41 bzw. 43 definiert, und welchen Wert haben sie?
			System.out.println(binSearch(orderedList, 4));
			// 4b) dito?
			System.out.println(binSearch(orderedList, 2));
		}
	}