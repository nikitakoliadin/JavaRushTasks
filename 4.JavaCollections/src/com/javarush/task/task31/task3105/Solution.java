package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        String pathToFile = args[0];
        String pathToArchive = args[1];

        Map<String, ByteArrayOutputStream> archivedFiles = new HashMap<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(pathToArchive))) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

                byte[] buffer = new byte[8 * 1024];
                int len;
                while ((len = zipInputStream.read(buffer)) > 0) {
                    byteArrayOutputStream.write(buffer, 0, len);
                }

                archivedFiles.put(zipEntry.getName(), byteArrayOutputStream);
            }
        }

        Files.delete(Paths.get(pathToArchive));

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(pathToArchive))) {
            for (Map.Entry<String, ByteArrayOutputStream> pair : archivedFiles.entrySet()) {
                String name = Paths.get(pair.getKey()).getFileName().toString();

                if (name.equals(Paths.get(pathToFile).getFileName().toString())) {
                    zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                    Files.copy(Paths.get(pathToFile), zipOutputStream);
                } else {
                    zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                    zipOutputStream.write(pair.getValue().toByteArray());
                }
            }
        }
    }



    /* Work but validator .... */
//    public static void main(String[] args) throws IOException {
//        Path pathToFile = Paths.get(args[0]);
//        Path pathToArchive = Paths.get(args[1]);
//
//        Path tmpZipFile = Files.createTempFile(null, null);
//
//        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tmpZipFile))) {
//            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(pathToArchive))) {
//
//                zipOutputStream.putNextEntry(new ZipEntry(pathToFile.getFileName().toString()));
//
//                copyToNewZip(zipOutputStream, zipInputStream);
//            }
//        }
//
//        Files.delete(pathToArchive);
//
//        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(pathToArchive))) {
//            try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(tmpZipFile))) {
//                copyToNewZip(zipOutputStream, zipInputStream);
//            }
//        }
//    }
//
//    private static void copyToNewZip(ZipOutputStream zipOutputStream, ZipInputStream zipInputStream) throws IOException {
//        ZipEntry zipEntry;
//        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
//            String fileName = zipEntry.getName();
//
//            zipOutputStream.putNextEntry(new ZipEntry(fileName));
//
//            copyFromTo(zipOutputStream, zipInputStream);
//
//            zipInputStream.closeEntry();
//            zipOutputStream.closeEntry();
//        }
//    }
//
//    private static void copyFromTo(ZipOutputStream zipOutputStream, ZipInputStream zipInputStream) throws IOException {
//        byte[] buffer = new byte[8 * 1024];
//        int len;
//        while ((len = zipInputStream.read(buffer)) > 0) {
//            zipOutputStream.write(buffer, 0, len);
//        }
//    }
}
