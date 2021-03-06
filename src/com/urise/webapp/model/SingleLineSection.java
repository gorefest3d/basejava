package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class SingleLineSection extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private String singleLine;

    public SingleLineSection() {
    }

    public SingleLineSection(String singleLine) {
        this.singleLine = singleLine;
    }

    public String getSingleLine() {
        return singleLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleLineSection that = (SingleLineSection) o;

        return singleLine.equals(that.singleLine);
    }

    @Override
    public int hashCode() {
        return singleLine.hashCode();
    }

    @Override
    public String toString() {
        return singleLine;
    }
}
