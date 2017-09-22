public class Oblig1 {

	public static void main(String []args){
		int [] test = {10, 5, 1, 7, 3, 2, 8, 4, 17};
		System.out.println("minsverdi: " + min(test));
	}

	public static int min(int[] a){
		int minst = 0;
		for(int i = a.length-1; i > 0; i--){
			if(a[i] < a[i-1]){
				minst = a[i];
				a[i] = a[i-1];
				a[i-1] = minst;
			}

		}

		return a[0];
	}

	public static int ombyttinger(int[] tabell){

		return 0;
	}

}
