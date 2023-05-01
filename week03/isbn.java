public class isbn {
	public static void main( String[] args ){
			System.out.print("Gib eine 10-stellige ISBN an:\t");
			int zahl = StdIn.readInt();
			int zahl_original = zahl;
			if (zahl <= 10000000) {
				System.out.println("Bitte gebe eine gültige ISBN an.");
				return;
			}
			int gewichtete_quersumme = gewichtete_quersumme(zahl);

			int iterierte_alternierende_quersumme = iterierte_alternierende_quersumme(zahl = gewichtete_quersumme);

			if (iterierte_alternierende_quersumme == 10) {
				System.out.println("Die Prüfziffer von der ISBN'" + zahl_original + "' ist 'X'");
			}
			else {
				System.out.println("Die Prüfziffer von der ISBN'" + zahl_original + "' ist '" + iterierte_alternierende_quersumme  +"'");
			}	
	}

	public static int gewichtete_quersumme(int zahl) {
		int summe = 0;
		for (int i = 9; i > 0; i--) {
			summe += i * (zahl % 10);
			zahl /= 10;
		}
		return summe;
	}

	public static int iterierte_alternierende_quersumme(int zahl) {
		int summe = 0;
		while (0 < zahl) {
			if (0 < zahl) {
				summe += zahl % 10;
				zahl /= 10;
			}
			if (0 < zahl) {
				summe -= zahl % 10;
				zahl /= 10;
			}
			if (11 <= summe && zahl == 0) {
				zahl += summe;
				summe = 0;
			}
		}
		while (summe < 0){
			summe += 11;
		}
		return summe;
	}
}
