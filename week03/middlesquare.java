public class middlesquare {
    public static void main(String[] args) {
        System.out.print("Bitte geben Sie eine maximal 2-stellige Zahl ein: ");
        int a = StdIn.readInt();
        int s1 = 0;
        int s2 = 0;

        if (a < 0 || a >= 100) {
            System.out.print("Error!\n");
            return;
        }

        for (int i = 1; i <= 101; i++) {
            // a wird ausgegeben
            System.out.println(String. format("Durchlauf: %d\t| a: %d", i, a));
            // a wird quadiert (a*a)
            s2 = ((a*a)/10)%10;
            s1 = (((a*a)/10)/10)%10;
            // a wird aktualisiert
            a = s1*10+s2;
        }
    }
}
