import java.util.Arrays;

public class Main {

    public static boolean searchBogie(String[] arr, String key) {

        if (arr == null || arr.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        Arrays.sort(arr);

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = key.compareTo(arr[mid]);

            if (result == 0) {
                return true;
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String[] bogieIds = {};

        try {
            boolean found = searchBogie(bogieIds, "BG101");

            if (found) {
                System.out.println("Bogie Found!");
            } else {
                System.out.println("Bogie Not Found!");
            }

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}