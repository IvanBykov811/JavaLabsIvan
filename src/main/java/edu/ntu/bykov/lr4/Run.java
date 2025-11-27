package edu.ntu.bykov.lr4;

import edu.ntu.bykov.lr4.controller.UniversityCreator;
import edu.ntu.bykov.lr4.model.*;

public class Run {

    public static void main(String[] args) {
        University university = createTypicalUniversity();
        printUniversityInfo(university);
    }

    public static University createTypicalUniversity() {

        UniversityCreator creator = new UniversityCreator();

        Human rector = new Human(
                "Іван",
                "Петров",
                "Іванович",
                Sex.MALE
        );

        University university = creator.createUniversity(
                "Національний технічний університет",
                rector
        );

        Human dean = new Human(
                "Марія",
                "Коваленко",
                "Петрівна",
                Sex.FEMALE
        );

        Faculty faculty = creator.createFacultyInUniversity(
                university,
                "Факультет комп'ютерних наук",
                dean
        );

        Human headDepartment = new Human(
                "Олег",
                "Сидоренко",
                "Вікторович",
                Sex.MALE
        );

        Department department = creator
                .getFacultyCreator()
                .getDepartmentCreator()
                .createDepartmentInFaculty(
                        faculty,
                        "Кафедра програмної інженерії",
                        headDepartment
                );

        Human headGroup = new Human(
                "Наталія",
                "Іваненко",
                "Олександрівна",
                Sex.FEMALE
        );

        Group group = creator
                .getFacultyCreator()
                .getDepartmentCreator()
                .createGroupInDepartment(
                        department,
                        "КН-21",
                        headGroup
                );

        var groupCreator = creator
                .getFacultyCreator()
                .getDepartmentCreator()
                .getGroupCreator();

        groupCreator.addStudent(group, "Андрій", "Мельник", "Ігорович", Sex.MALE);
        groupCreator.addStudent(group, "Оксана", "Шевченко", "Іванівна", Sex.FEMALE);

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
