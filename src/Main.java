import oefeningen.sorteeralgoritmes.*;
import oefeningen.util.OperationTime;

public class Main {

    private final int[] toSort;

    public Main() {
        this.toSort = new int[]{5,2,4,1,9,1,4,9,3,7,8,1,0,10,49,20};
    }

    public void run() {

        AlgoritmeBase[] algoritmeBases = new AlgoritmeBase[] {
                new InsertionSort(toSort),
                new MergeSort(toSort),
                new QuickSort(toSort),
                new SelectionSort(toSort)
        };

        for(int i = 0; i < algoritmeBases.length; i++) {

            simuleer(algoritmeBases[i]);

        }

    }

    public void simuleer(AlgoritmeBase algoritme) {

        OperationTime time = new OperationTime();

        time.start();
        algoritme.sorteer();
        time.stop();

        time.verslag(algoritme.getName());
        System.out.println("  -> Compares: " + algoritme.getCompares());
        System.out.println("  -> Exchanges: " + algoritme.getExchanges());
        System.out.println(" ------------------------ ");

    }

    public static void main(String[] args) {

        Main main = new Main();
        main.run();

    }

}