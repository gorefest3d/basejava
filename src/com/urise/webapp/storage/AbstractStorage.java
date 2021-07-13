package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doSave(Resume resume, int searchKey);

    protected abstract int getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, int searchKey);

    protected abstract Resume doGet(int searchKey);

    protected abstract void doDelete(int searchKey);

    public void save(Resume resume) {
        int searchKey = getNotExistSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    public void update(Resume resume) {
        int searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public Resume get(String uuid) {
        int searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        int searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    private int getExistSearchKey(String uuid) {
        int searchKey = getSearchKey(uuid);
        if (searchKey < 0) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private int getNotExistSearchKey(String uuid) {
        int searchKey = getSearchKey(uuid);
        if (searchKey >= 0) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }
}
