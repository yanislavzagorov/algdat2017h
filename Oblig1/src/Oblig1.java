import java.util.*;
public class Oblig1 {

	public static void main(String []args){
		char [] d = new char[]{'A','B','C','D','E','F','G','H','I','J'};
		Oblig1.rotasjon(d,-6);
		System.out.print(Arrays.toString(d));
	}

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

	 public static int modus1(int[] a){
		/*if(a.length == 0 || a.length == 1 || sjekkStigende(a) == false){
			throw new IllegalStateException("Tom, kun 1 verdi eller ikke stigende");
		}*/
		if(a.length == 0){
			throw new IllegalStateException("Tom array");
		}
		else if(a.length == 1){
			throw new IllegalStateException("Kun 1 index");
		}
		else if(sjekkStigende(a) == false){
			throw new IllegalStateException("Ikke stigende");
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

	public static int modus2(int[] a){
		if(a.length == 0){
			throw new IllegalStateException("Arrayen er Tom!");
		}
		if(a.length == 1){
			throw new IllegalStateException("Arrayen har kun 1 index!");
		}
		int modus = antallGjentagelse(a[0],a);
		int tall = 0;
		for(int i = 1; i < a.length; i++){
			if(antallGjentagelse(a[i], a) > modus){
				modus = antallGjentagelse(a[i], a);
				tall = a[i];
			}
		}
		return tall;
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

	public static void delsortering(int[] a){
		int plassHolder, plassHolder2, teller;
		teller = 0; 
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++){
			if(tallType(a[i]) == false){
				plassHolder = a[teller];
				a[teller] = a[i];
				a[i] = plassHolder;
				teller++;
			}
		}		
		Arrays.sort(a, teller, a.length);	
        System.out.print(Arrays.toString(a));
	}
	public static boolean tallType(int a){
		if(a % 2 == 0){
			return true; //er partall
		}else{
		return false; //er oddetall
		}
	}
	public static void rotasjon(char[] a){
		char[] secondArray = new char[a.length];
		for(int i = 0; i <= a.length-1; i++){ 
			secondArray[(i+1) % a.length] = a[i];
		}
		for (int j = 0; j < a.length ; j++) {
			a[j] = secondArray[j];
		}
	}
	public static void rotasjon(char[] a, int k){
		char[] secondArray = new char[a.length];
		char[] thirdArray = new char[a.length];
		if(k > 0){
			for(int i = 0; i < a.length; i++){ 
			secondArray[(i+k) % a.length] = a[i];
			}
			for (int j = 0; j < a.length ; j++) {
				a[j] = secondArray[j];
			}
		}
		if(k < 0){
			for(int m = 0; m < a.length; m++){ 
			thirdArray[(m-k) % a.length] = a[m];
			}
			for (int n = 0; n < a.length ; n++) {
				a[n] = thirdArray[n];
			}
		}	
	}
}
