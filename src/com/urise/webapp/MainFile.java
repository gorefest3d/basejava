package com.urise.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File directory = new File(".\\src\\com\\urise\\webapp");

        viewDirectoryDeep(directory);
    }

    public static void viewDirectoryDeep(File directory) {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("  File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                viewDirectoryDeep(file);
            }
        }
    }
}
