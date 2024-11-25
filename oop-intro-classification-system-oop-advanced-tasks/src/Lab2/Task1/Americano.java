package Lab2.Task1;

public class Americano extends Coffee {
    private final int mlOfWater;
    private static final String coffeeName = "Americano";

    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public String getName() {
        return coffeeName;
    }
}