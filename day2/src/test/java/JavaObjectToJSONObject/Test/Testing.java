package JavaObjectToJSONObject.Test;


import HandOnPracticeProblems.JavaObjectToJSONObject.Employee;
import HandOnPracticeProblems.JavaObjectToJSONObject.Main;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Testing {
    @Test
    void checkJSONArray() {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Ajay", 70, "ajay@example.com"));
        empList.add(new Employee("Babli", 45, "babli@example.com"));
        empList.add(new Employee("Chandan", 25, "chandan@example.com"));


        String expectedJson = "[{\"name\":\"Ajay\",\"age\":70,\"email\":\"ajay@example.com\"},{\"name\":\"Babli\",\"age\":45,\"email\":\"babli@example.com\"},{\"name\":\"Chandan\",\"age\":25,\"email\":\"chandan@example.com\"}]\n";
        String actualJson = Main.getJsonArray(empList);

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
