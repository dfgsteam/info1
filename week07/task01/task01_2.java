public class task01_2 {
    public static void main (String[] args){ 
        String programm = args[0];
        if (programm.length() == 1){
            if (programm.equals("D")) {
                Dragon(Integer.parseInt(args[1]));
            } else if (programm.equals("R")) { 
                Random(Integer.parseInt(args[1]));
            } else {
                System.out.println("Du kein gültiges Programm ausgewählt! Bitte gebe \nD für Dragen oder \nR für Random an");
            }

        } else {
            System.out.println("Du hast ein falsches Format für die Programmauswahl angegeben! Bitte gebe \nD für Dragen oder \nR für Random an");
        }
    }

    private static void Dragon (int ordnung){
        String code = "";
        if ( ordnung < 0 || ordnung > 20) { // Überprüfe die Eingebene Zahl (laenge) mit den gegenen Grenzen
            System.out.println("error: wrong format");
        } else {
            for (int i = 0; i <= ordnung; i++) {
                if (i == 0) {
                    code += "F";
                } else {
                    String code_reverse = code;
                    code += "R";
                    for (int character = code_reverse.length()-1; character >= 0; character--) {
                        switch(code_reverse.charAt(character)) {
                            case 'F': code += 'F'; break;
                            case 'R': code += 'L'; break;
                            case 'L': code += 'R'; break;
                        }
                    }
                }
            }
            System.out.println(code.length());
            System.out.println(code);
        }
    }

    private static void Random (int laenge){
        String code = "";
        if ( laenge < 0 || laenge > 100000) { // Überprüfe die Eingebene Zahl (laenge) mit den gegenen Grenzen
            System.out.println("error: wrong format");
        } else {
            for (int i = 0; i < laenge; i++){
                int zufall = StdRandom.uniform(1, 4); // generiert einen Wert zwischen 1-3 (1,2,3). Die erste Zahl (1) in inklusiv und die zweite Zahl (4) ist exklusiv
                switch(zufall) {
				    case 1: code = code + "F"; break;
				    case 2: code = code + "L"; break;
				    case 3: code = code + "R"; break;
                }
            }
            System.out.println(code.length());
            System.out.println(code);
        }
    }
}
