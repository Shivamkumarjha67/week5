package JSONObjectStudent.Test;

import PracticeProblems.JSONObjectStudent.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    void testCreationOfJSONObject() {
        System.out.println(Main.createJSONObject());
        assertEquals("{\"subjects\":[\"Java\",\"HTML\",\"OS\",\"Spring\"],\"name\":\"Shivam\",\"age\":22}\n", Main.createJSONObject());
    }
}
