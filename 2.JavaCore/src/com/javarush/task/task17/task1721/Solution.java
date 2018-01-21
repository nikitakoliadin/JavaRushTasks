package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();

            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName1)))) {
                String line;
                while((line = fileReader.readLine()) != null) {
                    allLines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName2)))) {
                String line;
                while((line = fileReader.readLine()) != null) {
                    forRemoveLines.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println(allLines);
            System.out.println(forRemoveLines);

            new Solution().joinData();

            System.out.println(allLines);
            System.out.println(forRemoveLines);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void joinData () throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            for (String list2 : forRemoveLines) {
                if (allLines.contains(list2)) {
                    allLines.remove(list2);
                }
            }
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
