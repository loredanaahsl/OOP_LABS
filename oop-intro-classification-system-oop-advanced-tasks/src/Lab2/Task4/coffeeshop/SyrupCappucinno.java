package Lab2.Task4.coffeeshop;


class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    private static final String NAME = "SyrupCappuccino";

    private SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public String getName() {
        return NAME;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Type of syrup: " + syrup);
    }

    public static SyrupCappuccino makeSyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        SyrupCappuccino newSyrupCappuccino = new SyrupCappuccino(coffeeIntensity, mlOfMilk, syrup);
        System.out.println("Making " + newSyrupCappuccino.getName());
        System.out.println("Adding " + syrup + " syrup");
        return newSyrupCappuccino;
    }
    @Override
    public String toString() {
        return "SyrupCappuccino with " +
                "milk: " + getMlOfMilk() +
                " ml and intensity " + coffeeIntensity +
                " with syrup of " + syrup;
    }
}
