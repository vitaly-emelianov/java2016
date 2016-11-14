package ru.sbt.classwork1411;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 14.11.16.
 */
public class ArrayProcessorImpl implements ArrayProcessor {
    @Override
    public int[] process(int[] original, ElementStrategy strategy, int threadCount) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        int chunkSize = original.length / threadCount;
        int[] result = new int[original.length];
        for (int i = 0; i < threadCount; i++) {
            if ((i + 1) * chunkSize  + chunkSize > result.length) {
                threads.add(new Thread(new RunnableProcessor(i * chunkSize,
                        original.length,
                        original,
                        result,
                        strategy)));
            } else {
                threads.add(new Thread(new RunnableProcessor(i * chunkSize,
                        i * chunkSize + chunkSize,
                        original,
                        result,
                        strategy)));
            }
        }
        for(Thread thread: threads) {
            thread.start();
        }
        for(Thread thread: threads) {
            thread.join();
        }
        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        ElementStrategy strategy = new MulStrategy();
        int[] original = new int[20];
        for (int i = 0; i < 20; i++) {
            original[i] = i;
        }
        ArrayProcessor processor = new ArrayProcessorImpl();
        int[] result = processor.process(original, strategy, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        };

    }
}
