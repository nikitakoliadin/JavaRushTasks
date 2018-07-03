package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;

    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        if (partOfName != null) {
            if (!file.getFileName().toString().contains(partOfName)) {
                return super.visitFile(file, attrs);
            }
        }

        if (partOfContent != null) {
            if (!(new String(content).contains(partOfContent))) {
                return super.visitFile(file, attrs);
            }
        }

        if (maxSize > -1 && !(Files.size(file) < maxSize)) {
            return super.visitFile(file, attrs);
        }

        if (minSize > -1 && !(Files.size(file) > minSize)) {
            return super.visitFile(file, attrs);
        }

        foundFiles.add(file);

        return super.visitFile(file, attrs);
    }
}
