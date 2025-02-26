import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class ConvertJsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        XmlMapper xmlMapper = new XmlMapper();

        String json = "{ \"name\": \"Dhruv\", \"age\": 22 }";
        JsonNode jsonNode = objectMapper.readTree(json);
        String xml = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        System.out.println(xml);
    }
}