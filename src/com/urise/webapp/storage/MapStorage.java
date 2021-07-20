package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected void doSave(Resume resume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume resume, Object searchKey) {
        mapResume.put((String) searchKey, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return mapResume.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        mapResume.remove(searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return mapResume.containsKey(searchKey);
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    public Resume[] getAll() {
        return mapResume.values().toArray(new Resume[mapResume.size()]);
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
