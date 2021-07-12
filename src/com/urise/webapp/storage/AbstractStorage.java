package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract int getIndexKey(String uuid);

    protected abstract void updateResume(Resume resume, int indexKey);

    protected abstract boolean isExistKey(int indexKey);

    protected abstract void saveResume(Resume resume, int indexKey);

    protected abstract void deleteResume(int indexKey);

    protected abstract Resume getResume(int indexKey);

    public void save(Resume resume) {
        int indexKey = isExistResume(resume.getUuid());
        saveResume(resume, indexKey);
    }

    public void update(Resume resume) {
        int indexKey = isNotExistResume(resume.getUuid());
        updateResume(resume, indexKey);
    }

    public Resume get(String uuid) {
        int indexKey = isNotExistResume(uuid);
        return getResume(indexKey);
    }

    public void delete(String uuid) {
        int indexKey = isNotExistResume(uuid);
        deleteResume(indexKey);
    }

    private int isExistResume(String uuid) {
        int indexKey = getIndexKey(uuid);
        if (isExistKey(indexKey)) {
            throw new ExistStorageException(uuid);
        }
        return indexKey;
    }

    private int isNotExistResume(String uuid) {
        int indexKey = getIndexKey(uuid);
        if (!isExistKey(indexKey)) {
            throw new NotExistStorageException(uuid);
        }
        return indexKey;
    }
}
