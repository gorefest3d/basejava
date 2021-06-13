package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(Resume resume, int index) {
        storage[size] = resume;
    }

    protected int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    protected void fillAfterDelete(int index) {
        System.arraycopy(storage, index + 1, storage, index + 1 - 1, size - (index + 1));
    }
}
