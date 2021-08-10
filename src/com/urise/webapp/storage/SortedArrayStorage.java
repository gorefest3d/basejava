package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected void insertResume(Resume resume, int index) {
        int indexForInsert = -index - 1;
        System.arraycopy(storage, indexForInsert, storage, indexForInsert + 1, size - indexForInsert);
        storage[indexForInsert] = resume;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
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
