package edu.ntu.bykov.lr4.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group extends OrganizationalUnit {
    private final List<Student> students = new ArrayList<>();

    public Group(String name, Human head) {
        super(name, head);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Group group = (Group) o;
        return Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), students);
    }
}
