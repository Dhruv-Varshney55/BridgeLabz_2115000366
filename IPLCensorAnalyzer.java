import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class IPLCensorAnalyzer {
    public static void main(String[] args) throws Exception {
        String jsonInputFile = "ipl_data.json";
        String jsonOutputFile = "ipl_censored.json";
        String csvInputFile = "ipl_data.csv";
        String csvOutputFile = "ipl_censored.csv";

        censorJsonData(jsonInputFile, jsonOutputFile);
        censorCsvData(csvInputFile, csvOutputFile);

        System.out.println("Censorship applied. Check output files.");
    }

    private static void censorJsonData(String inputFile, String outputFile) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayNode matches = (ArrayNode) objectMapper.readTree(new File(inputFile));

        for (JsonNode match : matches) {
            ((ObjectNode) match).put("team1", maskTeamName(match.get("team1").asText()));
            ((ObjectNode) match).put("team2", maskTeamName(match.get("team2").asText()));
            ((ObjectNode) match).put("player_of_match", "REDACTED");

            ObjectNode scoreNode = (ObjectNode) match.get("score");
            for (String team : List.of(match.get("team1").asText(), match.get("team2").asText())) {
                if (scoreNode.has(team)) {
                    scoreNode.set(maskTeamName(team), scoreNode.get(team));
                    scoreNode.remove(team);
                }
            }
        }

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), matches);
    }

    private static void censorCsvData(String inputFile, String outputFile) throws Exception {
        File csvFile = new File(inputFile);
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();

        List<Map<String, String>> records = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile).readAll();

        for (Map<String, String> record : records) {
            record.put("team1", maskTeamName(record.get("team1")));
            record.put("team2", maskTeamName(record.get("team2")));
            record.put("player_of_match", "REDACTED");
        }

        CsvSchema outputSchema = CsvSchema.builder().setUseHeader(true)
                .addColumn("match_id")
                .addColumn("team1")
                .addColumn("team2")
                .addColumn("score")
                .addColumn("winner")
                .addColumn("player_of_match").build();

        csvMapper.writer(outputSchema).writeValue(new File(outputFile), records);
    }

    private static String maskTeamName(String team) {
        String[] parts = team.split(" ");
        return parts[0] + " ***";
    }
}