package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.UUID;
import java.util.Objects;

/**
 * Initial resume class
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;
    public static final Resume EMPTY = new Resume();

    static {
        EMPTY.setSection(TypeSection.OBJECTIVE, TextSection.EMPTY);
        EMPTY.setSection(TypeSection.PERSONAL, TextSection.EMPTY);
        EMPTY.setSection(TypeSection.ACHIEVEMENT, ListSection.EMPTY);
        EMPTY.setSection(TypeSection.QUALIFICATIONS, ListSection.EMPTY);
        EMPTY.setSection(TypeSection.EXPERIENCE, new HistorySection(Organization.EMPTY));
        EMPTY.setSection(TypeSection.EDUCATION, new HistorySection(Organization.EMPTY));
    }

    private final Map<TypeSection, Section> sections = new EnumMap<>(TypeSection.class);
    private final Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);

    // Unique identifier
    private String uuid;
    private String fullName;

    public Resume() {
    }
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Map<ContactType, String> getContacts() {
        return contacts;
    }

    public Map<TypeSection, Section> getSections() {
        return sections;
    }

    public Section getSection(TypeSection type) {
        return sections.get(type);
    }

    public String getContact(ContactType type) {
        return contacts.get(type);
    }

    public void setContact(ContactType type, String value) { contacts.put(type, value); }

    public void setSection(TypeSection type, Section section) {
        sections.put(type, section);
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
        return Objects.equals(uuid, resume.uuid) &&
                Objects.equals(fullName, resume.fullName) &&
                Objects.equals(contacts, resume.contacts) &&
                Objects.equals(sections, resume.sections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, contacts, sections);
    }

    @Override
    public int compareTo(Resume o) {
        int cmpr = fullName.compareTo(o.fullName);
        return cmpr != 0 ? cmpr : uuid.compareTo(o.uuid);
    }
}
