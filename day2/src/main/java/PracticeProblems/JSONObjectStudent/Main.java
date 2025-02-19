package PracticeProblems.JSONObjectStudent;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        System.out.println(createJSONObject());
    }

    public static JSONObject createJSONObject() {
        JSONArray subjects = new JSONArray();
        subjects.put("Java");
        subjects.put("HTML");
        subjects.put("OS");
        subjects.put("Spring");

        JSONObject student1 = new JSONObject();
        student1.put("subjects", subjects);
        student1.put("name", "Shivam");
        student1.put("age", 22);

        return student1;
    }
}
