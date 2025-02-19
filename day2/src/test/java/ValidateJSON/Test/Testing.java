package ValidateJSON.Test;

import PracticeProblems.ValidateJSON.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    @Test
    void getValidationResult() {
        assertTrue(Main.validate());
    }
}
