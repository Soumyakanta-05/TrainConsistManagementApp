import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Rectangular", "Coal")
        );
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

        class MainTest {

            @Test
            void testLoopFilteringLogic() {
                List<Bogie> list = Arrays.asList(
                        new Bogie("Sleeper", 50),
                        new Bogie("AC Chair", 70)
                );

                List<Bogie> result = Main.filterWithLoop(list);

                assertEquals(1, result.size());
            }

            @Test
            void testStreamFilteringLogic() {
                List<Bogie> list = Arrays.asList(
                        new Bogie("Sleeper", 50),
                        new Bogie("AC Chair", 70)
                );

                List<Bogie> result = Main.filterWithStream(list);

                assertEquals(1, result.size());
            }

            @Test
            void testLoopAndStreamResultsMatch() {
                List<Bogie> list = Arrays.asList(
                        new Bogie("Sleeper", 80),
                        new Bogie("AC Chair", 70),
                        new Bogie("First Class", 40)
                );

                List<Bogie> loopResult = Main.filterWithLoop(list);
                List<Bogie> streamResult = Main.filterWithStream(list);

                assertEquals(loopResult.size(), streamResult.size());
            }

            @Test
            void testExecutionTimeMeasurement() {
                List<Bogie> list = new ArrayList<>();
                for (int i = 0; i < 1000; i++) {
                    list.add(new Bogie("Sleeper", i));
                }

                long start = System.nanoTime();
                Main.filterWithLoop(list);
                long end = System.nanoTime();

                long time = end - start;

                assertTrue(time > 0);
            }

            @Test
            void testLargeDatasetProcessing() {
                List<Bogie> list = new ArrayList<>();
                for (int i = 0; i < 10000; i++) {
                    list.add(new Bogie("Sleeper", i % 100));
                }

                List<Bogie> result = Main.filterWithStream(list);

                assertTrue(result.size() > 0);
            }
        }
        assertTrue(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_CylindricalWithInvalidCargo() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );

        assertFalse(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_NonCylindricalBogiesAllowed() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Open", "Grain"),
                new GoodsBogie("Box", "Coal")
        );

        assertTrue(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_MixedBogiesWithViolation() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Coal") // ❌ violation
        );

        assertFalse(Main.isTrainSafe(list));
    }

    @Test
    void testSafety_EmptyBogieList() {
        List<GoodsBogie> list = new ArrayList<>();

        assertTrue(Main.isTrainSafe(list));
    }
}