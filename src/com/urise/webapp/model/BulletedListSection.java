package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class BulletedListSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private List<String> bulletedList;

    public BulletedListSection() {
    }

    public BulletedListSection(List<String> bulletedList) {
        this.bulletedList = bulletedList;
    }
    public BulletedListSection(String... listItem){
        this(Arrays.asList(listItem));
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
        return bulletedList.toString();
    }
}
