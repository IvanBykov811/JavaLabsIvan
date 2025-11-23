package edu.ntu.bykov.lr4.controller;

import edu.ntu.bykov.lr4.model.Department;
import edu.ntu.bykov.lr4.model.Faculty;
import edu.ntu.bykov.lr4.model.Human;
import edu.ntu.bykov.lr4.model.University;

public class FacultyCreator {

    private final DepartmentCreator departmentCreator = new DepartmentCreator();

    public Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }

    public Faculty createFacultyInUniversity(University university,
                                             String name,
                                             Human head) {
        Faculty faculty = createFaculty(name, head);
        university.addFaculty(faculty);
        return faculty;
    }

    public Department createDepartmentInFaculty(Faculty faculty,
                                                String name,
                                                Human head) {
        return departmentCreator.createDepartmentInFaculty(faculty, name, head);
    }

    public DepartmentCreator getDepartmentCreator() {
        return departmentCreator;
    }
}
