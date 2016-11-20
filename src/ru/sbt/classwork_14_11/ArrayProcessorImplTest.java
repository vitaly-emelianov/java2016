package ru.sbt.classwork_14_11;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vitaly on 14.11.16.
 */
public class ArrayProcessorImplTest {

    @Test
    public void assertEqual() throws InterruptedException {
        ArrayProcessor.ElementStrategy strategy = new MulStrategy();
        int[] original = new int[3];
        for (int i = 0; i < 3; i++) {
            original[i] = i;
        }
        ArrayProcessor processor = new ArrayProcessorImpl();
        int[] result = processor.process(original, strategy, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
            int[] true_value = new int[]{0, 3, 6};
            assertArrayEquals(result, true_value);
        };
    }

}