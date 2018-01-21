package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        HashMap<String,Cat> mapCat = new HashMap<>();
        mapCat.put("Cat1",new Cat("Cat1"));
        mapCat.put("Cat2",new Cat("Cat2"));
        mapCat.put("Cat3",new Cat("Cat3"));
        mapCat.put("Cat4",new Cat("Cat4"));
        mapCat.put("Cat5",new Cat("Cat5"));
        mapCat.put("Cat6",new Cat("Cat6"));
        mapCat.put("Cat7",new Cat("Cat7"));
        mapCat.put("Cat8",new Cat("Cat8"));
        mapCat.put("Cat9",new Cat("Cat9"));
        mapCat.put("Cat10",new Cat("Cat10"));
        return mapCat;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        Set<Cat> catSet = new HashSet<>();
        for(Map.Entry<String,Cat> pair : map.entrySet()){
            catSet.add(pair.getValue());
        }
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
