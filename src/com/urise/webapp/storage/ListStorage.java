package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage implements Storage {
    List<Resume> resumeList = new ArrayList<>();

    @Override
    public void clear() {
        resumeList.clear();
    }

    @Override
    public void save(Resume resume) {
        resumeList.add(resume);
    }

    @Override
    public void update(Resume resume) {
        resumeList.set(getIndex(resume.getUuid()), resume);
    }

    @Override
    public Resume get(String uuid) {
        return resumeList.get(getIndex(uuid));
    }

    public Integer getIndex(String uuid) {
        for (int i = 0; i < resumeList.size(); i++) {
            if (resumeList.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void delete(String uuid) {
        resumeList.remove(getIndex(uuid));
    }

    @Override
    public Resume[] getAll() {
        return resumeList.toArray(new Resume[resumeList.size()]);
    }

    @Override
    public int size() {
        return resumeList.size();
    }
}
