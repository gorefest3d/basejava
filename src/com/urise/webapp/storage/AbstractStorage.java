package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    protected abstract void doSave(Resume resume);

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    protected abstract List<Resume> doCopyAllResumes();

    public void save(Resume resume) {
        SK searchKey = getNotExistSearchKey(resume.getUuid());
        doSave(resume);
    }

    public void update(Resume resume) {
        SK searchKey = getExistSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    public Resume get(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        return doGet(searchKey);
    }

    public void delete(String uuid) {
        SK searchKey = getExistSearchKey(uuid);
        doDelete(searchKey);
    }

    private SK getExistSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> allResumes = doCopyAllResumes();
        Collections.sort(allResumes);
        return allResumes;
    }
}
