package com.urise.webapp.storage;

import com.urise.webapp.storage.serialize.JsonStreamSerializer;

public class JsonPathStorageTest extends AbstractStorageTest{

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGEDIR.getAbsolutePath(), new JsonStreamSerializer()));
    }
}