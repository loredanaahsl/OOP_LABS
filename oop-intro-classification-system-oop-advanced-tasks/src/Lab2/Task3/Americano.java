package Lab2.Task3;


public class Americano extends Coffee {
    private int mlOfWater;
    private static final String name = "Americano";

    public Americano makeAmericano(Intensity coffeeIntensity, int mlOfWater) {
        Americano newAmericano = new Americano();
        newAmericano.coffeeIntensity = coffeeIntensity;
        newAmericano.mlOfWater = mlOfWater;
        makeCoffee(coffeeIntensity, newAmericano.getName());
        return newAmericano;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Amount of water (mls): " + mlOfWater);
    }
}