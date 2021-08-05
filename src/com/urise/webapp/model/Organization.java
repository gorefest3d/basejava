package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Organization {
    private final String title;
    private final String homePage;
    private List<Position> positions = new ArrayList<>();

    public Organization(String title, String homePage, List<Position> positions) {
        this.title = title;
        this.homePage = homePage;
        this.positions = positions;
    }

    public Organization(String title, String homePage, Position... positions) {
        this(title, homePage, Arrays.asList(positions));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!Objects.equals(title, that.title)) return false;
        if (!Objects.equals(homePage, that.homePage)) return false;
        return Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (homePage != null ? homePage.hashCode() : 0);
        result = 31 * result + (positions != null ? positions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "title='" + title + '\'' +
                ", homePage='" + homePage + '\'' +
                ", positions=" + positions +
                '}';
    }
}
