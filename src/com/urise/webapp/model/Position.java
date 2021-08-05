package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Position {
    private final String position;
    private final String description;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Position(String position, String description, LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(endDate, "endDate must not be null");
        Objects.requireNonNull(position, "position must not be null");
        this.position = position;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position1 = (Position) o;

        if (!position.equals(position1.position)) return false;
        if (description != null ? !description.equals(position1.description) : position1.description != null)
            return false;
        if (!startDate.equals(position1.startDate)) return false;
        return endDate.equals(position1.endDate);
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Position{" +
                "position='" + position + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
