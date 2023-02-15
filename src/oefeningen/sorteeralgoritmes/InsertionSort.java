package oefeningen.sorteeralgoritmes;

public class InsertionSort extends AlgoritmeBase {
	
	public InsertionSort(int[] teSorteren) {
		super(teSorteren, "Insertion Sort");
	}

	@Override
	public void sorteer() {
		//toString(teSorteren);
		
		for(int i = 0; i < teSorteren.length; i++) {
			
			int j = i;
			
			if(!(j > -1 && j < teSorteren.length-1 && teSorteren[j+1] < teSorteren[j])) {
				compares++;
			}
			
			while(j > -1 && j < teSorteren.length-1 && teSorteren[j+1] < teSorteren[j]) {
				int onthoud = teSorteren[j];
				teSorteren[j] = teSorteren[j+1];
				teSorteren[j+1] = onthoud;
				exchanges++;
				compares++;
				j--;
				//toString(teSorteren,"in between");
			}

		}
		
	}
	
	

	
}
