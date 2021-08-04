package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final String title;
    private final String homePage;
    private final String position;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Organization(String title, String homePage, String position, String description, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.homePage = homePage;
        this.position = position;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organization that = (Organization) o;
        return title.equals(that.title) && Objects.equals(homePage, that.homePage) && position.equals(that.position) && Objects.equals(description, that.description) && startDate.equals(that.startDate) && endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, homePage, position, description, startDate, endDate);
    }

    @Override
    public String toString() {
        return  "\n" + "\n" + startDate + " - " + endDate +
                "\n" + title +  "\n" +
                position +  "\n" +
                description + "\n";
    }
}
