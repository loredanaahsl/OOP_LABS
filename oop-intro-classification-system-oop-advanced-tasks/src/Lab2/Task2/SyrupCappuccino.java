package Lab2.Task2;

public class SyrupCappuccino extends Cappuccino {
    private final SyrupType syrup;
    private static final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensityCoffee, int mlOfMilk, SyrupType syrup) {
        super(intensityCoffee, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public String getName() {
        return coffee;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Syrup type: " + syrup);
    }
}