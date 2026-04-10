import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Main.isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Main.isValidTrainId("TRAIN12"));
        assertFalse(Main.isValidTrainId("TRN12A"));
        assertFalse(Main.isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Main.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Main.isValidCargoCode("PET-ab"));
        assertFalse(Main.isValidCargoCode("PET123"));
        assertFalse(Main.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Main.isValidTrainId("TRN-123"));
        assertFalse(Main.isValidTrainId("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Main.isValidCargoCode("PET-aB"));
        assertFalse(Main.isValidCargoCode("PET-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Main.isValidTrainId(""));
        assertFalse(Main.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(Main.isValidTrainId("TRN-1234X"));
        assertFalse(Main.isValidCargoCode("PET-ABC"));
    }
}