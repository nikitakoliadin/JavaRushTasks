package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

public class Solution {
    private ArrayList<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File directoryPath = new File(args[0]);
        File resultFilePath = new File(args[1]);

        File resultFile = new File(resultFilePath.getParent() + "/allFilesContent.txt");

        FileUtils.renameFile(resultFilePath, resultFile);

        try (FileOutputStream fileOutputStream = new FileOutputStream(resultFile)) {
            Solution solution = new Solution();

            solution.fillFileList(directoryPath.getPath());
            solution.fileList.sort(Comparator.comparing(File::getName));

            for (File file : solution.fileList) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    while (fileInputStream.available() > 0) {
                        fileOutputStream.write(fileInputStream.read());
                    }

                    fileOutputStream.write(System.lineSeparator().getBytes());
                }
            }
        }
    }

    private void fillFileList(String path) {
        File[] files = new File(path).listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath());
            } else if (file.length() > 50) {
                FileUtils.deleteFile(file);
            } else {
                fileList.add(file);
            }
        }
    }
}

