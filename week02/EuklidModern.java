public class EuklidModern {
    public static void main( String[] args ){ 
        int x = Integer.parseInt(args[0]); // Wertuebernahme von ...
        int y = Integer.parseInt(args[1]); // ... der Kommandozeile
        if ( x <= 0 || y <= 0)  { // '||' steht fuer 'oder'
            System.out.println("nur positive Argumente!!");
            return; // Ende
        }
	System.out.println("| line\t| x\t| y\t| r\t| comment");
        // ggT(x,y)                                    // M1
	System.out.println("| M1\t| " + x + "\t| " + y + "\t| -\t| ggT(" + x + ", " + y + ")");
        int r = -1;
        while ( y != 0 ) {                             // M2
	    if (r < 0) {
		System.out.println("| M2\t| " + x + "\t| " + y + "\t| -\t|   while(" + y + " != 0)");
	    	}
	    else {
	    	System.out.println("| M2\t| " + x + "\t| " + y + "\t| " + r + "\t|   while(" + y + " != 0)");
		}
            r = x % y;                                 // M3
	    System.out.println("| M3\t| " + x + "\t| " + y + "\t| " + r + " \t|     r = " + x + " % " + y);
            x = y;                                     // M4
	    System.out.println("| M4\t| " + x + "\t| " + y + "\t| " + r + " \t|     x = " + y);
            y = r;                                     // M5
	    System.out.println("| M5\t| " + x + "\t| " + y + "\t| " + r + " \t|     y = " + r);
        }
	System.out.println("| M2\t| " + x + "\t| " + y + "\t| " + r  + "\t|   while(" + y + " != 0)");
        //System.out.println(x);                         // M6
	System.out.println("| M6\t| " + x + "\t| " + y + "\t| -\t| = " + x);

        return;
    }
}
