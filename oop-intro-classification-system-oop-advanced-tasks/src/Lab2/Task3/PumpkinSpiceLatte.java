package Lab2.Task3;


public class PumpkinSpiceLatte extends Cappuccino {
    private int mgOfPumpkinSpice;
    private static final String name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte newPumpkinSpiceLatte = new PumpkinSpiceLatte();
        newPumpkinSpiceLatte.setMlOfMilk(mlOfMilk);
        newPumpkinSpiceLatte.coffeeIntensity = coffeeIntensity;
        newPumpkinSpiceLatte.mgOfPumpkinSpice = mgOfPumpkinSpice;
        makeCappuccino(coffeeIntensity, mlOfMilk);
        return newPumpkinSpiceLatte;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Amount of pumpkin spice (mgs): " + mgOfPumpkinSpice);
    }
}