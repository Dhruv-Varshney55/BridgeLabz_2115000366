import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class FilterJsonByAge {
    public static void main(String[] args) throws Exception {
        String json = "[{\"name\":\"Dhruv\", \"age\":22}, {\"name\":\"Vikas\", \"age\":28}, {\"name\":\"Aditya\", \"age\":21}]";
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(json);

        List<JsonNode> filteredList = new ArrayList<>();
        for (JsonNode node : rootNode) {
            if (node.get("age").asInt() > 25) {
                filteredList.add(node);
            }
        }

        String filteredJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(filteredList);
        System.out.println(filteredJson);
    }
}