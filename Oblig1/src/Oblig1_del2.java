import java.util.Arrays;
public class Oblig1_del2 {

	/*
		Sahand Nasiri 			- s315316
		Suphakin Riemprasert  	– s315572
		Ismail Killinc 			– s309734
		Yanislav Zagorov 		– s309732
		Irfanullah Nazand 		– s309731
	 */

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

        int[] a = randPerm(100000);
        tidSorteringer(a);
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
        Oblig1.utvalgssortering(kopi1);
        long tid1b = System.nanoTime() - tid1a;
        System.out.println("a) Utvalgssortering: " + tid1b/1000000 + " millisekunder.");

        long tid2a = System.nanoTime();
        Oblig1.innsettingssortering(kopi2);
        long tid2b = System.nanoTime() - tid2a;
        System.out.println("b) Innsettingssortering: " + tid2b/1000000 + " millisekunder.");

        long tid3a = System.nanoTime();
        Oblig1.kvikksortering(kopi3);
        long tid3b = System.nanoTime() - tid3a;
        System.out.println("c) Kvikksortering: " + tid3b/1000000 + " millisekunder.");

        long tid4a = System.nanoTime();
        Oblig1.flettesortering(kopi4);
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
}

