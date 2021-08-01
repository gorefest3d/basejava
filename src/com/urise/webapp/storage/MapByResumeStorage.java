package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapByResumeStorage extends AbstractStorage<Resume> {
    private Map<String, Resume> mapResume = new HashMap<>();

    @Override
    protected void doSave(Resume resume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getSearchKey(String uuid) {
        return mapResume.get(uuid);
    }

    @Override
    protected void doUpdate(Resume resume, Resume searchResume) {
        mapResume.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume doGet(Resume searchResume) {
        return searchResume;
    }

    @Override
    protected void doDelete(Resume searchResume) {
        mapResume.remove(searchResume.getUuid());
    }

    @Override
    protected boolean isExist(Resume searchResume) {
        return searchResume != null;
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
