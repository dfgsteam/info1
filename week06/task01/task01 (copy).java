import java.util.Arrays;
import java.util.ArrayList;

public class task01 {
	public static void main(String[] args) {
	System.out.println("Bitte gebe eine Zahl an");
	System.out.print("Eingabe: ");
	int n = StdIn.readInt();
	
	System.out.println("\nMethode: collatzIterativOutput\n");
	collatzIterativOutput(n);
	System.out.println("\nMethode: collatzIterativ\n");
	collatzIterativ(n);
	System.out.println("\nMethode: collatzIterativ_ArrayList\n");
	collatzIterativ_ArrayList(n);
	
	
	
	}
	
	static void collatzIterativOutput(int n) {
		int index = 0;
		int value = n;
		
		System.out.println("  a \t|  n");
		System.out.println("--------|--------");
		while (true) {
			// im 0ten Durchlauf passiert noch nicht viel, es wird nur ausgegeben
			if (index == 0) {
				System.out.println(index + "\t| " + value);
			// Wenn der Wert gerade ist, dann folgt:
			} else if (value%2 == 0) {
				value =  value/2;
				System.out.println(index + "\t| " + value);          
			// Ansonsten:
			} else {
				value = 3 * value + 1;
				System.out.println(index + "\t| " + value);
			}
			
			// Wenn der Wert genau 1 ist.
			if (value == 1) {
				return;
			// Wenn einer der besagten Fehler auftritt (IntegerMaxOverflow)
			} else if (index == 2147483647 || value == 2147483647) {
				System.out.println("Integer.MaxValue");
				return;
			}
			index += 1;
		}
	}	
	
	static int [] collatzIterativ(int n) {
		// erzeuge ein Array mit der Länge 0 -> keine Eintrag möglich
		int[] values = new int[0];
		int value = n;
		
		System.out.println("  a \t|  n");
		System.out.println("--------|--------");
		while (true) {
			if (values.length == 0) {
				System.out.println(values.length + "\t| " + value);
				values = appendInt(values, value);
			} else if (value%2 == 0) {
				value =  value/2;
				System.out.println(values.length + "\t| " + value);
				values = appendInt(values, value);        
			} else {
				value = 3 * value + 1;
				System.out.println(values.length + "\t| " + value);
				values = appendInt(values, value);
			}
			if (value == 1) {
				System.out.println("Array: " + Arrays.toString(values));
				return null;
			} else if (values.length == 2147483647 || value == 2147483647) {
				System.out.println("Integer.MaxValue");
				return null;
			}
			
		}
	}
	
	
	public static int[] appendInt(int[] a, int b) {
		//Bestimme die Länge von dem array a und vergrößere diese mit 1
		int len = a.length;
		len++;
		// Erstelle ein neues Array mit der Länge len (eins größer als a)
		int[] c = new int[len];
		// kopiere alle Daten in aus dem alten Array a in das neue c
		for (int index = 0; index < a.length; index++) {
			c[index] = a[index];
		}
		// Der letzte Wert ist der neue int b
		c[len-1] = b;
		
		// Gib das neue Array zurück
		return c;
	}
	
	
	// Kombiniert die oberen Funktionen. Dabei wird statt einem Array eine (Array)List genommen. Der grobe unterschied ist, dass die Liste keine vorgegebene Länge hat und somit ohne Probleme erweitert werden kann.
	static ArrayList<Integer> collatzIterativ_ArrayList(int n) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		int value = n;
		
		System.out.println("  a \t|  n");
		System.out.println("--------|--------");
		while (true) {
			//System.out.println(values.size());
			if (values.size() == 0) {
				System.out.println(values.size() + "\t| " + value);
				values.add(value);
			} else if (value%2 == 0) {
				value =  value/2;
				System.out.println(values.size() + "\t| " + value);
				values.add(value);          
			} else {
				value = 3 * value + 1;
				System.out.println(values.size() + "\t| " + value);
				values.add(value);
			}
			if (value == 1) {
				System.out.println("ArrayList: " + values);
				return values;
			} else if (values.size() == 2147483647 || value == 2147483647) {
				System.out.println("Integer.MaxValue");
				return null;
			}
			
		}
	}
	
}
