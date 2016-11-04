package ru.sbt.classwork_3110;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vitaly on 31.10.16.
 */
public class CalculatorImpl implements Calculator{
    private final Map<String, Integer> cache = new HashMap<>();

    @Override
    public int calc(String b) {
        if (cache.containsKey(b)) {
            return cache.get(b);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
        int result = 10 + b.length();
        cache.put(b, result);
        return result;
    }
}
