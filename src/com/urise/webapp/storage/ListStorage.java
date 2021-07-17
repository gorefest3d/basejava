package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected void doSave(Resume resume) {
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
    protected void doUpdate(Resume resume, Object searchKey) {
        listResume.set((Integer) searchKey, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return listResume.get((Integer) searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        listResume.remove(((Integer) searchKey).intValue());
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        listResume.clear();
    }

    @Override
    public Resume[] getAll() {
        return listResume.toArray(new Resume[listResume.size()]);
    }

    @Override
    public int size() {
        return listResume.size();
    }
}
