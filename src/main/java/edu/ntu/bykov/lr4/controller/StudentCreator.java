package edu.ntu.bykov.lr4.controller;

import edu.ntu.bykov.lr4.model.Sex;
import edu.ntu.bykov.lr4.model.Student;

public class StudentCreator {

    public Student createStudent(String firstName,
                                 String lastName,
                                 String middleName,
                                 Sex sex) {
        return new Student(firstName, lastName, middleName, sex);
    }
}
