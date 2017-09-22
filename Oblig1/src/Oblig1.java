import java.util.*;
public class Oblig1 {

	public static void main(String []args){
		int [] test = {1,2,3,4,5,6,7,7};
		System.out.println("sjekkStigende: " + sjekkStigende(test));
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
		int modus = antallGjentagelse(a[1],a);
		for(int i = 1; i < a.length; i++){
			if(antallGjentagelse(a[i], a) > antallGjentagelse(a[i-1], a)){
				modus = antallGjentagelse(a[i-1], a);
			}
		}
		return modus;
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
}
