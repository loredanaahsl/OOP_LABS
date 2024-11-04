package task_1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    // constructor to initialize display attributes
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // method to compare display size (based on width * height)
    public void compareSize(Display other) {
        int thisSize = this.width * this.height;
        int otherSize = other.width * other.height;

        if (thisSize > otherSize) {
            System.out.println(this.model + " is larger than " + other.model + " based on size.");
        } else if (thisSize < otherSize) {
            System.out.println(other.model + " is larger than " + this.model + " based on size.");
        } else {
            System.out.println(this.model + " and " + other.model + " have the same size.");
        }
    }

    // method to compare display sharpness (ppi)
    public void compareSharpness(Display other) {
        if (this.ppi > other.ppi) {
            System.out.println(this.model + " is sharper than " + other.model + " based on PPI.");
        } else if (this.ppi < other.ppi) {
            System.out.println(other.model + " is sharper than " + this.model + " based on PPI.");
        } else {
            System.out.println(this.model + " and " + other.model + " have the same sharpness.");
        }
    }

    // method to compare both size and sharpness
    public void compareWithMonitor(Display other) {
        System.out.println("Comparing " + this.model + " with " + other.model + ":");
        this.compareSize(other);
        this.compareSharpness(other);
    }

    // new getter method for the model field
    public String getModel() {
        return model;
    }
}