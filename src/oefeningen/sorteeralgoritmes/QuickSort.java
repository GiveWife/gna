package oefeningen.sorteeralgoritmes;

public class QuickSort extends AlgoritmeBase {

	public QuickSort(int[] teSorteren) {
		super(teSorteren);
	}
	
	@Override
	public void sorteer() {
		
		hoare(teSorteren, 0, teSorteren.length-1);
		//lomuto(teSorteren, 0, teSorteren.length-1);
	}
	
	public void hoare(int[] array, int low, int high) {
		if(high <= low) return;
		int pivot = partitionHoare(array, low, high);
		//System.out.println("Sorteren van " + low + ", tot " + (pivot-1));
		//System.out.println("Sorteren van " + (pivot+1) + ", tot " + (high));
		hoare(array, low, pivot-1);
		hoare(array, pivot, high);
		
	}
	
	public int partitionHoare(int[] array, int low, int high) {
		int pivot = array[low];
		
		int i = low+1, j = high;
		
		//System.out.println("---------- from " + low + " to " + high + " ------------");
		//toString(array, "\n");
		
		while(i < j) {
			
			if(!(array[i] < pivot)) compares++;
			while(i < j && array[i] < pivot) {
				i++;
				compares++;
				//System.out.println("i = " + i);
			}
			
			if(!(array[j] >= pivot)) compares++;
			while(j > i && array[j] >= pivot) {
				j--;
				//System.out.println("j = " + j);
				compares++;
			}
			
			if(i < j) {
				//verander de elementen
				int elementAti = array[j];
				array[j] = array[i];
				array[i] = elementAti;
				exchanges++;
				//System.out.println("Element i en j verwisseld: " + array[j] + "," + array[i]);
			}
			
		}

		System.out.println("low: " + low + ", high: " + high);
		if(j-1 > low && j -1 < high) {
			System.out.println("are equal: " + (i==j) + ", i: " + i + ", j:" + j);
			int laatsteElement = array[j-1];
			array[j-1] = pivot;
			array[low] = laatsteElement;
			exchanges++;
		} else System.out.println("IF SKIPPED: " + ", i: " + i + ", j:" + j);
		
		System.out.println("Result:");
		//Main.toString(teSorteren);
		System.out.println("\n\n\n");
		//j == i
		return j;
		
	}

	public void lomuto(int[] array, int low, int high) {
		if(!(low >= high)) {
			int p = partitionLomuto(array, low, high);
			lomuto(array, low, p-1);
			lomuto(array, p+1, high);
		}
	}
	
	public int partitionLomuto(int[] array, int low, int high) {
		
		int pivot = array[high];
		int i = low;
		
		for(int k = low; k < high; k++) {
			if(array[k] <= pivot) {
				int onthoud = array[k];
				array[k] = array[i];
				array[i] = onthoud;
				exchanges++;
				i++;
			}
			compares++;
		}
		
		int onthoud = array[i];
		array[i] = array[high];
		array[high] = onthoud;
		exchanges++;
		
		return i;
		
	}
	
	public boolean pre() {
		return teSorteren.length > 0;
	}
	
}
