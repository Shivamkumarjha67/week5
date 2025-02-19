package HandOnPracticeProblems.CSVToJSON;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // Load the CSV file
            File csvFile = new File("data.csv");

            // Create CsvMapper and CsvSchema
            CsvMapper csvMapper = new CsvMapper();
            CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();

            // Read CSV into List of Maps (each row as a Map)
            MappingIterator<Map<String, String>> mappingIterator =
                    csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);
            List<Map<String, String>> rows = mappingIterator.readAll();

            // Convert List of Maps to JSON
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rows);

            // Print JSON output
            System.out.println("Converted JSON:");
            System.out.println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

