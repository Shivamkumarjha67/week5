package PracticeProblems.ParseJson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println(getAllGreaterThan25());
    }

    public static String getAllGreaterThan25() {
        String result = "";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File("src\\main\\java\\PracticeProblems\\ParseJson\\User.json"));

            for(JsonNode user : jsonNode) {
                if(user.get("age").asInt() > 25) {
                    result += user.get("name").toString() + " ";
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return result;
    }
}
