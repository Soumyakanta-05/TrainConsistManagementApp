import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static boolean binarySearch(String[] arr, String key) {

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

        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        boolean found = binarySearch(bogieIds, key);

        if (found) {
            System.out.println("Bogie Found!");
        } else {
            System.out.println("Bogie Not Found!");
        }
    }
}