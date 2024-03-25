package com.xyzcorp.txscript;

public class Student {
    private final StudentId studentId;
    private final String firstName;
    private final String lastName;

    public Student(StudentId studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
