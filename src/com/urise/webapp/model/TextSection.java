package com.urise.webapp.model;


public class TextSection extends Section {

    private static final long serialVersionUID = 1L;
    public static final TextSection EMPTY = new TextSection("");

    private String contents;

    public TextSection() {
    }
    public TextSection(String contents) {
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

        TextSection that = (TextSection) o;

        return contents.equals(that.contents);

    }

    @Override
    public int hashCode() {
        return contents.hashCode();
    }
}
