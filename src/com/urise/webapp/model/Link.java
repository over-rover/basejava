package com.urise.webapp.model;

public class Link {
    private String name;
    private String linkAddress;

    public Link(String name, String linkAddress) {
        this.name = name;
        this.linkAddress = linkAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLinkAddress() {
        return linkAddress;
    }

    public void setLinkAddress(String linkAddress) {
        this.linkAddress = linkAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (!name.equals(link.name)) return false;
        return linkAddress.equals(link.linkAddress);
    }

    @Override
    public String toString() {
        return name;
    }
}