package edu.ntu.bykov.lr4.model;

import java.util.Objects;

public class Student extends Human {

    private String recordBookNumber;


    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String middleName, Sex sex) {
        super(firstName, lastName, middleName, sex);
    }

    public Student(String firstName,
                   String lastName,
                   String middleName,
                   Sex sex,
                   String recordBookNumber) {
        super(firstName, lastName, middleName, sex);
        this.recordBookNumber = recordBookNumber;
    }

    public String getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(String recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(recordBookNumber, student.recordBookNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), recordBookNumber);
    }
}
