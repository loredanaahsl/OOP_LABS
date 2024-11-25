package Lab2.Task2;

public class PumpkinSpiceLatte extends Cappuccino {
    private final int mgOfPumpkinSpice;
    private static final String name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }
}