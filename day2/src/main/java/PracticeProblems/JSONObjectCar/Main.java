package PracticeProblems.JSONObjectCar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setMake("Tata");
        car.setModel("Nano");
        car.setYear(2012);

        System.out.println(getJson(car));
    }

    public static String getJson(Car car) {
        String carJson = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            carJson = objectMapper.writeValueAsString(car);
        } catch(JsonProcessingException e) {
            System.out.println(e);
        }

        return carJson;
    }
}
