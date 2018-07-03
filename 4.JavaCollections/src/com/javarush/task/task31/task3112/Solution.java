package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt",
                Paths.get("/media/koliadin/B2501B3A501B052F/Programming/Java/Projects/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task31/task3112/download/")
        );

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);
        Path finalPath;

        try (InputStream inputStream = url.openStream()) {

            String fileName = Paths.get(urlString).getFileName().toString();

            Path tempPath = Files.createTempFile("tmp-", ".tmp");
            Files.copy(inputStream, tempPath, StandardCopyOption.REPLACE_EXISTING);

            finalPath = Files.move(tempPath, downloadDirectory.resolve(fileName));
        }

        return finalPath;
    }
}
