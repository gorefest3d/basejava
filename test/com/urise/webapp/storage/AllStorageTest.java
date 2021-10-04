package com.urise.webapp.storage;

import com.urise.webapp.storage.serialize.JsonStreamSerializer;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapByUuidStorageTest.class,
        MapByResumeStorageTest.class,
        ObjectPathStorageTest.class,
        ObjectStreamStorageTest.class,
        XmlPathStorageTest.class,
        JsonStreamSerializer.class
})
public class AllStorageTest {
}
