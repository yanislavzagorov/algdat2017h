import java.util.*;
public class Oblig1 {

	/*
		Sahand Nasiri 			- s315316
		Suphakin Riemprasert  	– s315572
		Ismail Killinc 			– s309734
		Yanislav Zagorov 		– s309732
		Irfanullah Nazand 		– s309731
	 */

	/* Oppgave 1
		// Finn den minste verdien
	 */
	public static int min(int[] a){
		if(a.length == 0){
			throw new NoSuchElementException("Arrayen er Tom!");
		}
		int plassHolder = 0;
		for(int i = a.length-1; i > 0; i--){
			if(a[i] < a[i-1]){
				plassHolder = a[i];
				a[i] = a[i-1];
				a[i-1] = plassHolder;
			}
		}
		return a[0];
	}

	public static int ombyttinger(int[] a){
		if(a.length == 0){
			throw new NoSuchElementException("Arrayen er Tom!");
		}
		int plassHolder;
		int teller = 0;
		for(int i = a.length-1; i > 0; i--){
			if(a[i] < a[i-1]){
				plassHolder = a[i];
				a[i] = a[i-1];
				a[i-1] = plassHolder;
				teller++;
			}
		}
		return teller;
	}

	/* Oppgave 2
		// Finn modus (engelsk: mode, som er det tallet som dukker opp flest ganger)
	 */
	public static int modus1(int[] a){
		if(sjekkStigende(a) == false) {


			if (a.length == 0) {
				throw new IllegalStateException("Tom array");
			} else if (a.length == 1) {
				throw new IllegalStateException("Kun 1 index");
			} else if (sjekkStigende(a) == false) {
				throw new IllegalStateException("Ikke stigende");
			}
		}
		int[] teller = new int[50];
		for(int i = 0; i < a.length; i++){
			teller[a[i]]++;
		}
		int index = teller.length-1;
		for(int i=teller.length-2; i >=0; i--) {
			if (teller[i] >= teller[index])
				index = i;
		}
		return index;
	}

	public static Boolean sjekkStigende(int[] a){
	    for(int i = 1; i < a.length; i++){
	    	if(a[i-1] > a[i]){
	    		return false;
	    	}
	    }
	    return true;
	}

	/* Oppgave 3
		// Finn modus, mer generelt
	 */
	public static int modus2(int[] a){
		int mod;
		if(a.length == 0){
			throw new IllegalStateException("Arrayen er Tom!");
		}
		else{
			if (altLikt(a) == true) {
				return a[0];
			}
			else{
				mod = a[0];
				for (int i = 1; i < a.length ; i++) {
					if (antallGjentagelse(a[i], a) > antallGjentagelse(a[i-1], a)) {
						mod = a[i];
					}
					else if (antallGjentagelse(a[i], a) == antallGjentagelse(a[i-1], a)) {
						if (a[i] > a[i-1]) {
							mod = a[i];
						}
					}
				}
			}
		return mod;
		}
	}

	public static int antallGjentagelse(int tall, int[] a){
		int teller = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] == tall){
				teller++;
			}
		}
		return teller;
	}
	public static boolean altLikt(int[] a){
		boolean flag = true;
		int first = a[0];
			for (int i = 1; i < a.length && flag ; i++) {
				if (a[i] != first) {
					flag = false;
				}
			}
		return flag;
	}


	/* Oppgave 4
		// Delsortering
	 */
	public static void delsortering(int[] a) {
		int v = 0;
		int h = a.length - 1;
		if (a.length == 0) { // vis tabellen er tom kastes unntak

		}

		else {
			while (true) {
				while ((v <= h) && (a[v] % 2 != 0)) {
					// oddetall
					v++;

				}
				while ((v <= h) && (a[h] % 2 == 0)) {
					//partall
					h--;

				}
				if (v <= h) { //bytt
					int temp = a[v];
					a[v] = a[h];
					a[h] = temp;
					v++;
					h--;


				} else break;

			}
			Arrays.sort(a, 0, v);
			Arrays.sort(a, v, a.length);


		}
	}




	/*
		int plassHolder, teller;
		teller = 0;
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			if (tallType(a[i]) == false) {
				plassHolder = a[teller];
				a[teller] = a[i];
				a[i] = plassHolder;
				teller++;
			}
		}
		Arrays.sort(a, teller, a.length);


		System.out.println(Arrays.toString(a));
	}//end class

	public static boolean tallType(int a){
		if(a % 2 == 0){
			return true; //er partall
		}else{
		return false; //er oddetall
		}
	}


	/* Oppgave 5
		// Rotering
	 */
	public static void rotasjon(char[] a){
		char[] secondArray = new char[a.length];
		for(int i = 0; i <= a.length-1; i++){ 
			secondArray[(i+1) % a.length] = a[i];
		}
		for (int j = 0; j < a.length ; j++) {
			a[j] = secondArray[j];
		}
	}
	

	// Oppgave 6
		// Rotering, mer generelt
	 
         public static void rotasjon(char[]arr, int k){ // BAS SIN KODE
        int n = arr.length;
        if (n < 2) return;  //Sjekker om tabellen er tomt eller har kun en verdi

        if ((k %= n) < 0) k += n;

        if (k <= (n+1)/2) // k enheter vil bli forskyvd mot h�yre
        {
            char[] b = Arrays.copyOfRange(arr, n - k, n);
            for (int i = n - 1; i >= k; i--) arr[i] = arr[i - k];
            System.arraycopy(b, 0, arr, 0, k);
        }
        else //k blir forskyvd mot venstre der n - k enheter mot venstre
        {
            char[] b = Arrays.copyOfRange(arr, 0, n - k);
            for (int i = 0; i < k; i++) arr[i] = arr[i + n - k];
            System.arraycopy(b, 0, arr, k, n - k);
        }
    }
	/* Oppgave 7
		// Fletting
	 */
	public static String flett(String s, String t){
		int sCount = 0;
		int tCount = 0;
		int k = 0;
		String u = new String();

		while(sCount<s.length() && tCount < t.length()){
			u = u + s.charAt(sCount++);
			u = u + t.charAt(tCount++);
		}

		while(sCount < s.length()){
			u = u + s.charAt(sCount++);
		}
		while(tCount < t.length()){
			u = u + t.charAt(tCount++);
		}

		return u;
	}

	public static String flett(String...s){
		StringBuilder aaa = new StringBuilder();

		for(int x = 0; x <= s.length+1; x++){								
			for(int y = 0; y < s.length; y++) {
				if (x >= s[y].length()) {
				} else {
					aaa.append(s[y].charAt(x));
				}
			}
		}

		return aaa.toString();
	}


	//
	//      HJELPEMETODER i tilfelle at brukeren ikke har tilgang til Tabell.java
	//		Metoder hentet fra www.cs.hioa.no/~ulfu/appolonius/
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
