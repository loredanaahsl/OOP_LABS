package Lab2.Task2;

public class Cappuccino extends Coffee {
    private final int mlOfMilk;
    private static final String coffee = "Cappuccino";

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public String getName() {
        return coffee;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Milk: " + mlOfMilk + " mg");
    }
}
