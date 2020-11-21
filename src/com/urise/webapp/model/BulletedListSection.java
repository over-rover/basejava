package com.urise.webapp.model;

import java.util.List;

public class BulletedListSection extends AbstractSection {
    private List<String> descriptions;

    public BulletedListSection(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    public List<String> getDescriptions() {
        return descriptions;
    }

    public void setDescription(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BulletedListSection object = (BulletedListSection) o;

        return descriptions.equals(object.descriptions);
    }
}