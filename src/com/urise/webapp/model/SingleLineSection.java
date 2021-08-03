package com.urise.webapp.model;

public class SingleLineSection extends AbstractSection {
    private final String singleLine;

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
        return "SingleLineSection{" +
                "singleLine='" + singleLine + '\'' +
                '}';
    }
}
