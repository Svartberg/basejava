package com.urise.webapp.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;
import java.util.Objects;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume>{

    private final Map<SectionType, Section> sections = new EnumMap<>(SectionType.class);

    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);

    // Unique identifier
    private final String uuid;
    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid not be null");
        Objects.requireNonNull(fullName, "fullName not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public Section getSection(SectionType type) {
        return sections.get(type);
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }
    public void addContact(ContactType type, String value) { contacts.put(type, value); }

    public void addSections(SectionType st, Section s){
        sections.put(st, s);
    }
    @Override
    public String toString() {
        return uuid + '(' + fullName + ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public int compareTo(Resume o) {
        int cmpr = fullName.compareTo(o.fullName);
        return cmpr != 0 ? cmpr : uuid.compareTo(o.uuid);
    }
}
