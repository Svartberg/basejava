package com.urise.webapp.model;


public class SectionText extends Section {
    private String contents;

    public SectionText(String contents) {
        this.contents = contents;
    }

    public String getContent() {
        return contents;
    }

    @Override
    public String toString() {
        return contents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionText that = (SectionText) o;

        return contents.equals(that.contents);

    }

    @Override
    public int hashCode() {
        return contents.hashCode();
    }
}
