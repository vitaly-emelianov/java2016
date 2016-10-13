package ru.sbt.homework_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by vitaly on 10/13/16.
 */
public class Solution2057 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("/home/vitaly/Desktop/input.txt"));
        PriorityQueue<Integer> minCollection = new PriorityQueue<>();
        String numOperations = sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] operators = line.split(" ");
            if (operators.length == 2) {
                minCollection.add(Integer.parseInt(operators[1]));
            } else {
                if (!minCollection.isEmpty()) {
                    System.out.println(minCollection.poll());
                }
            }
        }
    }
}
