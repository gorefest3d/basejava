package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapByUuidStorage extends AbstractStorage<String> {
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
    protected void doUpdate(Resume resume, String uuid) {
        mapResume.put(uuid, resume);
    }

    @Override
    protected Resume doGet(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void doDelete(String uuid) {
        mapResume.remove(uuid);
    }

    @Override
    protected boolean isExist(String uuid) {
        return mapResume.containsKey(uuid);
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
