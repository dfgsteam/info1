import java.util.Arrays;

public class drawcurve2 {
	public static void main (String[] args) {
		int schritte = StdIn.readInt();
		String bewegung_eingabe = StdIn.readString();
		// Wenn zu wenig Ausführungsschritte bekannt sind
		if (bewegung_eingabe.length() < schritte) {
			return;
		}
		char[] bewegung = new char[schritte]; // Array für alle eingegebenen Buchstaben aus dem String (genau mit maximalen Länge des schritte-int)
		int[] x = {0, 0}; // min|max X
		int[] y = {0, 0}; // min|max Y 
		int[] pos = {0, 0}; // Position des Strichs
		int dir = 3; // 0-unten, 1-links, 2-oben, 3-rechts -> In welche Richtung der Strich sich bewegt
		
		// für jeden Position im Eingabearray
		for(int i = 0; i < schritte; i++) {
			// Definiere den Buchstaben in dem Eingabestring in Großbuchstabe(n)
			char c = Character.toUpperCase(bewegung_eingabe.charAt(i));
			// Überprüfe auf ungültige Zeichen
			switch (c) {
				case 'F': break;
				case 'L': break;
				case 'R': break;
				default: 
					System.out.println("Es sind nur die Buchstaben F/L/R erlaubt!");
					return;	
			}
			// Setze den Buchstaben an die Position im (Buchstaben-)Array
			bewegung[i] = c;
		}
		
		// Simulation der Skalierung
		for (char item : bewegung) {
			// Je nach Richtung wird überprüft, ob es der bisher maximal bekannten äußersten Punkt überschreitet und anschließend mit dem neuen äußersten Punkt überschrieben
			if (item == 'F') {
				switch (dir) { 
					//x
					case 1: 
						pos[0] -= 1; 
						x[0] = pos[0] < x[0] ? pos[0] : x[0]; // elvis operator
						break;
					case 3:
						pos[0] += 1; 
						x[1] = pos[0] > x[1] ? pos[0] : x[1];
						break;
					
					// y
					case 0:
						pos[1] -= 1; 
						y[0] = pos[1] < y[0] ? pos[1] : y[0];
						break;
					case 2:
						pos[1] += 1; 
						y[1] = pos[1] > y[1] ? pos[1] : y[1];
						break;
				}
			// Verändere die Richtung um 90° nach Links oder Rechts. Die Zahl wird im Anschluss mit dem mod 4 gerechnet, damit man das "Verhältnis" behält und um die Grenzewerte von unter 0 und über 3 zu behalten. Nach 0 - 1 = 3 und 3 + 1 = 0
			} else if (item == 'L') {
				dir += 3;
				dir %= 4;
				
			} else if (item == 'R') {
				dir += 1;
				dir %= 4;
			}
		}
		
		// malen
		
		// Fenster + Stift definieren
		StdDraw.setPenRadius(0.002);
		StdDraw.setXscale(x[0]-1, x[1]+1); // Die Skallierung + bzw. - 1, damit um die Zeichnung ein eindeutiger Rand von einer Kästchenbreite ist - 1, damit um die Zeichnung ein eindeutiger Rand von einer Kästchenbreite ist
		StdDraw.setYscale(y[0]-1, y[1]+1); // Die Skallierung + bzw. - 1, damit um die Zeichnung ein eindeutiger Rand von einer Kästchenbreite ist
		
		// setze die Position zurück
		pos[0] = 0;
		pos[1] = 0;
		dir = 3;
		
		for (char item : bewegung) {
			// zeichne die Linien von aktueller Position zu neuer Position. Je nach richtung des Pfeils verändert sich die Richtung
			if (item == 'F') {
				switch (dir) {
					case 0: 
						StdDraw.line(pos[0], pos[1], pos[0], pos[1] - 1);
						pos[1] -= 1; 
						break; 
					case 1:
						StdDraw.line(pos[0], pos[1], pos[0] - 1, pos[1]);
						pos[0] -= 1;
						break; 
					case 2: 
						StdDraw.line(pos[0], pos[1], pos[0], pos[1] + 1);
						pos[1] += 1; 
						break; 
					case 3: 
						StdDraw.line(pos[0], pos[1], pos[0] + 1, pos[1]);
						pos[0] += 1; 
						break; 
				}
			// Verändere die Richtung um 90° nach Links oder Rechts. Die Zahl wird im Anschluss mit dem mod 4 gerechnet, damit man das "Verhältnis" behält und um die Grenzewerte von unter 0 und über 3 zu behalten. Nach 0 - 1 = 3 und 3 + 1 = 0
			} else if (item == 'L') {
				dir += 3;
				dir %= 4;
				
			} else if (item == 'R') {
				dir += 1;
				dir %= 4;
			}
		// Gib in der Konsole deine neue Position + Ausrichtung zur Kontrolle aus.
		System.out.println(Arrays.toString(pos) + "   \t| " + dir);
		}
	}
	
	
}
