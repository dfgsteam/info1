import java.util.Arrays;

public class task02{
    public static void main (String[] args){
        if (args.length != 2) {
        	System.out.println("Du musst zwei Argumente angeben (Länge/Schritt)?");
        	return;
        }
        josephusPermutation(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        
    }
    
    private static int[] josephusPermutation(int length, int step) {
    	String[] first = new String[length]; // Kreis Array wird erstellt
    	int[] second = new int[length]; // Josephus-Permutation (JoPe) Array wird erstellt
    	for (int pos = 0; pos < first.length; pos++) { // Kreis Array wird mit "1sen" befüllt, so kann man sehen, welches noch existiert und welches nicht
    		first[pos] = "1";
    	}
    	System.out.println("Runde: INIT");
    	System.out.println("Kreis: " + Arrays.toString(first));
    	System.out.println("JoPe.: " + Arrays.toString(second));
    	
    	int pos = 0; // Position in Array (first, second) -> Woraus wir gerade zeigen
    	int number = 1; // Nummer der Position (1,2,3,4....)
    	int steplength = 1; // Schrittlänge -> auf der erste Schritt ist, im Array auf 0 zu zeigen
    	
    	
    	
    	while (Arrays.asList(first).contains("1")) { // Überprüfe ob noch eine "Zahl" im Kreis Array ist
    		System.out.println("--------------------");
    		System.out.println("Runde: " + number);
    		while(steplength != step) { // Überprüfe alle positionen zwischen dem schritt, ob iwo ein false liegt -> wird nicht gezählt
    			pos = (pos+1)%length;
    			if (first[pos] == "1") { // Wenn wir auf eine "0" (" ") zeigen (wert schon verschoben), müssen wir einen weiteren schritt machen, bis wir auf eine "1" zeigen
    				steplength++;
    			}
    		}
    		
    		steplength = 0; // Die anzahl der schritte wird zurückgesetzt
    		first[pos] = "x"; // Für den log (schönheit) -> wird später 0 gesetzt
    		second[pos] = number; // In den JoPe. wird die aktuelle Zahl eingesetzt
    		number++; // Die Zahl wird erhört
			System.out.println("Kreis: " + Arrays.toString(first));
			System.out.println("JoPe.: " + Arrays.toString(second));
    		first[pos] = " "; 
    	}
    	
    	
    	
    	
    	return second;
    }
    
    // kann nichts zurürckgeben?
    private static void josephusRecursive(int[] circle, int last, int step) {
    
    }
}
   
