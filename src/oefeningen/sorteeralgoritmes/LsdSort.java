package oefeningen.sorteeralgoritmes;

public class LsdSort {
	
	private String[] a;

	public LsdSort(String[] a) {
		this.a = a;
	}
	
	private void createArray() {
		int r[] = new int[256];
		for(int i = 0; i < 256; i++) {
			r[i] = i+1;
		}
		toString(r);
	}
	
	public void sort(int w) {
		
		int n = a.length;
		int r = 256;
		String[] aux = new String[n];
		
		for(int d = w-1; d >= 0; d--) {
			
			int[] count = new int[r+1];//+1 +1 !!!!!!!!! als a voorkomt, tel b op. Wanneer er terug wordt gezet
			for(int i = 0; i < n; i++) // 				 dan kijk je eerst bij a, wat dus 0 is, ipv 1
				count[a[i].charAt(d) + 1]++; //ASCII value warom +1 (omdat we van nul beginnen bij het inzetten in aux)
			
			toStringWithSpace(count);
			
			createArray();
			
			for(int q = 0; q < r; q++)
				count[q+1] += count[q]; //Accumuleer
			toStringWithSpace(count);
			
			for(int i = 0; i < n; i++) {
				int b = count[a[i].charAt(d)];
				System.out.println(i + " op: " + b++ + " komt " + a[i]);
				aux[count[a[i].charAt(d)]++] = a[i];
				toStringWithSpace(count);
			}
			toString(aux);
			
			for(int i = 0; i < n; i++) 
				a[i] = aux[i];
			toString(a);
			
			System.out.println("\n\n\n\n");
		}
		
	
		
	}
	
	public void toStringWithSpacePre(int[] array, String pre) {
		String printOut = "";
		for(int i = 0; i < array.length; i++) { 
			printOut = printOut + array[i] + "," + getSpace(i+2);
		}
		System.out.println(pre + printOut);
	}
	
	public void toStringWithSpace(int[] array) {
		String printOut = "";
		for(int i = 0; i < array.length; i++) { 
			printOut = printOut + array[i] + "," + getSpace(i+2);
		}
		System.out.println(printOut);
	}
	
	public void toString(int[] array) {
		String printOut = "";
		for(int i = 0; i < array.length; i++) { 
			printOut = printOut + array[i] + ", ";
		}
		System.out.println(printOut);
	}
	
	private String getSpace(int i) {
		if(i <= 10) return " ";
		if(i > 10 && i <= 100) return "  ";
		if(i > 100 && i <= 1000) return "   ";
		return " ";
	}
	
	public void toString(String[] array) {
		String printOut = "";
		for(int i = 0; i < array.length; i++) {
			printOut = printOut + array[i] + ", ";
		}
		System.out.println(printOut);
	}
	
	
	
}
