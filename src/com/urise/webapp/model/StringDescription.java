package com.urise.webapp.model;

public class StringDescription extends AbstractSection {
    private String description;

    public StringDescription(String description) {
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

        StringDescription str = (StringDescription) o;
        return description.equals(str.description);
    }
}