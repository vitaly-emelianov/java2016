package ru.sbt.classwork1411;

/**
 * Created by vitaly on 14.11.16.
 */
public class MulStrategy implements ArrayProcessor.ElementStrategy {
    @Override
    public int process(int i) {
        return i * 3;
    }
}
