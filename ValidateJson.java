import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ValidateJson {
    public static void main(String[] args) {
        String json = "{ \"name\": \"Dhruv\", \"age\": 22 }";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            if (jsonNode.has("name") && jsonNode.has("age")) {
                System.out.println("Valid JSON Structure");
            } else {
                System.out.println("Invalid JSON Structure");
            }
        } catch (Exception e) {
            System.out.println("Invalid JSON");
        }
    }
}