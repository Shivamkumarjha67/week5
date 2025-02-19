package ReadJSONAndPrint.Test;

import HandOnPracticeProblems.ReadJSONAndPrint.Main;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    void getResult() {
        String expectedOutput = "\nBrand = Tata\n" +
                "Model = Nano\n" +
                "OriginatedFrom = India\n" +
                "Owner = Tata Sons";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("src\\main\\java\\HandOnPracticeProblems\\ReadJSONAndPrint\\Car.json"));

            // Call the function and check assertion
            assertEquals(expectedOutput, Main.printKeyValue(rootNode, "", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
