import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class Main {

    public static List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", i % 100));
        }

        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterUsingLoop(bogies);
        long endLoop = System.nanoTime();

        long loopTime = endLoop - startLoop;

        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterUsingStream(bogies);
        long endStream = System.nanoTime();

        long streamTime = endStream - startStream;

        System.out.println("Loop Time: " + loopTime + " ns");
        System.out.println("Stream Time: " + streamTime + " ns");

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());
    }
}