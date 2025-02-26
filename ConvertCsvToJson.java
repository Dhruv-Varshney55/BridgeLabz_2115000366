import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class ConvertCsvToJson {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("Data2.csv");

        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        MappingIterator<Map<String, String>> iterator = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);

        List<Map<String, String>> csvData = iterator.readAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvData);

        System.out.println(json);
    }
}