package com.urise.webapp.storage.serialize;

import java.io.IOException;

public interface ElementWriter<T> {
    void writeElement(T t) throws IOException;
}
