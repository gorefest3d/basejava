package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>() {
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    };

    @Override
    protected void insertResume(Resume resume, int index) {
        int indexForInsert = -index - 1;
        System.arraycopy(storage, indexForInsert, storage, indexForInsert + 1, size - indexForInsert);
        storage[indexForInsert] = resume;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void fillAfterDelete(int index) {
        int moveIndex = size - index - 1;
        if (moveIndex > 0) {
            System.arraycopy(storage, index + 1, storage, index, moveIndex);
        }
    }
}
