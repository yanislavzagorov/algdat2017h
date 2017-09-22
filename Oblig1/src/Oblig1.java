import java.util.*;
public class Oblig1 {

	public static void main(String []args){
		int [] test = {4, 9, 3, 6, 1, 5, 7, 8, 10, 2};
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
	 	if(a.length == 0 || a.length == 1 || sjekkStigende(a) == false){
			throw new IllegalStateException("Tom, kun 1 verdi eller ikke stigende");
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
	    int counter = 0;

	    for (int i = 0; i < a.length-1; i++) {
	        if(a[i] < a[i+1] || a[i] == a[i+1]){
	            counter++;
	        }
	    }
	    if(counter == a.length-1){
	        return false;
	    }else{ 
	    	return true;
	    }
	}
}
