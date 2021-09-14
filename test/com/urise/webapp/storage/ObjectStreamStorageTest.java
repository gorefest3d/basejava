package com.urise.webapp.storage;

import com.urise.webapp.storage.serialize.ObjectStreamSerializeStrategy;

public class ObjectStreamStorageTest extends AbstractStorageTest{

    public ObjectStreamStorageTest() {
        super(new FileStorage(STORAGEDIR, new ObjectStreamSerializeStrategy()));
    }
}