import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        System.out.println("Before Sorting:");
        System.out.println(Arrays.toString(bogieNames));

        Arrays.sort(bogieNames);

        System.out.println("After Sorting:");
        System.out.println(Arrays.toString(bogieNames));
    }
}