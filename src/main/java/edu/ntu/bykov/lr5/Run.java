package edu.ntu.bykov.lr5;

import edu.ntu.bykov.lr5.dao.StudentDao;
import edu.ntu.bykov.lr5.dao.StudentDaoJdbc;
import edu.ntu.bykov.lr5.model.Student;

import java.util.List;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentDao studentDao = new StudentDaoJdbc();

        System.out.println("=== Пошук студентів за місяцем народження ===");
        System.out.print("Введіть номер місяця (1-12): ");

        int month;
        try {
            month = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Некоректне число. Завершення роботи.");
            return;
        }

        if (month < 1 || month > 12) {
            System.out.println("Місяць має бути від 1 до 12. Завершення роботи.");
            return;
        }

        List<Student> students = studentDao.findByBirthMonth(month);

        if (students.isEmpty()) {
            System.out.println("Студентів, що народилися у цьому місяці, немає.");
        } else {
            System.out.println("Студенти, що народилися у місяці " + month + ":");
            for (Student s : students) {
                System.out.println("  " + s);
            }
        }
    }
}
