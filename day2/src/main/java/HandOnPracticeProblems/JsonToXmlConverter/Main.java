package HandOnPracticeProblems.JsonToXmlConverter;

import org.json.JSONObject;
import org.json.XML;

public class Main {
    public static void main(String[] args) {
        // JSON String
        String jsonString = "{ \"person\": { \"name\": \"John\", \"age\": 30, \"city\": \"New York\" } }";

        try {
            // Convert JSON String to JSONObject
            JSONObject jsonObject = new JSONObject(jsonString);

            // Convert JSONObject to XML
            String xml = XML.toString(jsonObject);

            // Print the XML output
            System.out.println("Converted XML:");
            System.out.println(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
