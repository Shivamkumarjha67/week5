package ParseJSON.Test;

import PracticeProblems.ParseJson.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    void checkGraterAge() {
        String expectedOutput = "\"Raj\" \"Pankaj\" ";
        assertEquals(expectedOutput, Main.getAllGreaterThan25());
    }
}
