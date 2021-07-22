package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HistorySection extends Section {
    private final List<Organization> history;

    public HistorySection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }
    public HistorySection(List<Organization> history) {
        Objects.requireNonNull(history, "organizations must not be null");
        this.history = history;
    }

    public List<Organization> getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return history.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HistorySection that = (HistorySection) o;

        return history.equals(that.history);
    }

    @Override
    public int hashCode() {
        return history.hashCode();
    }
}
