import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateJsonFromDB {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name, age, email FROM users");

        List<Map<String, Object>> userList = new ArrayList<>();
        while (rs.next()) {
            userList.add(Map.of(
                "name", rs.getString("name"),
                "age", rs.getInt("age"),
                "email", rs.getString("email")
            ));
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonReport = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userList);

        System.out.println(jsonReport);
        conn.close();
    }
}