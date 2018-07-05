package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Map<Object, String> map = new HashMap<>();
        map.put(null, "kek");
        System.out.println(map.get(null));

        Set<Object> set = new HashSet<>();
        set.add(null);
        System.out.println(set.iterator().next());

        Set<String> amigoSet = new AmigoSet<>();
        amigoSet.add(null);
        System.out.println(amigoSet.iterator().next());

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/media/koliadin/B2501B3A501B052F/Programming/Java/Projects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task37/task3707/serializationTest.txt"))) {
            objectOutputStream.writeObject(amigoSet);
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("/media/koliadin/B2501B3A501B052F/Programming/Java/Projects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task37/task3707/serializationTest.txt"))) {
            AmigoSet<String> amigoSetCopy = (AmigoSet<String>) objectInputStream.readObject();
            System.out.println(amigoSetCopy.iterator().next());
            System.out.println(amigoSet.equals(amigoSetCopy));
        }
    }
}
