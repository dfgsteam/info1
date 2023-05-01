import java.util.ArrayList;

public class OmittedNumbers{
    public static void main (String[] args){
        int n = Integer.parseInt(args[0]);
        if (n <= 0) {
        	System.out.println("Bitte gebe eine Zahl > 0 ein.");
        	return;
        }
        ArrayList<String> renter = new ArrayList<String>(); // Liste wird definiert
       	for (int r = 1; r <= n; r++) {
       		renter.add(Integer.toString(r));
       	}
       	//System.out.println(renter);
       	for (int k = 2; k < renter.size(); k++) { // Für jedes k wird abgezählt, und wenn k > die länge der Liste ist (Liste fängt ab 0 an zu zählen) kann kein Element entfernt werden
       		for (int item = renter.size(); item >= 1; item--) { //reverse zählen, damit die items sich nicht nach dem löschen verschieben und man außerhalb der (Array)Liste
			if (item%k == 0) { // wenn die position des items mod k = 0
       				renter.remove(item-1); // item -1 weil item ab 0 und nicht 1 anfängt
       			}
       		}
       	}
       	System.out.println(renter);
    }
}
   
