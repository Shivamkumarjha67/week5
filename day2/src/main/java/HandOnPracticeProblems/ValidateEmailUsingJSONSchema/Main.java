package HandOnPracticeProblems.ValidateEmailUsingJSONSchema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            // Load JSON schema
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode schemaNode = objectMapper.readTree(new File("src\\main\\java\\HandOnPracticeProblems\\ValidateEmailUsingJSONSchema\\schema.json"));

            // Load JSON data
            JsonNode dataNode = objectMapper.readTree(new File("src\\main\\java\\HandOnPracticeProblems\\ValidateEmailUsingJSONSchema\\data.json"));

            // Create a JsonSchema instance
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);

            // Validate JSON data
            ProcessingReport report = schema.validate(dataNode);

            // Print validation result
            if (report.isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("JSON validation failed:");
                System.out.println(report);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}