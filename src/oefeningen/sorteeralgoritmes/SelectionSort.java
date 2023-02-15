package oefeningen.sorteeralgoritmes;

/**
 * Dit algoritme begint vanaf een index i in het begin van de array.
 * Die index i representeert tot waar de array gesorteerd is.
 * Selection Sort zal steeds door heel de array gaan, beginnende van i+1, en
 * zoekt het kleinste element. Dit element zal verplaatst worden met i+1.
 * @author nicolasmonden
 *
 */
public class SelectionSort extends AlgoritmeBase {

	private boolean isSorted = false;
	
	public SelectionSort(int[] teSorteren) {
		super(teSorteren, "Selection Sort");
	}

	public void sorteer() {
		if(this.isSorted) 
			return;
		
		//System.out.println("Before: " + toString(teSorteren));

		for(int i = 0; i < teSorteren.length; i++) {
			selection(teSorteren, i);
		}
		
		//System.out.println("Rij: " + toString(teSorteren));
		//System.out.println("Lengte " + teSorteren.length + " ; " + compares);
	}
	
	/**
	 * @pre | teSorteren.length < start
	 * @param teSorteren
	 */
	private void selection(int[] teSorteren, int start) {
		if(teSorteren.length <= start) return;
		assert teSorteren.length > start;
		
		int smallestIndex = start;
		//Zoek het kleinste element
		for(int i = start+1; i < teSorteren.length; i++) {
			if(teSorteren[i] < teSorteren[smallestIndex])
				smallestIndex = i;
			compares++;
		}
		
		//Verplaats dit element met start
		int elementOpStart = teSorteren[start];
		teSorteren[start] = teSorteren[smallestIndex];
		teSorteren[smallestIndex] = elementOpStart;
		exchanges++;
	}
	
}
