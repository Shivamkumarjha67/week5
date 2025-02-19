package PracticeProblems.ReadAndExctract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    public String name;
    public int age;
    public String[] subjects;
}
