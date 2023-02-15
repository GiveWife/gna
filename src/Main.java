import oefeningen.sorteeralgoritmes.*;
import oefeningen.util.AlgorithmPerformance;
import oefeningen.util.OperationTime;

public class Main {

    public Main() {
    }

    public void run() {

        RandomArrayGenerator gen = new RandomArrayGenerator();
        int max = 5;
        AlgorithmPerformance[] algorithmPerformances = new AlgorithmPerformance[] {
                new AlgorithmPerformance("Insertion Sort", max),
                new AlgorithmPerformance("Merge Sort", max),
                new AlgorithmPerformance("Quick Sort", max),
                new AlgorithmPerformance("Selection Sort", max)
        };

        for(int i = 1; i < max; i++) {

            int[] toSort = gen.getRandomArray((int) Math.pow(10, i), 0, 100);

            AlgoritmeBase[] algoritmeBases = new AlgoritmeBase[] {
                    new InsertionSort(toSort),
                    new MergeSort(toSort),
                    new QuickSort(toSort),
                    new SelectionSort(toSort)
            };

            for(int j = 0; j < algoritmeBases.length; j++) {

                simuleer(algoritmeBases[j], algorithmPerformances[j]);

            }

        }

        for(int i = 0; i < algorithmPerformances.length; i++) {

            algorithmPerformances[i].results();

        }

    }

    public void simuleer(AlgoritmeBase algoritme, AlgorithmPerformance performanceHolder) {

        OperationTime time = new OperationTime();

        time.start();
        algoritme.sorteer();
        time.stop();

        //time.verslag(algoritme.getName());
        //System.out.println("  -> Compares: " + algoritme.getCompares());
        //System.out.println("  -> Exchanges: " + algoritme.getExchanges());
        //System.out.println(" ------------------------ ");

        performanceHolder.register(algoritme.getArray().length, algoritme.getExchanges(), algoritme.getCompares(), time.getSeconds());

    }

    public static void main(String[] args) {

        Main main = new Main();
        main.run();

    }

}