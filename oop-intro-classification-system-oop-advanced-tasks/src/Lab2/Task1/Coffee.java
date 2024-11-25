package Lab2.Task1;

public class Coffee {
    private final Intensity coffeeIntensity;
    private static final String name = "Coffee";

    protected Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public String getName() {
        return name;
    }
}