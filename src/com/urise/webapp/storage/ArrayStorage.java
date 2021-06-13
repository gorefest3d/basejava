package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void save(Resume resume) {
        if (size < STORAGE_LIMIT) {
            if (getIndex(resume.getUuid()) == -1) {
                storage[size] = resume;
                size++;
            } else {
                System.out.println("Резюме " + resume.getUuid() + " существует!");
            }
        } else {
            System.out.println("БД переполнена!");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            if (size - (index + 1) >= 0)
                System.arraycopy(storage, index + 1, storage, index + 1 - 1, size - (index + 1));
            size--;
        } else {
            System.out.println("Резюме " + uuid + " нельзя удалить");
        }
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
}
