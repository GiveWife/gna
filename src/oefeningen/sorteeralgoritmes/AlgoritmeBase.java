package oefeningen.sorteeralgoritmes;

import oefeningen.util.AlgorithmPerformance;

public abstract class AlgoritmeBase {
	
	int compares = 0;
	int exchanges = 0;
	int[] teSorteren;
	private final String name;
	private boolean debug = false;

	public AlgoritmeBase(int[] teSorteren, String name) {
		this.teSorteren = teSorteren;
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void toggledebug() {
		if(debug) debug = false;
		else debug = true;
	}

	public void debug(String s) {
		if(debug) System.out.println(s);
	}

	public String getString(int[] array) {
		String printOut = "";
		for(int i = 0; i < array.length; i++) {
			printOut = printOut + array[i] + ", ";
		}
		return printOut;
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
	
	public abstract void sorteer();
	
	public void reset(int[] teSorteren) {
		this.compares = 0;
		this.exchanges = 0;
		this.teSorteren = teSorteren;
	}

}
