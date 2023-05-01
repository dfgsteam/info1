public class lieblingszahl {
	public static void main(String[] args) {
		for (int zahl = 1; zahl < 1000; zahl++) {
			if (zahl%6 == 0 && zahl%7 == 0 && zahl%4 != 0) {
				int quersumme = quersumme(zahl);
				if (quersumme == 6){
					System.out.println("Deine Lieblingszahl ist: " + zahl);
					return;
				}
			}
		}
	}

	public static int quersumme(int zahl) {
		int quersumme = 0;
		while (zahl != 0) {
			quersumme +=  zahl%10;
			zahl = zahl/10;
		}
		return quersumme;
	}
}
