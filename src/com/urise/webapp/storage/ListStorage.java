package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected void doSave(Resume resume, Integer searchkey) {
        listResume.add(resume);
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (listResume.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected void doUpdate(Resume resume, Integer searchKey) {
        listResume.set(searchKey, resume);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return listResume.get(searchKey);
    }

    @Override
    protected void doDelete(Integer searchKey) {
        listResume.remove(searchKey.intValue());
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    protected List<Resume> doCopyAllResumes() {
        return new ArrayList<>(listResume);
    }

    @Override
    public int size() {
        return listResume.size();
    }
}
