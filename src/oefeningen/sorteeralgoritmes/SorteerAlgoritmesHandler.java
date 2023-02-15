package oefeningen.sorteeralgoritmes;

public class SorteerAlgoritmesHandler {

	
	public static void run() {
		
		RandomArrayGenerator generator = new RandomArrayGenerator();
		
		int length = 1000;
		int low = 0;
		int high = 10;
		
		//main.simuleer(new InsertionSort(generator.getRandomArray(length, low, high)), generator, length, low, high);
		//main.simuleer(new SelectionSort(generator.getRandomArray(length, low, high)), generator, length, low, high);
		//main.simuleer(new MergeSort(generator.getRandomArray(length, low, high)), generator, length, low, high);


		//main.simuleer(new QuickSort(generator.getRandomArray(length, low, high)), generator, length, low, high);
		//main.test(new QuickSort(generator.getRandomArray(10, 0, 10)), generator);
		LsdSort sort = new LsdSort(new String[] {"abc", "cef", "bfc", "cba"});
		sort.sort(3);
	}
	
	public void test(AlgoritmeBase base, RandomArrayGenerator generator) {
		base.reset(generator.getRandomArray(10, 0, 10));
		base.toString(base.getArray(), "before: ");
		base.sorteer();
		base.toString(base.getArray(), "after: ");
		System.out.println(base.getCompares());
	}
	
	public void simuleer(AlgoritmeBase base, RandomArrayGenerator generator, int length, int low, int high) {
		for(int i = 2; i < length; i++) {
			base.reset(generator.getRandomArray(i, low, high));
			base.sorteer();
			System.out.println(base.getExchanges());
		}
	}
	
}
