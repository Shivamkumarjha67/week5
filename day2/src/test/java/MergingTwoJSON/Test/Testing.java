package MergingTwoJSON.Test;

import PracticeProblems.MergingTwoJSON.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    void testMerging() {
        // Defining two JSON objects as strings
        String json1 = "{ \"name\": \"Raj\", \"age\": 13 }";
        String json2 = "{ \"email\": \"raj@yahoo.com\"}";

        String expectedJson = "{ \"name\": \"Raj\", \"age\": 13, \"email\": \"raj@yahoo.com\" }";
        String actualJson = Main.getMergedJSON(json1, json2);

        String normalizedExpectedJson = null;
        String normalizedActualJson = null;

        try {
            // Normalize both JSON strings using Jackson
            ObjectMapper objectMapper = new ObjectMapper();
            normalizedExpectedJson = objectMapper.writeValueAsString(objectMapper.readTree(expectedJson));
            normalizedActualJson = objectMapper.writeValueAsString(objectMapper.readTree(actualJson));
        } catch (Exception e) {
            System.out.println(e);
        }

        // Assert equality of normalized JSON strings
        assertEquals(normalizedExpectedJson, normalizedActualJson);
    }
}
