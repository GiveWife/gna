package oefeningen.sorteeralgoritmes;

public class QuickSort extends AlgoritmeBase {

	public QuickSort(int[] teSorteren) {
		super(teSorteren, "Quick Sort");
		toggledebug();
	}
	
	@Override
	public void sorteer() {
		
		hoare(teSorteren, 0, teSorteren.length-1);
		//lomuto(teSorteren, 0, teSorteren.length-1);
	}
	
	public void hoare(int[] array, int low, int high) {
		System.out.println("low: " + low + ", high: " + high);
		if(high <= low) {
			System.out.println("low: " + low + ", high: " + high + ", STOPPED");
			return;
		}
		int pivot = partitionHoare(array, low, high);
		//System.out.println("Sorteren van " + low + ", tot " + (pivot-1));
		//System.out.println("Sorteren van " + (pivot+1) + ", tot " + (high));
		hoare(array, low, pivot-1);
		hoare(array, pivot+1, high);
	}

	public int partitionHoare(int[] array, int low, int high) {
		int pivot = array[low];

		// i + 1, since low is the pivot!
		int i = low+1, j = high;
		
		//System.out.println("---------- from " + low + " to " + high + " ------------");
		toString(array, "\n");

		while(i <= j) {
			// Search for an element bigger than the pivot starting from low+1
			while (array[i] <= pivot && i < high) {
				debug("Checking at index " + i + ": element " + array[i] + " <= " + pivot);
				i++;
			}
			if(i < high) debug("Check for i stopped at index " + i + " -> " + array[i] + " > " + pivot);
			else debug("i (" + i + ") not < " + high);

			// Search for an element smaller than pivot to switch with i
			while (array[j] > pivot && j > low) {
				debug("Checking at index " + j + ": element " + array[j] + " > " + pivot);
				j--;
			}
			debug("Check for j stopped at index " + j + " -> " + array[j] + " <= " + pivot);

			// Switch both elements. If i >= j, we break from this loop
			debug("Previous: " + getString(array));

			if(i < j) {
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}

			debug("After:    " + getString(array));

		} // Repeat this process until i >= j

		// If i == j, then the algorithm stopped immediately. Pivot should stay in place
		if(true/*i != j*/) {
			// Switch pivot & j or i element
			debug("Pivot change before: " + getString(array));
			array[low] = array[j];
			array[j] = pivot;
			debug("Pivot change after:  " + getString(array));
		}
		System.out.println("\n");

		if(j == low) return j++;
		else return j;
		
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
