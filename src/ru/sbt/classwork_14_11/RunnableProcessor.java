package ru.sbt.classwork_14_11;

/**
 * Created by vitaly on 14.11.16.
 */
class RunnableProcessor implements Runnable {

    private Thread thread;
    private int startIndex;
    private int endIndex;
    int[] original;

    public RunnableProcessor(int startIndex, int endIndex, int[] original, int[] result, ArrayProcessor.ElementStrategy strategy) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.original = original;
        this.result = result;
        this.strategy = strategy;
    }

    public RunnableProcessor(int endIndex, int[] original, int[] result, ArrayProcessor.ElementStrategy strategy) {
        this.endIndex = endIndex;
        this.original = original;
        this.result = result;
        this.strategy = strategy;
    }

    volatile int[] result;
    ArrayProcessor.ElementStrategy strategy;

    public RunnableProcessor(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            result[i] = strategy.process(original[i]);
        }
    }

}
