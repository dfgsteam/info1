public class Quadrat {   
    public static void main( String[] args){ 
        int a = Integer.parseInt(args[0]);
	if (a < 0) {
		a = a * -1;
	}
	int b = 0;
	int c = -1;
	for (int i = 1; i <=a; i++) {
		c = c+2;
		b += c;
	} 
	System.out.println(b);
    }
}
