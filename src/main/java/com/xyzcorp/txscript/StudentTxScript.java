package com.xyzcorp.txscript;

import java.sql.*;
import java.util.function.Supplier;

public class StudentTxScript {
    private final Supplier<Connection> supplier;

    public StudentTxScript(Supplier<Connection> supplier) {
        this.supplier = supplier;
    }

    StudentId persist(Student student) {
        StudentId result = null;
        try {
            try (Connection connection = supplier.get()) {
                connection.setAutoCommit(false);
                String sql = "INSERT INTO   REGISTRATION (FIRSTNAME, LASTNAME, STUDENTID) VALUES (?, ?, ?)";
                try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, student.getFirstName());
                    stmt.setString(2, student.getLastName());
                    stmt.setLong(3, student.getStudentId().value());
                    stmt.execute();
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    boolean next = generatedKeys.next();
                    if (next) {
                        result = new StudentId(generatedKeys.getLong(1));
                    }
                    connection.commit();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    connection.rollback();
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
}
