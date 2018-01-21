package com.javarush.task.task20.task2019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Исправить ошибку. Сериализация
*/
public class Solution implements Serializable {

    public static void main(String args[]) throws Exception {

        Solution solution = new Solution();

        /* saving */
        try (OutputStream outputStream = new FileOutputStream("d:/test1.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(solution);

        }

        Solution loadedObject;

        /* loading */
        try (InputStream inputStream = new FileInputStream("d:/test1.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            loadedObject = (Solution) objectInputStream.readObject();
//            loadedObject.m = (Map) objectInputStream.readObject();
        }

        //Attention!!
        System.out.println(loadedObject.size());
    }

    private Map<String, String> m = new HashMap<>();

    public Map<String, String> getMap() {
        return m;
    }

    public Solution() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }
}
