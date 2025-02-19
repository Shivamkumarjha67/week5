package PracticeProblems.ListToJSONArray;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tata", "Nano"));
        cars.add(new Car("Suzuki", "XYZ"));

        System.out.println(getJsonArray(cars));
    }

    public static String getJsonArray(List<Car> cars) {
        String jsonArray = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            jsonArray = objectMapper.writeValueAsString(cars);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }

        return jsonArray;
    }
}
