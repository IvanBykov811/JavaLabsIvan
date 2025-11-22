package edu.ntu.bykov.lr3.controller;

import edu.ntu.bykov.lr3.model.Group;
import edu.ntu.bykov.lr3.model.Human;
import edu.ntu.bykov.lr3.model.Sex;
import edu.ntu.bykov.lr3.model.Student;

public class GroupCreator {

    private final StudentCreator studentCreator = new StudentCreator();

    public Group createGroup(String name, Human head) {
        return new Group(name, head);
    }

    public void addStudent(Group group,
                           String firstName,
                           String lastName,
                           String middleName,
                           Sex sex) {
        Student student = studentCreator.createStudent(firstName, lastName, middleName, sex);
        group.addStudent(student);
    }
}
