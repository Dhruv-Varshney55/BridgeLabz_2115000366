import java.io.*;
import java.sql.*;

public class GenerateCSVFromDatabase {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        String csvFile = "EmployeesReport.csv";
        try(Connection conn = DriverManager.getConnection(jdbcURL, username, password);
            Statement stmt = conn.createStatement();
            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile))) {
            String query = "SELECT id, name, department, salary FROM employees";
            ResultSet rs = stmt.executeQuery(query);
            writer.write("Employee ID,Name,Department,Salary");
            writer.newLine();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String department = rs.getString("department");
                double salary = rs.getDouble("salary");

                writer.write(id + "," + name + "," + department + "," + salary);
                writer.newLine();
            }
            System.out.println("CSV report generated: " + csvFile);

        }
		catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}