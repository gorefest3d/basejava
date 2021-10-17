package com.urise.webapp.storage.serialize;

import java.io.IOException;

public interface ElementReader<T> {
    T read() throws IOException;
}
