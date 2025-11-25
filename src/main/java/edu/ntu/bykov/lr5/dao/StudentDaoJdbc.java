package edu.ntu.bykov.lr5.dao;

import edu.ntu.bykov.lr5.model.Student;
import edu.ntu.bykov.lr5.util.DbConnectionManager;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoJdbc implements StudentDao {

    private static final String FIND_BY_MONTH_SQL =
            "SELECT id, last_name, first_name, middle_name, birth_date, record_book_no " +
                    "FROM students " +
                    "WHERE EXTRACT(MONTH FROM birth_date) = ? " +
                    "ORDER BY last_name, first_name";

    @Override
    public List<Student> findByBirthMonth(int month) {
        List<Student> result = new ArrayList<>();

        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(FIND_BY_MONTH_SQL)) {

            ps.setInt(1, month);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String lastName = rs.getString("last_name");
                    String firstName = rs.getString("first_name");
                    String middleName = rs.getString("middle_name");
                    Date date = rs.getDate("birth_date");
                    String recordBookNo = rs.getString("record_book_no");

                    LocalDate birthDate = date.toLocalDate();

                    Student student = new Student(
                            id,
                            lastName,
                            firstName,
                            middleName,
                            birthDate,
                            recordBookNo
                    );

                    result.add(student);
                }
            }

        } catch (SQLException e) {
            System.err.println("Помилка при виконанні запиту: " + e.getMessage());
        }

        return result;
    }
}
