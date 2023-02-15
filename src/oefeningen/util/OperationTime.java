package oefeningen.util;

public class OperationTime {

    private long startTime, endTime;
    private long seconds;
    private boolean hasStartTime, hasEndTime, isDone = false;

    public OperationTime() {

    }

    public void start() {
        if(hasStartTime) return;
        startTime = System.nanoTime();
        hasStartTime = true;
    }

    public void stop() {
        if(hasEndTime || !hasStartTime) return;
        endTime = System.nanoTime();
        hasEndTime = true;
        isDone = true;
        seconds = (endTime-startTime)/(1000000000);
    }

    public long getNano() {
        return endTime-startTime;
    }

    public long getSeconds() {
        return seconds;
    }

    public void verslag(String name) {
        if(isDone && hasEndTime && hasStartTime)
            System.out.println(name + " duurde " + getSeconds());
    }

}
