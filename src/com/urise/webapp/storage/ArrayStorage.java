package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private int getIndex(String uuid) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
            }
        }
        return index;
    }

    public void save(Resume r) {
        if (size < storage.length) {
            if (getIndex(r.getUuid()) == -1) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Резюме " + r.getUuid() + " существует!");
            }
        } else {
            System.out.println("БД переполнена!");
        }
    }

    public void update(Resume r) {
        if (getIndex(r.getUuid()) >= 0) {
            storage[getIndex(r.getUuid())] = r;
        } else {
            System.out.println("Резюме " + r.getUuid() + " нельзя обновить");
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) >= 0) {
            return storage[getIndex(uuid)];
        }
        System.out.println("Резюме " + uuid + " нет в БД");
        return null;
    }

    public void delete(String uuid) {
        if (getIndex(uuid) >= 0) {
            if (size - (getIndex(uuid) + 1) >= 0)
                System.arraycopy(storage, getIndex(uuid) + 1, storage, getIndex(uuid) + 1 - 1, size - (getIndex(uuid) + 1));
            size--;
        } else {
            System.out.println("Резюме " + uuid + " нельзя удалить");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
