package HandOnPracticeProblems.JavaObjectToJSONObject;

import PracticeProblems.ListToJSONArray.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee("Ajay", 70, "ajay@example.com"));
        empList.add(new Employee("Babli", 45, "babli@example.com"));
        empList.add(new Employee("Chandan", 25, "chandan@example.com"));

        System.out.println(getJsonArray(empList));
    }

    public static String getJsonArray(List<Employee> employees) {
        String jsonArray = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonArray = objectMapper.writeValueAsString(employees);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }

        return jsonArray;
    }
}