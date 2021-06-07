package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private int size;
    private int index;
    private Resume[] storage = new Resume[10000];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    private boolean isExist(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                return true;
            }
        }
        return false;
    }

    public void save(Resume r) {
        if (size < storage.length) {
            if (!isExist(r.getUuid())) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Такое резюме существует!");
            }
        } else {
            System.out.println("БД переполнена!");
        }
    }

    public void update(Resume r, String updateData) {
        if (isExist(r.getUuid())) {
            storage[index].setUuid(updateData);
        } else {
            System.out.println("Это резюме нельзя обновить");
        }
    }

    public Resume get(String uuid) {
        if (isExist(uuid)) {
            return storage[index];
        } else {
            System.out.println("Такого резюме нет в БД");
        }
        return null;
    }

    public void delete(String uuid) {
        if (isExist(uuid)) {
            for (int j = index + 1; j < size; j++) {
                storage[j - 1] = storage[j];
            }
            size--;
        } else {
            System.out.println("Это резюме нельзя удалить");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
