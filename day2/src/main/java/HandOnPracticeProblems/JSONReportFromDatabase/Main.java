package HandOnPracticeProblems.JSONReportFromDatabase;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // JDBC connection variables
        String jdbcUrl = "jdbc:mysql://localhost:3306/LAPTOP112";
        String username = "shiv108";
        String password = "shiv44";

        // JSON generation
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            // Query the database
            String query = "SELECT id, name, age, department FROM employees";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // List to hold the records as maps
            List<Map<String, Object>> employeeList = new ArrayList<>();

            // Process each record
            while (resultSet.next()) {
                Map<String, Object> employee = new HashMap<>();
                employee.put("id", resultSet.getInt("id"));
                employee.put("name", resultSet.getString("name"));
                employee.put("age", resultSet.getInt("age"));
                employee.put("department", resultSet.getString("department"));
                employeeList.add(employee);
            }

            // Convert List to JSON using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeList);

            // Print the JSON report
            System.out.println("JSON Report:");
            System.out.println(jsonReport);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
