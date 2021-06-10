package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;
    protected int size;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("Резюме " + uuid + " нет в БД");
        return null;
    }

    protected abstract int getIndex(String uuid);
}
