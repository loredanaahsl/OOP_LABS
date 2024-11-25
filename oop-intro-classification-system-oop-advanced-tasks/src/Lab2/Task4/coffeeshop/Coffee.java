package Lab2.Task4.coffeeshop;

enum Intensity {
    LIGHT, NORMAL, STRONG
}

enum SyrupType {
    MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
}

class Coffee {
    protected Intensity coffeeIntensity;
    private static final String name = "Coffee";

    Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getIntensity() {
        return coffeeIntensity;
    }

    protected String getName() {
        return name;
    }

    protected void printDetails() {
        System.out.println("Coffee name: " + getName());
        System.out.println("Coffee intensity: " + getIntensity());
    }

}

