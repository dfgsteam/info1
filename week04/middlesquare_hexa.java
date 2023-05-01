// Zusammen mit Langwost und Will erstellt


public class middlesquare_hexa {
	public static void main(String[] args) {
		System.out.print("Welches Zahlenformat möchtest du wählen?\n1\tDezimalzahl\n2\tHexdezimal\n\nAuswahl: ");
		int auswahl = StdIn.readInt();
		long zahl_int = 0;
		String zahl = "";
		if (auswahl == 1) {
			System.out.print("Dezimaleingabe: ");
			long int_zahl = StdIn.readInt();
			if (int_zahl < 0) {
				int_zahl *= -1;
			}
			zahl = Long.toHexString(int_zahl).toUpperCase();

		} else if (auswahl == 2) {
			System.out.print("Hexadezimaleingabe: ");
			zahl = StdIn.readString().toUpperCase();
		} else {
			System.out.println("Du hast eine ungültige Eingabe gewählt. Versuche es beim nächsten mal erneut ;)");
			return;
		}

		if (zahl.length() != 4) {
			System.out.println(String.format("Deine Hexadezimalzahl '%s' ist nicht vierstellig! Bitte gebe eine kompatieble Zahle ein!", zahl));
			return;
		}
		//System.out.println(zahl);
		System.out.println("Durchlauf\t| Hex.\t| Dezimal");
		System.out.println("---------------\t| -----\t| -------");
		zahl_int = Long.parseLong(zahl, 16);
		
		// Das ganze hat 101 Durchläufe
		for (int i=0; i <= 101; i++) {
			// Zahlenausgabe
			while (zahl.length() < 4) {
                                zahl = "0" + zahl;
                        }
			System.out.println(String.format("Durchlauf: %s\t| x%s\t| %s", i, zahl, zahl_int));
			
			
			// Die Zahl wird quadriert
			zahl = Long.toHexString(Long.parseLong(zahl, 16)*Long.parseLong(zahl, 16));
			
			// Wenn die Zahl unter 4 Zeichen fällt, wird diese mit Nullen aufgefüllt
			while (zahl.length() < 4) {
                                zahl = "0" + zahl;
                        }
                        
                        // Die beiden mittleren Zahlen werden miteinander multipliziert und wieder in eine Hex umgewandelt wird
                       	zahl_int = Long.parseLong(zahl.substring(1,3), 16)*Long.parseLong(zahl.substring(1,3), 16);
			zahl = Long.toHexString(zahl_int).toUpperCase();
			
                        
		}

		return;
	}
}
