package oefeningen.sorteeralgoritmes;

public class MergeSort extends AlgoritmeBase {
	
	public MergeSort(int[] teSorteren) {
		super(teSorteren);
	}
	
	@Override
	public void sorteer() {
		mergeSort(teSorteren);
	}
	
	public void mergeSort(int[] array) {
		if(array.length <= 1) return; //Algoritme is klaar
		
		//Middel en links en rechtse array
		int middle = getMiddle(array);
		int[] arrayLeft = new int[middle];
		int[] arrayRight = new int[array.length - middle];
		
		//Vul de arrays
		for(int i = 0; i < array.length; i++) {
			if(i < arrayLeft.length) {
				arrayLeft[i] = array[i];
				exchanges++;
			}
			if(i >= arrayLeft.length) {
				arrayRight[i - arrayLeft.length] = array[i];
				exchanges++;
			}
		}
		
		//Sorteer deze arrays
		mergeSort(arrayLeft);
		mergeSort(arrayRight);
		
		//toString(arrayLeft, "left: ");
		//toString(arrayRight, "right: ");
		
		//Zet in array arrayLeft en arrayRight samen. array is immers een splitsing van left en right!!!!!!
		int arrayLeftCounter = 0;
		int arrayRightCounter = 0;
		
		for(int i = 0; i < array.length; i++) {
		
			//ArrayLeftCounter is overlopen?
			if(!(arrayLeftCounter < arrayLeft.length) && arrayRightCounter < arrayRight.length) {
				//log("  1  Picked right element: " + arrayRight[arrayRightCounter] + ", i  " + arrayLeftCounter + ", " + arrayRightCounter);
				//System.out.println(i + " DEBUG 1 " + arrayLeftCounter + " !< " + arrayLeft.length + " && " + arrayRightCounter + " < " + arrayRight.length);
				array[i] = arrayRight[arrayRightCounter++];
			}
			
			//ArrayRightCounter is overlopen?
			else if(!(arrayRightCounter < arrayRight.length) && arrayLeftCounter < arrayLeft.length) {
				//log("  2  Picked left element: " + arrayLeft[arrayLeftCounter] + ", i  " + arrayLeftCounter + ", " + arrayRightCounter);
				//System.out.println(i + " DEBUG 2 " + arrayRightCounter + " !< " + arrayRight.length + " && " + arrayLeftCounter + " < " + arrayLeft.length);
				array[i] = arrayLeft[arrayLeftCounter++];
			}
			
			//Als beiden niet overlopen zijn, neem de hoogste uit de array
			else if(arrayLeft[arrayLeftCounter] <= arrayRight[arrayRightCounter]) { 
				//log("  3  Picked left element: " + arrayLeft[arrayLeftCounter] + " over " + arrayRight[arrayRightCounter] + ", i  " + arrayLeftCounter + ", " + arrayRightCounter);
				//System.out.println(i + " DEBUG 3 " + arrayLeftCounter + " < " + arrayLeft.length + " && " + arrayRightCounter + " < " + arrayRight.length);
				array[i] = arrayLeft[arrayLeftCounter++]; //1 element uit deze array gebruikt!
				compares++;
				exchanges++;
			}
			//Als beiden niet overlopen zijn, neem de hoogste
			else if(arrayRight[arrayRightCounter] <= arrayLeft[arrayLeftCounter]) {
				//log("  4  Picked right element: " + arrayRight[arrayRightCounter] + " over " + arrayLeft[arrayLeftCounter] + ", i  " + arrayLeftCounter + ", " + arrayRightCounter);
				//System.out.println(i + " DEBUG 4 " + arrayLeftCounter + " < " + arrayLeft.length + " && " + arrayRightCounter + " < " + arrayRight.length);
				array[i] = arrayRight[arrayRightCounter++];
				compares++;
				exchanges++;
				//log(" i = " + i);
			}

		}
	}

	public void log(String message) {
		System.out.println(message);
	}
	
	public boolean i(int index) {
		System.out.println("at run index" + index);
		return true;
	}
	
	//Ofwel is de lijst even, anders oneven. Oneven maakt de linkse lijst 1 groter
	public int getMiddle(int[] theArray) {
		if(theArray.length % 2 == 0) {
			return theArray.length / 2;
		}
		else 
			return (theArray.length + 1) / 2; // 5 + 1 / 2 == 3
	}
	
}
