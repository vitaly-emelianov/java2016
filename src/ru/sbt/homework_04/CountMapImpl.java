package ru.sbt.homework_04;

import java.util.*;

/**
 * Created by vitaly on 22.10.16.
 */
public class CountMapImpl<T> implements CountMap<T> {

    private final Map<T, Integer> map;

    public CountMapImpl() {
        map = new TreeMap<T, Integer>();
    }

    public void add(T o) {
        if (map.containsKey(o)) {
            map.put(o, map.get(o) + 1);
        } else {
            map.put(o, 1);
        }
    }

    public int getCount(T o) {
        return map.getOrDefault(o, 0);
    }

    public int remove(T o) {
        int counter = map.get(o);
        if (counter > 1) {
            map.put(o, counter - 1);
        } else {
            map.remove(o);
        }
        return counter;
    }

    public int size() {
        return map.size();
    }

    public void addAll(CountMap<? extends T> source) {
        Iterator entries = source.toMap().entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            T element = (T) entry.getKey();
            Integer counter = (Integer) entry.getValue();
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + counter);
            } else {
                map.put(element, counter);
            }
        }
    }

    public Map toMap() {
        return map;
    }

    public void toMap(Map<? super T, Integer> destination) {
        destination.putAll(map);
    }

    public static void main(String[] args) {
        CountMap<String> map1 = new CountMapImpl<>();
        map1.add("jack");
        map1.add("john");
        map1.add("alex");
        map1.add("alex");
        map1.add("alex");
        map1.add("jack");
        System.out.println(map1.toMap());

        CountMap<String> map2 = new CountMapImpl<>();
        map2.add("jack");
        map2.add("johnny");
        map2.add("chad");

        map1.addAll(map2);
        System.out.println(map1.toMap());
    }
}
