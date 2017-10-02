import java.util.*;
public class Oblig1 {

	public static void main(String []args){
		int[] a = {};   // skal kaste unntak her!
	    int[] b = {1};  // skal ikke kaste unntak her!
	    int[] c = {1,1};
	    int[] d = {6,2,4,6,9,1,4,9,10};
	    int[] dkopi = {6,2,4,6,9,1,4,9,10};
	    int[] e = {5,4,3,2,1};
	    int[] f = {1,2,2,2,2,2,3};
	    System.out.println(modus2(dkopi));

	}

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
				System.out.println("y" + y);
				if (x >= s[y].length()) {
				} else {
					aaa.append(s[y].charAt(x));
				}
			}
		}

		return aaa.toString();
	}

	/* Oppgave 9
		// Summen av to tall er lik x?
	 */
}
