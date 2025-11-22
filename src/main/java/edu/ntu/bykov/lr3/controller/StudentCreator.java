package edu.ntu.bykov.lr3.controller;

import edu.ntu.bykov.lr3.model.Sex;
import edu.ntu.bykov.lr3.model.Student;

public class StudentCreator {

    public Student createStudent(String firstName,
                                 String lastName,
                                 String middleName,
                                 Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}
