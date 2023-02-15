package oefeningen.sorteeralgoritmes;

public class AlgoritmeBase {
	
	int compares = 0;
	int exchanges = 0;
	int[] teSorteren;
	
	public AlgoritmeBase(int[] teSorteren) {
		this.teSorteren = teSorteren;
	}

	public void toString(int[] array) {
		String printOut = "";
		for(int i = 0; i < array.length; i++) {
			printOut = printOut + array[i] + ", ";
		}
		System.out.println(printOut);
	}
	
	public void toString(int[] array, int from, int to) {
		String printOut = "";
		for(int i = from; i <= to; i++) {
			printOut = printOut + array[i] + ", ";
		}
		System.out.println(printOut);
	}
	
	public void toString(int[] array, int from, int to, String pre) {
		String printOut = "";
		for(int i = from; i <= to; i++) {
			printOut = printOut + array[i] + ", ";
		}
		System.out.println(pre + " " + printOut);
	}
	
	public void toString(int[] array, String pre) {
		String printOut = "";
		for(int i = 0; i < array.length; i++) {
			printOut = printOut + array[i] + ", ";
		}
		System.out.println(pre + " " + printOut);
	}
	
	public int[] getArray() {
		return this.teSorteren;
	}
	
	public int getCompares() {
		return this.compares;
	}
	
	public int getExchanges() {
		return this.exchanges;
	}
	
	public void sorteer() {
		
	}
	
	public void reset(int[] teSorteren) {
		this.compares = 0;
		this.exchanges = 0;
		this.teSorteren = teSorteren;
	}

}
