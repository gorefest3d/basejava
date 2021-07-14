package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract void doSave(Resume resume);

    protected abstract Integer getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, Integer searchKey);

    protected abstract Resume doGet(Integer searchKey);

    protected abstract void doDelete(Integer searchKey);

    public void save(Resume resume) {
        Integer searchKey = getNotExistSearchKey(resume.getUuid());
        doSave(resume);
    }

    public void update(Resume resume) {
        Integer searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public Resume get(String uuid) {
        Integer searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        Integer searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    private Integer getExistSearchKey(String uuid) {
        Integer searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Integer getNotExistSearchKey(String uuid) {
        Integer searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract boolean isExist(Integer searchKey);
}
