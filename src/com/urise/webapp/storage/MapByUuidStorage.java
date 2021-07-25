package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapByUuidStorage extends AbstractStorage {
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
    protected void doUpdate(Resume resume, Object uuid) {
        mapResume.put((String) uuid, resume);
    }

    @Override
    protected Resume doGet(Object uuid) {
        return mapResume.get((String) uuid);
    }

    @Override
    protected void doDelete(Object uuid) {
        mapResume.remove((String) uuid);
    }

    @Override
    protected boolean isExist(Object uuid) {
        return mapResume.containsKey((String) uuid);
    }

    @Override
    public void clear() {
        mapResume.clear();
    }

    @Override
    protected List<Resume> doCopyAllResumes() {
        return new ArrayList<>(mapResume.values());
    }

    @Override
    public int size() {
        return mapResume.size();
    }
}
