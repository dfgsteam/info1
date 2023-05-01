public class uebung01 {
    public static void main(String args[]) {
      foo(4);
    }
    
    public static void foo ( int x ) {
        boolean b = true ;
        int t = 2;
        System.out.println(( t * t <= x ) && b );
        while (( t * t <= x ) && b ) {
            System.out.println('1');
            b = (( x % t ) != 0);
            t ++;
        }
        boolean res = ( b && ( x != 1));
        System.out.println(res);
        //return true;
    }
}
