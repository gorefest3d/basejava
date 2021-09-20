package com.urise.webapp;

import java.io.File;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File directory = new File("./out");

        viewDirectoryDeep(directory, ".");
    }

    public static void viewDirectoryDeep(File directory, String offset) {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(offset + "File: " + file.getName());
            } else if (file.isDirectory()) {
                System.out.println(offset + "Directory: " + file.getName());
                viewDirectoryDeep(file, offset + "..");
            }
        }
    }
}
