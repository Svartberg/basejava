package com.urise.webapp.model;

import java.util.List;

public class SectionHistory extends Section {
    private final List<Organization> history;

    public SectionHistory(List<Organization> history) {
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

        SectionHistory that = (SectionHistory) o;

        return history.equals(that.history);
    }

    @Override
    public int hashCode() {
        return history.hashCode();
    }
}
