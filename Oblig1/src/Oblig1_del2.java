import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Oblig1_del2 {
    public static void main(String[] args){
        /* Oppgavetekst:
        *
        **  Oppgave 8:
        *
        * Vi har valgt å bruke System.nanoTime framfor System.currentTimeMillis()
        * for den er mer nøyaktig ved små verdier (<15ms).
        * På enheten min ser vi at Utvalgssortering er definitivt den treigeste
        * sorteringsmetoden og tar nesten to sekunder for å utføres. Kvikksortering
        * er 140x kjappere enn Utvalgssortering, og Innsettingssortering og
        * Flettesortering tar nesten like lang tid med en marginal forskjell hos
        * Innsettingssorteringen som vinner testen ca hver 10. gang.
        *
        ** Utskrift 8:
            a) Utvalgssortering: 1897 millisekunder.
            b) Innsettingssortering: 2 millisekunder.
            c) Kvikksortering: 15 millisekunder.
            d) Flettesortering: 2 millisekunder.
        *
        *================================================================================
        **  Oppgave 9:
        *
        * Kodesnutten under returner først kombinasjonen [10, 16], og deretter null
        * dersom det ikke er noe par som summeres til 26.
        *
        ** Utskrift 9:
            Kombinasjon funnet! - [10, 16]
            null
        *
        */

        //Oppgave 8
        int[] a = randPerm(100000);
        tidSorteringer(a);

        //Oppgave 9
        int[] b = {2,3,7,10,16};
        System.out.println("Kombinasjon funnet! - " + Arrays.toString(sumX(b,26)));
        System.out.println(Arrays.toString(sumX(b, 27)));
    }

    /* Oppgave 8
		// Sammenligning av effektivitetene til sorteringsalgoritmer
	 */
    public static void tidSorteringer(int[] a){
        int[] kopi1 = a;
        int[] kopi2 = a;
        int[] kopi3 = a;
        int[] kopi4 = a;

        long tid1a = System.nanoTime();
        utvalgssortering(kopi1);
        long tid1b = System.nanoTime() - tid1a;
        System.out.println("a) Utvalgssortering: " + tid1b/1000000 + " millisekunder.");

        long tid2a = System.nanoTime();
        innsettingssortering(kopi2);
        long tid2b = System.nanoTime() - tid2a;
        System.out.println("b) Innsettingssortering: " + tid2b/1000000 + " millisekunder.");

        long tid3a = System.nanoTime();
        kvikksortering(kopi3);
        long tid3b = System.nanoTime() - tid3a;
        System.out.println("c) Kvikksortering: " + tid3b/1000000 + " millisekunder.");

        long tid4a = System.nanoTime();
        flettesortering(kopi4);
        long tid4b = System.nanoTime() - tid4a;
        System.out.println("d) Flettesortering: " + tid4b/1000000 + " millisekunder.");
    }

    /* Oppgave 9
		// Summen av to tall er lik x?
	 */
    public static int[] sumX(int[] a, int x) {
        int tempverdi;
        for (int i = 0; i < a.length; i++) {
            tempverdi = i;
            for (int j = 0; j < a.length; j++) {
                if (a[i] + a[j] == x) {
                    return new int[]{a[i], a[j]};
                }
            }

        }
        return null;
    }


    //
    //      HJELPEMETODER i tilfelle at brukeren ikke har tilgang til Tabell.java
    //
    public static void kvikksortering(int[] a)
    {
        kvikksortering0(a, 0, a.length - 1);
    }

    public static void utvalgssortering(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length));
    }

    public static void innsettingssortering(int[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            int temp = a[i];  // hjelpevariabel
            for (int j = i - 1; j >= 0 && temp < a[j]; j--) bytt(a, j, j + 1);
        }
    }

    public static void flettesortering(int[] a)
    {
        int[] b = Arrays.copyOf(a, a.length/2);   // en hjelpetabell for flettingen
        flettesortering(a,b,0,a.length);          // kaller metoden over
    }

    public static int[] randPerm(int n) {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--) {
            int i = r.nextInt(k + 1);
            bytt(a, k, i);
        }

        return a;
    }

    public static void bytt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int min(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = fra;
        int minverdi = a[fra];

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] < minverdi)
            {
                m = i;
                minverdi = a[m];
            }
        }

        return m;
    }

    private static int parter0(int[] a, int v, int h, int skilleverdi)
    {
        while (true)                                  // stopper når v > h
        {
            while (v <= h && a[v] < skilleverdi) v++;   // h er stoppverdi for v
            while (v <= h && a[h] >= skilleverdi) h--;  // v er stoppverdi for h

            if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
            else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
    }

    private static int sParter0(int[] a, int v, int h, int indeks)
    {
        bytt(a, indeks, h);           // skilleverdi a[indeks] flyttes bakerst
        int pos = parter0(a, v, h - 1, a[h]);  // partisjonerer a[v:h − 1]
        bytt(a, pos, h);              // bytter for å få skilleverdien på rett plass
        return pos;                   // returnerer posisjonen til skilleverdien
    }

    private static void kvikksortering0(int[] a, int v, int h)  // en privat metode
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = sParter0(a, v, h, (v + h)/2);  // bruker midtverdien
        kvikksortering0(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        kvikksortering0(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }

    public static void kvikksortering(int[] a, int fra, int til) // a[fra:til>
    {
        fratilKontroll(a.length, fra, til);  // sjekker når metoden er offentlig
        kvikksortering0(a, fra, til - 1);  // v = fra, h = til - 1
    }

    private static void flett(int[] a, int[] b, int fra, int m, int til)
    {
        int n = m - fra;                // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n);  // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;      // løkkeST0r og indekser

        while (i < n && j < til)        // fletter b[0:n> og a[m:til> og
        {                               // legger resultatet i a[fra:til>
            a[k++] = b[i] <= a[j] ? b[i++] : a[j++];
        }

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    private static void flettesortering(int[] a, int[] b, int fra, int til)
    {
        if (til - fra <= 1) return;   // a[fra:til> har maks ett element
        int m = (fra + til)/2;        // midt mellom fra og til

        flettesortering(a,b,fra,m);   // sorterer a[fra:m>
        flettesortering(a,b,m,til);   // sorterer a[m:til>

        if (a[m-1] > a[m]) flett(a,b,fra,m,til);  // fletter a[fra:m> og a[m:til>
    }
}

