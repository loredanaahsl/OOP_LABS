package lab4.task2;

import lab4.task3.Car;

public interface Refuelable {
    void refuel(int carId);

    int getRefuelCount();

    boolean matches(Car car);

}
