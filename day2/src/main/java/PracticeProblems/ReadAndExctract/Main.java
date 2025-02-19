package PracticeProblems.ReadAndExctract;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student = getExtractedValue();

        System.out.println("Name of the student is: " + student.name);
        System.out.println("Age is: " + student.age);
        System.out.println("Subject studies is: " + Arrays.toString(student.subjects));
    }

    public static Student getExtractedValue() {
        Student student = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            student = objectMapper.readValue(new File("src\\main\\java\\PracticeProblems\\ReadAndExctract\\Student.json"), Student.class);

        } catch (Exception e) {

        }

        return student;
    }
}
