package com.urise.webapp.model;

import java.util.List;
import java.util.Objects;

public class BulletedListSection extends AbstractSection {
    private final List<String> descriptions;

    public BulletedListSection(List<String> descriptions) {
        Objects.requireNonNull(descriptions, "descriptions must not be null");
        this.descriptions = descriptions;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    /*public void setDescription(List<String> descriptions) {
        this.descriptions = descriptions;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BulletedListSection object = (BulletedListSection) o;

        return descriptions.equals(object.descriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptions);
    }
}