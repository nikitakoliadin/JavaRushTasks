package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(0.3d,"a");
        labels.put(0.4d,"a");
        labels.put(0.5d,"a");
        labels.put(0.6d,"a");
        labels.put(0.7d,"a");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
