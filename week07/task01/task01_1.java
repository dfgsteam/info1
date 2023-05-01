public class task01_1{
    public static void main (String[] args){
        String code = "";
        int laenge = Integer.parseInt(args[0]);
        if ( laenge < 0 || laenge > 100000) { // Überprüfe die Eingebene Zahl (laenge) mit den gegenen Grenzen
            System.out.println("falsches Zahlenformat!");
        } else {
            for (int i = 0; i < laenge; i++){
                int zufall = StdRandom.uniform(1, 4); // generiert einen Wert zwischen 1-3 (1,2,3). Die erste Zahl (1) in inklusiv und die zweite Zahl (4) ist exklusiv
                switch(zufall) {
				    case 1: code = code + "F"; break;
				    case 2: code = code + "L"; break;
				    case 3: code = code + "R"; break;
                }
            }
            System.out.println(code);
        }
    }
}
    
