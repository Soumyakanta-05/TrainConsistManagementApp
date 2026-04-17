import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");

        assertEquals("Petroleum", b.getCargo());
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("Rectangular");
        b.assignCargo("Petroleum");

        assertNull(b.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        b1.assignCargo("Petroleum"); // fails
        b2.assignCargo("Coal");      // continues

        assertEquals("Coal", b2.getCargo());
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie b = new GoodsBogie("Rectangular");

        assertDoesNotThrow(() -> b.assignCargo("Petroleum"));
    }
}