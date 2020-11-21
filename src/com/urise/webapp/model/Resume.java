package com.urise.webapp.model;

import java.util.*;

public class Resume implements Comparable<Resume> {
    private final String uuid;
    private String fullName;
    private Map<ContactType, String> contacts = new EnumMap<>(ContactType.class);
    private Map<SectionType, AbstractSection> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
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

    public void setContacts(ContactType contactType, String contactName) {
        contacts.put(contactType, contactName);
    }

    public Map<SectionType, AbstractSection> getSections() {
        return sections;
    }

    public void setSections(SectionType sectionType, AbstractSection description) {
        sections.put(sectionType, description);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        if (!fullName.equals(resume.fullName)) return false;
        if (!contacts.equals(resume.contacts)) return false;
        return sections.equals(resume.sections);
    }

    @Override
    public int compareTo(Resume o) {
        int fullNameCompare = fullName.compareTo(o.getFullName());
        return fullNameCompare == 0 ? uuid.compareTo(o.getUuid()) : fullNameCompare;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, sections);
    }

    @Override
    public String toString() {
        return uuid + "(" + fullName + ")";
    }
}