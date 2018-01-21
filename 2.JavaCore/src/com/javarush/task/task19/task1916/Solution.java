package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader fileReader1 = new BufferedReader(new FileReader(bufferedReader.readLine()));
                 BufferedReader fileReader2 = new BufferedReader(new FileReader(bufferedReader.readLine()))) {

                List<String> line1 = new ArrayList<String>();
                List<String> line2 = new ArrayList<String>();

                while (fileReader1.ready()) {
                    line1.add(fileReader1.readLine());
                }

                while (fileReader2.ready()) {
                    line2.add(fileReader2.readLine());
                }

                int max = 0;
                if (line1.size() >= line2.size()) {
                    max = line1.size();
                } else {
                    max = line2.size();
                }

                while (line1.size() > 0 && line2.size() > 0) {
                    if (line1.get(0).equals(line2.get(0))) {
                        lines.add(new LineItem(Type.SAME, line2.get(0)));
                        line1.remove(0);
                        line2.remove(0);
                    } else if (!line1.get(0).equals(line2.get(0)) && line1.get(1).equals(line2.get(0))) {
                        lines.add(new LineItem(Type.REMOVED, line1.get(0)));
                        line1.remove(0);
                    } else {
                        lines.add(new LineItem(Type.ADDED, line2.get(0)));
                        line2.remove(0);
                    }
                }
                if (line1.size() > 0) {
                    lines.add(new LineItem(Type.REMOVED, line1.get(0)));
                } else if (line2.size() > 0) {
                    lines.add(new LineItem(Type.ADDED, line2.get(0)));
                }


//                System.out.println(lines);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
