package dao;

import connection.DatabaseConnection;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public Student insert(Student student) throws SQLException {

        String sql = """
                INSERT INTO students (name, lastname, email, career_id)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conex = DatabaseConnection.getConnection();
             PreparedStatement prepareQuery = conex.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            prepareQuery.setString(1, student.getName());
            prepareQuery.setString(2, student.getLastname());
            prepareQuery.setString(3, student.getEmail());
            prepareQuery.setInt(4, student.getCareerId());

            int columnasInsertadas = prepareQuery.executeUpdate();

            if (columnasInsertadas == 0) {
                throw new SQLException("No se insertó el estudiante");
            }

            try (ResultSet resultado = prepareQuery.getGeneratedKeys()) {
                if (resultado.next()) {
                    student.setId(resultado.getInt(1));
                }
            }
        }

        return student;
    }

    public List<Student> listAll() throws SQLException {

        String sql = """
            SELECT s.id,
                   s.name,
                   s.lastname,
                   s.email,
                   c.id AS career_id,
                   c.name AS career_name
            FROM students s
            JOIN careers c ON s.career_id = c.id
            """;

        List<Student> students = new ArrayList<>();

        try (Connection conex = DatabaseConnection.getConnection();
             PreparedStatement statement = conex.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {

                Student student = new Student();

                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setLastname(rs.getString("lastname"));
                student.setEmail(rs.getString("email"));
                student.setCareerId(rs.getInt("career_id"));

                students.add(student);
            }
        }

        return students;
    }
}