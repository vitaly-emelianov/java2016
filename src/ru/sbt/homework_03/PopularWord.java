package ru.sbt.homework_03;

import java.io.*;
import java.util.*;

/**
 * Created by vitaly on 10/13/16.
 */
public class PopularWord {

    public static void main(String[] args) throws IOException {
        Map<String, Integer> tokenCounter = new TreeMap<>();
        Scanner sc = new Scanner(new File("/home/vitaly/Desktop/input.txt"));
        int max_count = 0;
        while (sc.hasNext()) {
            String token = sc.next().toLowerCase();
            if (tokenCounter.containsKey(token)) {
                tokenCounter.put(token, tokenCounter.get(token) + 1);
                int count = tokenCounter.get(token);
                if (count > max_count) {
                    max_count = count;
                }

            } else {
                tokenCounter.put(token, 1);
            }
        }
        FileWriter fw = new FileWriter(new File("/home/vitaly/Desktop/output.txt"));
        for (Map.Entry<String, Integer> entry: tokenCounter.entrySet()) {
            if (entry.getValue() == max_count) {
                fw.write(entry.getKey() + "\n");
                fw.flush();
            }
        }
        fw.close();

    }

}
