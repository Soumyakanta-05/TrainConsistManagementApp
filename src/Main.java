import java.util.*;

class GoodsBogie {
    String type;   // Cylindrical, Rectangular, etc.
    String cargo;  // Petroleum, Coal, Grain, etc.

    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public String toString() {
        return type + " -> " + cargo;
    }
}

public class Main {

    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical")
                                || b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Rectangular", "Coal"));
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        boolean safe = isTrainSafe(bogies);

        if (safe) {
            System.out.println("Train is SAFETY COMPLIANT");
        } else {
            System.out.println("Train is UNSAFE");
        }
    }
}