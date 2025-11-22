package edu.ntu.bykov.lr3.model;

import java.util.ArrayList;
import java.util.List;

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
}
