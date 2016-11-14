package ru.sbt.classwork1411;

/**
 * Created by vitaly on 14.11.16.
 */
public interface ArrayProcessor {
    int[] process(int[] original,
                  ElementStrategy strategy,
                  int threadCount) throws InterruptedException;

    interface ElementStrategy {
        int process(int i);
    }
}
