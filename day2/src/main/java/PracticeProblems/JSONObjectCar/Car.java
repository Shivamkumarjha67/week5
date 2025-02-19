package PracticeProblems.JSONObjectCar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    @JsonProperty
    private String make;
    private String model;
    private int year;

    // Getters and Setters
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

