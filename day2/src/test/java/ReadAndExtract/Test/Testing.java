package ReadAndExtract.Test;

import PracticeProblems.ReadAndExctract.Main;
import PracticeProblems.ReadAndExctract.Student;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    void testExtractedResult() {
        String expectedOutput = "Raj 20 Physics Maths";
        Student student = Main.getExtractedValue();
        String resultant = student.name;
        resultant += (" " + student.age);
        resultant += (" " + student.subjects[0] + " " + student.subjects[1]);

        assertEquals(expectedOutput, resultant);
    }
}
