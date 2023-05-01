public class iterierte_quersumme {
    public static void main( String[] args ){
            int zahl_original = Integer.parseInt(args[0]);
            int summe = zahl_original;
            if (zahl_original < 1) {
                System.out.println("ERROR: Nur natürliche Zahlen abgeben!");
                return;
            }
            // solange die quersumme über 9 ist
            while (summe > 9) {
                int zahl = summe;
                summe = 0;
                while (0 != zahl) {
                        // addiere die letzte ziffer der uebergebenen zahl zur summe
                        summe = summe + (zahl % 10);
                        // entferne die letzte ziffer der uebergebenen zahl
                        zahl = zahl / 10;
                }
            }
                
            System.out.println("Die iterierte Quersumme von '" + zahl_original + "' ist '" + summe  +"'");
        }
}
