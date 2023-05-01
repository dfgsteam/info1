public class TypeCasting {
	public static void main ( String [] args ) {
		short a =73;
		short b =219;
		short c = (a + b);
		int d = (byte) c;
		short e = -3;
		int f = (char) e;
		int g =1;
		int h =4;
		double i = g / h *4.0;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
	}
}
