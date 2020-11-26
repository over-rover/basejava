package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.Objects;

public class Experience extends AbstractSection {
    private Link organizationLink;
    private YearMonth start;
    private YearMonth finish;
    private String position;
    private String duties;

    public Experience(String organizationName, String url, YearMonth start, YearMonth finish,
                      String position, String duties) {
        Objects.requireNonNull(start, "start must not be null");
        Objects.requireNonNull(finish, "finish must not be null");
        Objects.requireNonNull(position, "position must not be null");
        organizationLink = new Link(organizationName, url);
        this.start = start;
        this.finish = finish;
        this.position = position;
        this.duties = duties;
    }

    public Link getOrganizationLink() {
        return organizationLink;
    }

    public void setOrganizationLink(Link organizationLink) {
        this.organizationLink = organizationLink;
    }

    public YearMonth getStart() {
        return start;
    }

    public void setStart(YearMonth start) {
        this.start = start;
    }

    public YearMonth getFinish() {
        return finish;
    }

    public void setFinish(YearMonth finish) {
        this.finish = finish;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDuties() {
        return duties;
    }

    public void setDuties(String duties) {
        this.duties = duties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience object = (Experience) o;

        if (!organizationLink.equals(object.organizationLink)) return false;
        if (!start.equals(object.start)) return false;
        if (!finish.equals(object.finish)) return false;
        if (!position.equals(object.position)) return false;
        return duties.equals(object.duties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizationLink, start, finish, position, duties);
    }

    @Override
    public String toString() {
        return getOrganizationLink().getName() + "\n" + getStart() + " - " + getFinish() + "\n"
                + getPosition() + "\n" + getDuties();
    }
}