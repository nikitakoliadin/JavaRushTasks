package com.javarush.task.task31.task3102;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> paths = new ArrayList<>();

        Files.walkFileTree(Paths.get(root), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.isRegularFile()) {
                    paths.add(file.toAbsolutePath().toString());
                }

                return super.visitFile(file, attrs);
            }
        });

        return paths;
    }

    public static void main(String[] args) throws IOException {
        getFileTree("/media/koliadin/B2501B3A501B052F/Programming/Java/Projects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3102/test").forEach(System.out::println);
    }
}
