package lab4.task2;

import lab4.task3.Car;
import lab4.task3.PassengersType;

public class RobotDinner implements Dineable {


    @Override
    public void serveDinner(int cardId) {
        System.out.println("Serving dinner to robots in Car #" + cardId);
        dinnerServed++;
    }

    private int dinnerServed = 0;
    public int getDinnerServed() {
        return dinnerServed;
    }

    @Override
    public boolean matches(Car car) {
        return car.getPassengers() == PassengersType.ROBOTS;
    }
}
