package com.urise.webapp.model;

import java.util.List;

public class BulletedListSection extends AbstractSection{
    private final List<String> bulletedList;

    public BulletedListSection(List<String> bulletedList) {
        this.bulletedList = bulletedList;
    }

    public List<String> getBulletedList() {
        return bulletedList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BulletedListSection that = (BulletedListSection) o;

        return bulletedList.equals(that.bulletedList);
    }

    @Override
    public int hashCode() {
        return bulletedList.hashCode();
    }

    @Override
    public String toString() {
        return "BulletedListSection{" +
                "bulletedList=" + bulletedList +
                '}';
    }
}
