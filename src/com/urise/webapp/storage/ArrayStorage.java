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

    protected Integer getSearchKey(String uuid) {
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
       storage[index] = storage[size - 1];
    }
}
