package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class OrganizationSection extends AbstractSection {
    private final List<Experience> experience;

    public OrganizationSection(List<Experience> experience) {
        Objects.requireNonNull(experience, "List<Experience> experience must not be null");
        this.experience = experience;
    }

    public List<Experience> getExperience() {
        return experience;
    }

    /*public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }*/
}
