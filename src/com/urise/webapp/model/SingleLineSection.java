package com.urise.webapp.model;

import java.util.Objects;

public class SingleLineSection extends AbstractSection {
    private final String description;

    public SingleLineSection(String description) {
        Objects.requireNonNull(description, "description must not be null");
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /*public void setDescription(String description) {
        this.description = description;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleLineSection str = (SingleLineSection) o;
        return description.equals(str.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }
}