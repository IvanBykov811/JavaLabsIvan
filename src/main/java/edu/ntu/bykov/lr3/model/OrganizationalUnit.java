package edu.ntu.bykov.lr3.model;

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
}
