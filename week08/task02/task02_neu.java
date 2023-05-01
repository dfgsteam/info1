import java.util.Arrays;
public class task02_neu {
    public static void main (String[] args){
        if (args.length != 2) {
                System.out.println("Du musst zwei Argumente angeben (Länge/Schritt)?");
                return;
        }
        System.out.println(Arrays.toString(josephusPermutation(Integer.parseInt(args[0]), Integer.parseInt(args[1]))));
        
    }
    
    private static int[] josephusPermutation(int length, int step) {
        int[] circle = new int[length]; // Kreis Array wird erstellt
        for (int pos = 0; pos < circle.length; pos++) { // Kreis Array wird mit "1sen" befüllt, so kann man sehen, welche>
            circle[pos] = 0;
        }
        System.out.println("Runde 0: " + Arrays.toString(circle));
        josephusRecursive(circle, length-1, step);
        return circle;
    }
    
    private static void josephusRecursive(int[] circle, int last, int step) {
        int number = circle[last] + 1;
        int steplength = 0;
        int length = circle.length;
        while (steplength != step) {
            last = (last+1)%length;
            if (circle[last] == 0) {
                    steplength++;
            }
        }
        circle[last] = number;
        System.out.println("Runde " + number + ": " + Arrays.toString(circle));
        for (int pos : circle) {
            if (pos == 0) {
                josephusRecursive(circle, last, step);  // Wenn eine 0 im Array sein sollte 
            }
        }
    }
}
