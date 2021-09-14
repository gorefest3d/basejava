package com.urise.webapp.storage;

import com.urise.webapp.storage.serialize.ObjectStreamSerializeStrategy;

public class ObjectPathStorageTest extends AbstractStorageTest{

    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGEDIR.getAbsolutePath(), new ObjectStreamSerializeStrategy()));
    }
}