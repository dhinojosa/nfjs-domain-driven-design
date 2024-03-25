package com.xyzcorp.txscript;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGConnectionPoolDataSource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
public class StudentTxScriptTest {

    @Container
    private static final PostgreSQLContainer<?> postgresSQLContainer =
        new PostgreSQLContainer<>("postgres:14.5")
            .withInitScript("import.sql")
            .withDatabaseName("school");
    private static PGConnectionPoolDataSource source;
    private StudentTxScript studentTxScript;

    @BeforeEach
    void setUp() {
        source = new PGConnectionPoolDataSource();
        source.setUser(postgresSQLContainer.getUsername());
        source.setPassword(postgresSQLContainer.getPassword());
        source.setUrl(postgresSQLContainer.getJdbcUrl());
        source.setDatabaseName(postgresSQLContainer.getDatabaseName());
        System.out.println("Starting Container!");
        System.out.printf("Username: %s%n", postgresSQLContainer.getUsername());
        System.out.printf("Password: %s%n", postgresSQLContainer.getPassword());
        System.out.printf("URL: %s%n", postgresSQLContainer.getJdbcUrl());
        System.out.printf("Database: %s%n", postgresSQLContainer.getDatabaseName());
        studentTxScript = new StudentTxScript(() -> {
            try {
                return source.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Test
    void testInsertStudent() {
        Student student = new Student(new StudentId(3030), "Buland", "Malik");
        StudentId result = studentTxScript.persist(student);
        assertThat(result).isInstanceOf(StudentId.class).isNotNull();
        assertThat(result.value()).isGreaterThan(-1);
    }

}
