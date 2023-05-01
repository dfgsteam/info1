import java.util.Arrays;
import java.util.ArrayList;

public class task01 {
	public static void main(String[] args) {
	
	// Für folgende Längen der Arrays args
	switch (args.length) {
		// Falls es kein Eintrag haben sollte
		case 0:
			System.out.println("Deine Eingabe ist zu kurz, wähle mind. ein Argument.");
			return;
		// Wenn es genau einen Eintrag hat
		case 1: 
			// Versuche den Integer n zu initialisieren, falls nicht gib eine Fehlermeldung
			try {
				int n = Integer.parseInt(args[0]);
				
				if (n <= 0) {
					System.out.println("Deine Zahl ist nicht positiv!");
					return;
				}
				// Führe die beiden Methoden collatzIterativOutput und collatzIterativ aus.
				collatzIterativOutput(n);
				System.out.println("Array: " + Arrays.toString(collatzIterativ(n)));
				return;
			} catch (Exception e) {
				System.out.println("Deine Zahl ist außerhalb des Wertebereich eines Integer");
				return;
			}
		// Wenn es genau zwei Einträge hat
		case 2:
			try {
				int n = Integer.parseInt(args[0]);
				int m = Integer.parseInt(args[1]);
				if (n <= 0 || m <= 0) {
					System.out.println("Deine Zahl ist nicht positiv!");
					return;
				} else if (n > m) {
					System.out.println("Die erste Zahl (n) soll größer sein als die zweite Zahl (m)!");
					return;
				}
				
				// Für jede Zahl zwischen n und m
				while (n <= m) {
					// Fall ein Fehler bei einer Zahl auftritt
					if (collatzIterativ(n) == null) {
						System.out.println("Darüber kann man keine Aussage treffen.");
						return;
					}
					n++;
				}	
				System.out.println("Zwischen den Zahlen n = " + args[0] + " und m = " + args[1] + " trifft die Collatz-Vermutung zu.");
				return;
			} catch (Exception e) {
				System.out.println("Deine Zahl ist außerhalb des Wertebereich eines Integer");
				return;
			}
		// Für jeden fall (-> indem Fall alle über 2, da bei jeden "Fall" im Anschluss ein break/return gemacht wird und somit das Programm beendet wird)		
		default:
			System.out.println("Deine Eingabe ist zu lang, wähle max. zwei Argumente.");
			return;
	
	}
	/*
	int n = 0;
	
	System.out.println("\nMethode: collatzIterativOutput\n");
	collatzIterativOutput(n);
	System.out.println("\nMethode: collatzIterativ\n");
	collatzIterativ(n);
	System.out.println("\nMethode: collatzIterativ_ArrayList\n");
	collatzIterativ_ArrayList(n);
	
	*/
	
	}
	
	static int collatzIterativOutput(int n) {
		int index = 0;
		int value = n;
		
		System.out.println("\nMethode: collatzIterativOutput(" + Integer.toString(n) + ")\n");
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
				return index;
			// Wenn einer der besagten Fehler auftritt (IntegerMaxOverflow)
			} else if (index == 2147483647 || value == 2147483647 || value <= 0) {
				System.out.println("Integer.MaxValue");
				return 0;
			}
			index += 1;
		}
	}	
	
	static int [] collatzIterativ(int n) {
		// erzeuge ein Array mit der Länge 0 -> keine Eintrag möglich
		int[] values = new int[0];
		int value = n;
		System.out.println("\nMethode: collatzIterativ(" + Integer.toString(n) + ")\n");
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
				//System.out.println("Array: " + Arrays.toString(values));
				return values;
			} else if (values.length == 2147483647 || value == 2147483647 || value <= 0) {
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
				//System.out.println("ArrayList: " + values);
				return values;
			} else if (values.size() == 2147483647 || value == 2147483647 || value <= 0) {
				System.out.println("Integer.MaxValue");
				return null;
			}
			
		}
	}
	
}
