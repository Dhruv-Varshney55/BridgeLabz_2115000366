import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CreateStudentJSON {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        Map<String, Object> student = new HashMap<>();
        student.put("name", "Dhruv Varshney");
        student.put("age", 22);
        student.put("subjects", Arrays.asList("Math", "Science", "English"));

        String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
        System.out.println(jsonString);
    }
}