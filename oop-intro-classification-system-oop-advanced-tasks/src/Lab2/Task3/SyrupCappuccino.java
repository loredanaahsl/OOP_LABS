package Lab2.Task3;

public class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private static final String name = "SyrupCappuccino";

    public SyrupCappuccino makeSyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        SyrupCappuccino newSyrupCappuccino = new SyrupCappuccino();
        newSyrupCappuccino.setMlOfMilk(mlOfMilk);
        newSyrupCappuccino.coffeeIntensity = coffeeIntensity;
        newSyrupCappuccino.syrup = syrup;
        makeCappuccino(coffeeIntensity, mlOfMilk);
        return newSyrupCappuccino;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Type of syrup: " + syrup);
    }
}