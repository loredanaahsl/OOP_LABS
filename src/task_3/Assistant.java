package task_3;

import task_1.Display;
import java.util.ArrayList;
import java.util.List;

// assistant class to manage and assist with display choices
public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    // constructor to initialize the assistant with an empty list of displays
    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    // assigns a display to the assistant by adding it to the list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    // assists by comparing each display in the assigned list sequentially
    public void assist() {
        System.out.println("Assistant " + assistantName + " is helping you compare displays...");

        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            Display current = assignedDisplays.get(i);
            Display next = assignedDisplays.get(i + 1);

            System.out.println("\nComparing " + current.getModel() + " with " + next.getModel() + ":");
            current.compareWithMonitor(next);
        }

        System.out.println("Comparison complete!");
    }

    // allows the user to buy aka remove a display from the list
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println(d.getModel() + " has been bought and removed from the list.");
            return d;
        } else {
            System.out.println(d.getModel() + " is not found in the list.");
            return null;
        }
    }
}