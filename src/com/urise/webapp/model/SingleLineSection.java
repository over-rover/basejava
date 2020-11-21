package com.urise.webapp.model;

public class SingleLineSection extends AbstractSection {
    private String description;

    public SingleLineSection(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleLineSection str = (SingleLineSection) o;
        return description.equals(str.description);
    }
}