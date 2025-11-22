package edu.ntu.bykov.lr3;

import edu.ntu.bykov.lr3.controller.UniversityCreator;
import edu.ntu.bykov.lr3.model.*;

public class Run {

    public static void main(String[] args) {
        University university = createTypycalUniversity();
        printUniversityInfo(university);
    }

    public static University createTypycalUniversity() {
        Human rector = new Human("Іван", "Петров", "Іванович", Sex.MALE) {};
        UniversityCreator universityCreator = new UniversityCreator();
        University university = universityCreator.createUniversity(
                "Національний технічний університет", rector);

        Human dean = new Human("Марія", "Коваленко", "Петрівна", Sex.FEMALE) {};
        Faculty faculty = universityCreator.createFacultyInUniversity(
                university, "Факультет комп'ютерних наук", dean);

        Human headDepartment = new Human("Олег", "Сидоренко", "Вікторович", Sex.MALE) {};
        Department department = universityCreator
                .getFacultyCreator()
                .createDepartmentInFaculty(
                        faculty,
                        "Кафедра програмної інженерії",
                        headDepartment
                );

        Human headGroup = new Human("Наталія", "Іваненко", "Олександрівна", Sex.FEMALE) {};
        Group group = universityCreator
                .getFacultyCreator()
                .getDepartmentCreator()
                .createGroupInDepartment(
                        department,
                        "КН-21",
                        headGroup
                );

        var groupCreator = universityCreator
                .getFacultyCreator()
                .getDepartmentCreator()
                .getGroupCreator();

        groupCreator.addStudent(group, "Андрій", "Мельник", "Ігорович", Sex.MALE);
        groupCreator.addStudent(group, "Оксана", "Шевченко", "Іванівна", Sex.FEMALE);
        groupCreator.addStudent(group, "Дмитро", "Гриценко", "Андрійович", Sex.MALE);

        return university;
    }

    private static void printUniversityInfo(University university) {
        System.out.println("Університет: " + university.getName());
        System.out.println("Ректор: " + university.getHead());

        for (Faculty faculty : university.getFaculties()) {
            System.out.println("  Факультет: " + faculty.getName()
                    + ", декан: " + faculty.getHead());
            for (Department department : faculty.getDepartments()) {
                System.out.println("    Кафедра: " + department.getName()
                        + ", завідувач: " + department.getHead());
                for (Group group : department.getGroups()) {
                    System.out.println("      Група: " + group.getName()
                            + ", куратор: " + group.getHead());
                    for (Student student : group.getStudents()) {
                        System.out.println("        Студент: " + student);
                    }
                }
            }
        }
    }
}
