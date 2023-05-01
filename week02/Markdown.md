## Informatik I, Übung 02, Aufgabe 2 von Julius Hunold

Markdown und Asciimath

## Größter gemeinsamer Teiler (ggT)

### Das ggT-Problem

**Gegeben.** Zwei positive ganze Zahlen $ a,b in ZZ $ mit $ a,b > 0.$

**Gesucht.** Eine positive ganze Zahl $ d in ZZ $ mit $ d > 0 $ und folgenden Eigenschaften.

* $ d $ teilt $ a $ und $ b $ ohne Rest
* es gibt keine ganze Zahl $ d' in ZZ $ mit $ d' > d $, die $ a $ und $ b $ ohne Rest teilt

### Der Euklidischer Algorithmus (klassisch)

**Eingabe.** zwei ganze Zahlen Sa,b$ mit $ a > b >= 0$

**Initialisierung.** $x larr a,y larr b$

**Iteration.** wiederhole das Folgende solange $y != 0$ gilt

* falls $(x > y)$ dann $ x larr x - y $
* sonst $y larr y - x$

**Abschluss.** $d larr x$

**Rückgabe.** $d$

*Hinweis.* $A larr B$ teht für: speichere aktuellen Wert von $B$ in $A$.

### Euklidischer Algorithmus in Java

        // Eklidischer Algorithmus (klassisch)
        // Eingabe von a und b
        // Initialisierung
        int x = a;
        int y = b;
        // Iteration
        while (y != 0) {    // ’!=’ steht fuer ’ungleich’
        if (x > y)
            x = x - y;
        else
        y = y - x;
        }
        // Abschluss
        int d = x
        // Rückgabe von d

# Aufgabe 2

        public class Aufgabe_ 2 quadrieren {
            public static void main( String[] args){
                int a = Integer.parseInt(args [0]);
                if (a < 0) {
                    System.out.println("nur positive Argumente");
                    return;
                }
                int b = 0;
                int c = 1;
                for (int i=0; i<a; i++) {
                    b = b + c;
                    c = c + 2;
                ]
                System.out.printin(b);
            }
        }

# Aufgabe 3

## Pseudocode in Pythoncode

        durchlauf = 0
        n = 10
        k = 7
        ergebnis = n - k + 1
        print(ergebnis)

        i = 2

        while i != k:
            ergebnis = ergebnis * (n-k+i)
            ergebnis = ergebnis/i
            i += 1
            durchlauf += 1
            print(f'Durchlauf {durchlauf}: ergebnis = {ergebnis}')
            print(f'Durchlauf {durchlauf}: i = {i}')
            
        print(f'Ergebnis: ergebnis = {ergebnis}')

## Programmausgabe

        Durchlauf 1: ergebnis = 10.0
        Durchlauf 1: i = 3
        Durchlauf 2: ergebnis = 20.0
        Durchlauf 2: i = 4
        Durchlauf 3: ergebnis = 35.0
        Durchlauf 3: i = 5
        Durchlauf 4: ergebnis = 56.0
        Durchlauf 4: i = 6
        Durchlauf 5: ergebnis = 84.0
        Durchlauf 5: i = 7
        Ergebnis: ergebnis = 84.0
