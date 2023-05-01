public class quersumme {
    	public static void main( String[] args ){
		int zahl = Integer.parseInt(args[0]);
		if (zahl < 1) {
                	System.out.println("ERROR: Nur natürliche Zahlen abgeben!");
                	return;
           	 }
		int zahl_original = zahl;
		int summe = 0;
		while (0 != zahl) {
			// addiere die letzte ziffer der uebergebenen zahl zur summe
			summe = summe + (zahl % 10);
			// entferne die letzte ziffer der uebergebenen zahl
			zahl = zahl / 10;
    		}
		System.out.println("Die Quersumme von '" + zahl_original + "' ist '" + summe  +"'");
    }
}
