package ListToJSONArray.Test;

import PracticeProblems.ListToJSONArray.Car;
import PracticeProblems.ListToJSONArray.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {
    @Test
    void checkJSONArray() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tata", "Nano"));
        cars.add(new Car("Suzuki", "XYZ"));

        String expectedJson = "[{\"name\":\"Tata\",\"model\":\"Nano\"},{\"name\":\"Suzuki\",\"model\":\"XYZ\"}]\n";
        String actualJson = Main.getJsonArray(cars);

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
