package oefeningen.sorteeralgoritmes;

public class CountingSort extends AlgoritmeBase {

	public int high, low;
	private boolean isInitialized = false;
	
	public CountingSort(int[] array) {
		super(array);
	}
	
	public void initialise(int high, int low) {
		this.high = high;
		this.low = low;
		isInitialized = true;
	}
	
	@Override
	public void sorteer() {
		if(!isInitialized) return;
		
		int[] count = new int[high];
		
		for(int i = 0; i < teSorteren.length; i++) {
			
		}
		
	}
	
}
