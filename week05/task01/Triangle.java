/**
 * 
 *
 * nach [Sedgewick/Wayne]
 */

public class Triangle {
  public static void main(String[] args) {
    // 
    double s = Double.parseDouble(args[0]); // Seitenl. | Das Programm nimmt den Input des Programms (welcher beim Starten des Prgramm angegeben werden muss) und speichert ihn als double ab.
    double h = s * Math.sqrt(3.0)/2.0;      // Hoehe | Es wird die höhe des Programms berechnet, indem der Wert aus der Var. s multipliziert mit der Wurzel von 3, dividiert durch 2 wird. Das Ganze wird in dem double h gespeichert.
    StdDraw.line(0.0, 0.0,   s, 0.0);       // Basis | Es wird eine Linie von (0|0) zu (s|0) gezogen. Es ist die untere Seite die genau die eingegebe Seitenlänge lange ist/von dem Ursprung (0|0) entfernt ist.
    StdDraw.line(0.0, 0.0, s/2,   h);       // linke Seite | Es wird eine Linie von (0|0) zu (s/2|h) gezogen. Das ganze ist die obere Spitze, welche auch der hälfe der untere Kante auf der Höhe h liegt. Die Linie ist vor der linken Spitze zur oberen Spitze.
    StdDraw.line(  s, 0.0, s/2,   h);       // rechte Seite | Es wird eine Linie von (s|0) zu (s/2|h) gezogen. Das ganze ist die obere Spitze, welche auch der hälfe der untere Kante auf der Höhe h liegt. Die Linie ist vor der rechten Spitze zur oberen Spitze.
    StdDraw.setPenRadius(0.010);	    // | Es wird die Stärke des "Stiftes" bzw. die Linien-/Punkt dicke auf 0.010 festgelegt.
    StdDraw.point(s/2, h/3.0);              // Schwerpunkt | Der Schwerpunkt des Dreiecks wird auf (s/2|h/3) festgelegt.
  }
}
