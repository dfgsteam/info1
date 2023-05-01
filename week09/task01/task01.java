public class task01 {
	public static void main(String[] args) { //testunit
		Geld geld_a = new Geld(10, 350);
		Geld geld_b = new Geld(10, 351);
		System.out.println(geld_a.toString());
		System.out.println(geld_b.toString());
		if (geld_a.equals(geld_b)) {
			System.out.println("Gleicher Betrag");
		} else {
			System.out.println("Kein gleicher Betrag");
		}
		geld_a.add(geld_b);
		System.out.println(geld_a.toString());
	}

}



class Geld {
	//private int euro , cent ;
	public int euro , cent ;
	// Konstruktor
	public Geld ( int e , int c ) {
		euro = e ;
		cent = c ;
		cent_euro();
	}
	
	public void add(Geld g) {
		euro += g.euro;
		cent += g.cent;
		cent_euro();
	
	}
	
	public boolean equals (Geld g) {
		if (euro == g.euro) {
			if (cent == g.cent) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		String ret = euro + "," + (cent<10? "0" : "" )+ cent + " Euro"; //Wenn cent < 10 wird eine Null "davorgehangen"
		return ret;
	}
	
	private void cent_euro() {
		while (cent > 99) { // solange cent > 99 -> -100 cent; +1 euro
			euro += 1;
			cent -= 100;
		}
	}
}
