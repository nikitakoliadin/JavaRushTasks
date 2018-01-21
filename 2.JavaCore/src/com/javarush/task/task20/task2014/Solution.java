package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) {
        System.out.println(new Solution(4));

        Solution solution = new Solution(2);

        try (OutputStream outputStream = new FileOutputStream("d:/test1.txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(solution);

        } catch (IOException e) {
            e.printStackTrace();
        }

        Solution newSolution = null;

        try (InputStream inputStream = new FileInputStream("d:/test1.txt");
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {

            newSolution = (Solution) objectInputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(solution.string);
        System.out.println(newSolution.string);
        System.out.println(solution.equals(newSolution));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Solution)) return false;
        Solution solution = (Solution) o;
        return Objects.equals(string, solution.string);
    }

    @Override
    public int hashCode() {

        return Objects.hash(string);
    }
}
