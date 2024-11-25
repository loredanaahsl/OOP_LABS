package Lab2.Task4.coffeeshop;

class Cappuccino extends Coffee {
    private Integer mlOfMilk;
    private static final String NAME = "Cappuccino";

    Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public Integer getMlOfMilk() {
        return mlOfMilk;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Amount of milk (ml): " + mlOfMilk);
    }

    public static Cappuccino makeCappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        Cappuccino newCappuccino = new Cappuccino(coffeeIntensity, mlOfMilk);
        System.out.println("Making " + newCappuccino.getName());
        System.out.println("Adding " + mlOfMilk + " mls of milk");
        return newCappuccino;
    }

    @Override
    public String toString() {
        return "Cappuccino with " +
                "milk: " + mlOfMilk +
                " ml and intensity " + coffeeIntensity;
    }
}