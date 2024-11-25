package Lab2.Task3;

public class main {
    public static void main(String[] args) {
        Coffee cappuccino = new Cappuccino().makeCappuccino(Intensity.NORMAL, 100);
        Americano americano = new Americano().makeAmericano(Intensity.STRONG, 200);
        PumpkinSpiceLatte psl = new PumpkinSpiceLatte().makePumpkinSpiceLatte(Intensity.LIGHT, 100, 200);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino().makeSyrupCappuccino(Intensity.LIGHT, 100, SyrupType.CARAMEL);

        System.out.println();
        cappuccino.printDetails();
        System.out.println();
        americano.printDetails();
        System.out.println();
        syrupCappuccino.printDetails();
        System.out.println();
        psl.printDetails();
    }
}