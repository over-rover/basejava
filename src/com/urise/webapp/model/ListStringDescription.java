package com.urise.webapp.model;

import java.util.List;

public class ListStringDescription extends AbstractSection {
    private List<String> descriptions;

    public ListStringDescription(List<String> descriptions) {
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

        ListStringDescription object = (ListStringDescription) o;

        return descriptions.equals(object.descriptions);
    }
}
