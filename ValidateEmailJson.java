import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.ValidationMessage;
import java.util.Set;

public class ValidateEmailJson {
    public static void main(String[] args) throws Exception {
        String schemaJson = "{ \"type\": \"object\", \"properties\": { \"email\": { \"type\": \"string\", \"format\": \"email\" } }, \"required\": [\"email\"] }";
        String jsonToValidate = "{ \"email\": \"invalid-email\" }";

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode schemaNode = objectMapper.readTree(schemaJson);
        JsonNode dataNode = objectMapper.readTree(jsonToValidate);

        JsonSchemaFactory factory = JsonSchemaFactory.getInstance();
        JsonSchema schema = factory.getSchema(schemaNode);

        Set<ValidationMessage> errors = schema.validate(dataNode);
        if (errors.isEmpty()) {
            System.out.println("Valid JSON");
        } else {
            System.out.println("Invalid JSON: " + errors);
        }
    }
}