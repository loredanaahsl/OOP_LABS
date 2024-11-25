package Lab2.Task1;

public class SyrupCappuccino extends Cappuccino {
    private final SyrupType syrup;
    private static final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensityCoffee, int mlOfMilk, SyrupType syrup) {
        super(intensityCoffee, mlOfMilk);
        this.syrup = syrup;
    }

    @Override
    public String getName() {
        return coffee;
    }
}