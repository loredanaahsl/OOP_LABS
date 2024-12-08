package lab4.task2;

import lab4.task3.Car;
import lab4.task3.FuelType;

public class ElectricStation implements Refuelable {

    private int refuelCount = 0;

    @Override
    public void refuel(int carId) {
        System.out.println("Refueling electricity for Car #" + carId);
        refuelCount++;
    }

    public int getRefuelCount() {
        return refuelCount;
    }

    @Override
    public boolean matches(Car car) {
        return car.getType() == FuelType.ELECTRIC;
    }
}
