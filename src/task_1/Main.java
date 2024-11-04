package task_1;

public class Main {
    public static void main(String[] args) {
        // instantiate three display objects
        Display display1 = new Display(1920, 1080, 401, "Display A");
        Display display2 = new Display(2560, 1440, 326, "Display B");
        Display display3 = new Display(3840, 2160, 218, "Display C");

        // compare displays in terms of size and sharpness
        display1.compareWithMonitor(display2); // comparing display1 and display2
        display1.compareWithMonitor(display3); // comparing display1 and display3
        display2.compareWithMonitor(display3); // comparing display2 and display3
    }
}