package Lab2.Task3;


public class Coffee {
    protected Intensity coffeeIntensity;
    private static final String name = "Coffee";

    public Coffee makeCoffee(Intensity coffeeIntensity, String coffeeName) {
        Coffee newCoffee = new Coffee();
        newCoffee.coffeeIntensity = coffeeIntensity;
        return newCoffee;
    }

    public Intensity getIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printDetails() {
        System.out.println("Coffee name: " + getName());
        System.out.println("Coffee intensity: " + getIntensity());
    }
}