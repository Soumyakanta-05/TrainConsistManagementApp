import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC", 70)
        );

        List<Bogie> result = Main.filterUsingLoop(list);

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC", 70)
        );

        List<Bogie> result = Main.filterUsingStream(list);

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC", 70),
                new Bogie("FC", 40)
        );

        assertEquals(
                Main.filterUsingLoop(list).size(),
                Main.filterUsingStream(list).size()
        );
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("Sleeper", i));
        }

        long start = System.nanoTime();
        Main.filterUsingLoop(list);
        long end = System.nanoTime();

        assertTrue((end - start) > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 20000; i++) {
            list.add(new Bogie("Sleeper", i % 100));
        }

        List<Bogie> result = Main.filterUsingStream(list);

        assertTrue(result.size() > 0);
    }
}