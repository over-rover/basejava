package com.urise.webapp.model;

import java.time.YearMonth;
import java.util.List;

public class ExpEduDescription extends AbstractSection {
    private List<ExpEduDescription> descriptions;
    private Link organization;
    private YearMonth start;
    private YearMonth finish;
    private String position;
    private String duties;

    public ExpEduDescription(String organizationName, String linkAddress, YearMonth start, YearMonth finish,
                             String position, String duties) {
        organization = new Link(organizationName, linkAddress);
        this.start = start;
        this.finish = finish;
        this.position = position;
        this.duties = duties;
    }

    /*Пришлось сделать этот конструктор, чтобы из ResumeTestData можно было заполнить мапу:
     * r.setSections(SectionType.EXPERIENCE, new ExpEduDescription(exp));
     * r.setSections(SectionType.EDUCATION, new ExpEduDescription(edu));*/
    public ExpEduDescription(List<ExpEduDescription> descriptions) {
        this.descriptions = descriptions;
    }

    public List<ExpEduDescription> getDescriptions() {
        return descriptions;
    }

    public Link getOrganization() {
        return organization;
    }

    public void setOrganization(Link organization) {
        this.organization = organization;
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

        ExpEduDescription object = (ExpEduDescription) o;

        if (!organization.equals(object.organization)) return false;
        if (!start.equals(object.start)) return false;
        if (!finish.equals(object.finish)) return false;
        if (!position.equals(object.position)) return false;
        return duties.equals(object.duties);
    }

    @Override
    public String toString() {
        return getOrganization().getName() + "\n" + getStart() + " - " + getFinish() + "\n"
                + getPosition() + "\n" + getDuties();
    }
}