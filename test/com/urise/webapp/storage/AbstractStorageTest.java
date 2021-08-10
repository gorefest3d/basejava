package com.urise.webapp.storage;

import com.urise.webapp.ResumeTestData;
import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractStorageTest {
    protected Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String NAME_1 = "Name1";
    private static final Resume RESUME_1 = ResumeTestData.createResume(UUID_1, NAME_1);
    private static final String UUID_2 = "uuid2";
    private static final String NAME_2 = "Name2";
    private static final Resume RESUME_2 = ResumeTestData.createResume(UUID_2, NAME_2);
    private static final String UUID_3 = "uuid3";
    private static final String NAME_3 = "Name3";
    private static final Resume RESUME_3 = ResumeTestData.createResume(UUID_3, NAME_3);
    private static final String UUID_4 = "uuid4";
    private static final String NAME_4 = "Name4";
    private static final Resume RESUME_4 = ResumeTestData.createResume(UUID_4, NAME_4);

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertEqualsSize(3);
    }

    @Test
    public void getAllSorted() {
        List<Resume> listResume = storage.getAllSorted();
        Assert.assertEquals(3, listResume.size());
        Assert.assertEquals(Arrays.asList(RESUME_1, RESUME_2, RESUME_3), listResume);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEqualsSize(0);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertEqualsSize(4);
        assertGetResume(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, NAME_1);
        storage.update(newResume);
        Assert.assertSame(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get(UUID_4);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertEqualsSize(2);
        storage.get(UUID_1);
    }

    @Test
    public void get() {
        assertGetResume(RESUME_1);
        assertGetResume(RESUME_2);
        assertGetResume(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(UUID_4);
    }

    private void assertEqualsSize(int size) {
        Assert.assertEquals(size, storage.size());
    }

    private void assertGetResume(Resume resume) {
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }
}