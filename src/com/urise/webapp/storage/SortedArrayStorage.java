package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(Resume resume, int index) {
        int indexForInsert = -index - 1;
        System.arraycopy(storage, indexForInsert, storage, indexForInsert + 1, size - indexForInsert);
        storage[indexForInsert] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void fillAfterDelete(int index) {
        int moveIndex = size - index - 1;
        if (moveIndex > 0) {
            System.arraycopy(storage, index + 1, storage, index, moveIndex);
        }
    }
}
