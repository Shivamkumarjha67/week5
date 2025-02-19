package JSONObjectCar.Test;

import PracticeProblems.JSONObjectCar.Car;
import PracticeProblems.JSONObjectCar.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    void getResultantJSON() {
        Car car = new Car();
        car.setMake("Tata");
        car.setModel("Nano");
        car.setYear(2012);

        assertEquals("{\"make\":\"Tata\",\"model\":\"Nano\",\"year\":2012}",Main.getJson(car));
    }

}
