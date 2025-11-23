package edu.ntu.bykov.lr4.model;

import java.util.Objects;

public abstract class OrganizationalUnit {
    private String name;
    private Human head;

    public OrganizationalUnit(String name, Human head) {
        this.name = name;
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    public void setHead(Human head) {
        this.head = head;
    }

    @Override
    public String toString() {
        return name + " (керівник: " + head + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationalUnit that = (OrganizationalUnit) o;
        return Objects.equals(name, that.name)
                && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head);
    }
}
