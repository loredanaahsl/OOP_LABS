package Lab2.Task3;



public class Cappuccino extends Coffee {
    private Integer mlOfMilk;
    private static final String name = "Cappuccino";

    @Override
    public String getName() {
        return name;
    }

    public void setMlOfMilk(int value) {
        this.mlOfMilk = value;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Amount of milk (mls): " + mlOfMilk);
    }

    public Cappuccino makeCappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        Cappuccino newCappuccino = new Cappuccino();
        newCappuccino.coffeeIntensity = coffeeIntensity;
        newCappuccino.mlOfMilk = mlOfMilk;
        makeCoffee(coffeeIntensity, newCappuccino.getName());
        return newCappuccino;
    }
}