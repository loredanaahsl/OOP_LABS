package Lab2.Task2;

public abstract class Coffee {
    private final Intensity coffeeIntensity;
    private static final String name = "Coffee";

    protected Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee intensity: " + coffeeIntensity);
    }
}