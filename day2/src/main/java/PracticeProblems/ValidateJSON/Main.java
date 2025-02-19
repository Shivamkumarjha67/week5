package PracticeProblems.ValidateJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.json.JSONObject;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Print validation results
        if (validate()) {
            System.out.println("JSON is valid!");
        } else {
            System.out.println("JSON is invalid!");
        }
    }

    public static boolean validate() {
        ProcessingReport report = null;

        try {
            // Load the JSON data and schema from files
            JsonNode schemaNode = JsonLoader.fromFile(new File("src\\main\\java\\PracticeProblems\\ValidateJSON\\schema.json"));
            JsonNode dataNode = JsonLoader.fromFile(new File("src\\main\\java\\PracticeProblems\\ValidateJSON\\data.json"));

            // Create a JsonSchemaFactory and validate the data
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(schemaNode);
            report = schema.validate(dataNode);
        } catch (Exception e) {
            System.out.println(e);
        }

        return report.isSuccess();
    }
}
