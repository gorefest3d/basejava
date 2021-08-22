package com.urise.webapp.storage;

public class ObjectPathStorageTest extends AbstractStorageTest{

    public ObjectPathStorageTest() {
        super(new AbstractPathStorage(STORAGEDIR.getAbsolutePath(), new ObjectStreamSerializeStrategy()));
    }
}