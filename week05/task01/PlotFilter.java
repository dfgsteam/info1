/**
 * 
 *
 * nach [Sedgewick/Wayne]
 */

public class PlotFilter {
    public static void main(String[] args) {
	if ( args.length > 0) {
	    int m = Integer.parseInt(args[0]);
	    StdDraw.setPenRadius(m * 0.005);
	}
	// lies erste 4 Werte der Standardeingabe:
	double x0 = StdIn.readDouble(); // x von ..
	double x1 = StdIn.readDouble(); // .. bis
	double y0 = StdIn.readDouble(); // y von ..
	double y1 = StdIn.readDouble(); // .. bis
	// skaliere damit die Leinwand
	StdDraw.setXscale(x0,x1);
	StdDraw.setYscale(y0,y1);
	// solange Eingaben vorhanden ...
	while (!StdIn.isEmpty()) {
	    // lies paarweise und zeichne den Punkt
	    double x = StdIn.readDouble();
	    double y = StdIn.readDouble();
	    
	    StdDraw.point(x,y);
	}
    }  
}
