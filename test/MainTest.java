import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("AC Chair", 60)
        );

        int total = Main.calculateTotalSeats(list);

        assertEquals(140, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 80),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        int total = Main.calculateTotalSeats(list);

        assertEquals(210, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Arrays.asList(
                new Bogie("First Class", 40)
        );

        int total = Main.calculateTotalSeats(list);

        assertEquals(40, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();

        int total = Main.calculateTotalSeats(list);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 50)
        );

        int total = Main.calculateTotalSeats(list);

        assertEquals(100, total);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 30),
                new Bogie("AC Chair", 40),
                new Bogie("First Class", 50)
        );

        int total = Main.calculateTotalSeats(list);

        assertEquals(120, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("Sleeper", 80));
        list.add(new Bogie("AC Chair", 60));

        int sizeBefore = list.size();

        Main.calculateTotalSeats(list);

        assertEquals(sizeBefore, list.size());
    }
}