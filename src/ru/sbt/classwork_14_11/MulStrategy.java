package ru.sbt.classwork_14_11;

/**
 * Created by vitaly on 14.11.16.
 */
public class MulStrategy implements ArrayProcessor.ElementStrategy {
    @Override
    public int process(int i) {
        return i * 3;
    }
}
