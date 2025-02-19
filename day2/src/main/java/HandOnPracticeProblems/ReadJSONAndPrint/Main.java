package HandOnPracticeProblems.ReadJSONAndPrint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON file into a JsonNode
            JsonNode rootNode = objectMapper.readTree(new File("src\\main\\java\\HandOnPracticeProblems\\ReadJSONAndPrint\\Car.json"));

            // Call the function to print keys and values
            System.out.println(printKeyValue(rootNode, "", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String printKeyValue(JsonNode node, String parentKey, String result) {
        if (node.isObject()) {
            // If the node is an object, iterate through its fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                String key = parentKey.isEmpty() ? field.getKey() : parentKey + "." + field.getKey();
                result = printKeyValue(field.getValue(), key, result);
            }
        } else if (node.isArray()) {
            // If the node is an array, iterate through its elements
            int index = 0;
            for (JsonNode element : node) {
                result = printKeyValue(element, parentKey + "[" + index + "]", result);
                index++;
            }
        } else {
            // If the node is a value, print the key and value
            result += "\n";
            result += (parentKey + " = " + node.asText());
        }

        return result;
    }
}