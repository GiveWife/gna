package oefeningen.util;

import java.util.List;

public class AlgorithmPerformance {

    private final String name;
    private int pointer;
    private int[] exchanges, compares, arraylength;
    private long[] times;

    public AlgorithmPerformance(String algorithmName, int tests) {
        this.name = algorithmName;
        exchanges = new int[tests];
        compares = new int[tests];
        arraylength = new int[tests];
        times = new long[tests];
        pointer = 0;
    }

    private int getPointer() {
        return this.pointer;
    }

    /**
     * Registers a simulation
     */
    public void register(int arrayLength, int exchanges, int compares, long time) {
        this.exchanges[pointer] = exchanges;
        this.compares[pointer] = compares;
        this.times[pointer] = time;
        this.arraylength[pointer] = arrayLength;
        pointer++;
    }

    public String getName() {
        return this.name;
    }

    public void results() {

        System.out.println("Algorithm " + getName() + " performance");
        for(int i = 0; i < arraylength.length; i++) {
            System.out.println("ArrayLength: " + arraylength[i] + " in " + (long) times[i] + " with " + exchanges[i] + " exchanges and " + compares[i] + " compares.");
        }
        System.out.println("----------------------------------------");

    }




}
