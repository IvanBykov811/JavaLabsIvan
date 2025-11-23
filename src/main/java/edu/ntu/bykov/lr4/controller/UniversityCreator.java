package edu.ntu.bykov.lr4.controller;

import edu.ntu.bykov.lr4.model.Faculty;
import edu.ntu.bykov.lr4.model.Human;
import edu.ntu.bykov.lr4.model.University;

public class UniversityCreator {

    private final FacultyCreator facultyCreator = new FacultyCreator();

    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }

    public Faculty createFacultyInUniversity(University university,
                                             String name,
                                             Human head) {
        return facultyCreator.createFacultyInUniversity(university, name, head);
    }

    public FacultyCreator getFacultyCreator() {
        return facultyCreator;
    }
}
