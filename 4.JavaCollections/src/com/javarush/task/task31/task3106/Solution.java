package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String resultFileName = args[0];

        List<String> archivedFiles = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            archivedFiles.add(args[i]);
        }

        Collections.sort(archivedFiles);

        List<InputStream> inputStreamList = new ArrayList<>();
        for (String archivedFile : archivedFiles) {
            inputStreamList.add(new FileInputStream(archivedFile));
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreamList)))) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(resultFileName)) {
                System.out.println(zipInputStream.getNextEntry().toString());
                byte[] buffer = new byte[1024];
                int length;
                while((length = zipInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
            }
        }
    }
}
