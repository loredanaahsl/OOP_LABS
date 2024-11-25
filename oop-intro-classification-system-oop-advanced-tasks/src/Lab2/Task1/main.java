package Lab2.Task1;


public class main {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        Americano americano = new Americano(Intensity.STRONG, 70);
        PumpkinSpiceLatte psl = new PumpkinSpiceLatte(Intensity.LIGHT, 100, 150);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 80, SyrupType.CARAMEL);

        //System.out.println(syrupCappuccino.getName());
        // System.out.println(cappuccino.getName());
        // System.out.println(psl.getName());
        // System.out.println(americano.getName());
    }
}
