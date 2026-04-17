class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    String type;
    String cargo;

    public GoodsBogie(String type) {
        this.type = type;
    }

    public void assignCargo(String cargo) {
        try {
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException("Petroleum not allowed in Rectangular bogie");
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Assignment attempt completed.");
        }
    }

    public String getCargo() {
        return cargo;
    }
}

public class Main {
    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        b1.assignCargo("Petroleum");   // ✅ safe

        GoodsBogie b2 = new GoodsBogie("Rectangular");
        b2.assignCargo("Petroleum");   // ❌ unsafe but handled

        System.out.println("Program continues...");
    }
}