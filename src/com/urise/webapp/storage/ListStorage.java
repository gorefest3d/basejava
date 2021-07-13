package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> listResume = new ArrayList<>();

    @Override
    protected void doSave(Resume resume, int searchKey) {
        listResume.add(resume);
    }

    @Override
    protected int getSearchKey(String uuid) {
        for (int i = 0; i < listResume.size(); i++) {
            if (listResume.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return 0;
    }

    @Override
    protected void doUpdate(Resume resume, int searchKey) {
        listResume.set(searchKey, resume);
    }

    @Override
    protected Resume doGet(int searchKey) {
        return listResume.get(searchKey);
    }

    @Override
    protected void doDelete(int searchKey) {
        listResume.remove(searchKey);
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
