package edu.ntu.bykov.lr5.model;

import java.time.LocalDate;

public class Student {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String recordBookNo;

    public Student(long id,
                   String lastName,
                   String firstName,
                   String middleName,
                   LocalDate birthDate,
                   String recordBookNo) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.recordBookNo = recordBookNo;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getRecordBookNo() {
        return recordBookNo;
    }

    @Override
    public String toString() {
        return String.format(
                "%d: %s %s %s, %s, залікова: %s",
                id,
                lastName,
                firstName,
                middleName,
                birthDate,
                recordBookNo
        );
    }
}
