import java.util.Arrays;
import java.util.Random;

public class Oblig1_del2 {
    /* Oppgave 8
		// Sammenligning av effektivitetene til sorteringsalgoritmer
	 */
    public static void tidSorteringer(int[] a) {
        int[] b = randPerm(4);
        System.out.println(b[0]);
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

    /* Oppgave 9
		// Summen av to tall er lik x?
	 */
    public static int[] sumX(int[] a, int x) {
        if (Oblig1.sjekkStigende(a) == false) {
            throw new IllegalArgumentException("ikke sortert");
        } else {
            for (int i = 0; i < a.length; i++) {
                a[i] = i;
                for (int j = 0; j < a.length; j++) {
                    if (a[i] + a[j] == x) {

                        return new int[]{a[i], a[j]};
                    }
                }

            }
            return null;
        }
    }
}

