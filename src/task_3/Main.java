package task_3;

import task_1.Display;

public class Main {
    public static void main(String[] args) {
        // create some display objects
        Display displayA = new Display(1920, 1080, 401, "Display A");
        Display displayB = new Display(2560, 1440, 326, "Display B");
        Display displayC = new Display(3840, 2160, 218, "Display C");

        // create an assistant and assign displays
        Assistant assistant = new Assistant("Daniela");
        assistant.assignDisplay(displayA);
        assistant.assignDisplay(displayB);
        assistant.assignDisplay(displayC);

        // use assist() to compare displays
        assistant.assist();

        // use buyDisplay() to buy (remove) a specific display
        assistant.buyDisplay(displayB);

        // call assist() again to see the remaining comparisons
        assistant.assist();
    }
}