import java.util.*;
public class Oblig1 {

	/*public static void main(String []args){
		int [] test = {10, 5, 11, 7, 3, 2, 8, 4, 17, 18};
		System.out.println("minsverdi: " + min(test));
		System.out.println("teller: " + ombyttinger(test));
	}*/

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

}
