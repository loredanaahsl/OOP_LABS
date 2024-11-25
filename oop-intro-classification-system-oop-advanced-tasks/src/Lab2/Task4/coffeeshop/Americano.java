package Lab2.Task4.coffeeshop;


class Americano extends Coffee {
    private Integer mlOfWater;
    private static final String NAME = "Americano";

    private Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Integer getMlOfWater() {
        return mlOfWater;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Amount of water (ml): " + mlOfWater);
    }

    public static Americano makeAmericano(Intensity coffeeIntensity, int mlOfWater) {
        Americano newAmericano = new Americano(coffeeIntensity, mlOfWater);
        System.out.println("Making " + newAmericano.getName());
        System.out.println("Adding " + mlOfWater + " mls of water");
        return newAmericano;
    }

    @Override
    public String toString() {
        return "Americano " +
                " with ml of water:" + mlOfWater +
                " and intensity " + coffeeIntensity;
    }
}
