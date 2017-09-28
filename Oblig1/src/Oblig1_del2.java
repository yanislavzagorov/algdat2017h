import java.util.Arrays;
import java.util.Random;

public class Oblig1_del2 {
    public static void main(String[] args){
        int[] a = randPerm(100000);

    }

    /* Oppgave 8
		// Sammenligning av effektivitetene til sorteringsalgoritmer
	 */
    public static void tidSorteringer(int[] a){

        /*
            a) Utvalgssortering;
            b) Innsettingssortering;
            c) Kvikksortering; og
            d) Flettesortering
         */
        
    }

    public static int[] randPerm(int n)
    {
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);
            bytt(a,k,i);
        }

        return a;
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    /* Oppgave 9
		// Summen av to tall er lik x?
	 */
}
