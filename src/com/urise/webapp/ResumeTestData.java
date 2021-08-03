package com.urise.webapp;

import com.urise.webapp.model.Resume;

public class ResumeTestData {
    public static void main(String[] args) {
        Resume resumeOne = new Resume("uuid1", "Sorokin");

        System.out.println(resumeOne.toString());
    }
}
