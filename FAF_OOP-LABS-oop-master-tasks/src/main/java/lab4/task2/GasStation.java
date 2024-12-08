package lab4.task2;

import lab4.task3.Car;
import lab4.task3.FuelType;

public class GasStation implements Refuelable {


    private int refuelCount = 0;

    public int getRefuelCount() {
        return refuelCount;
    }

    @Override
    public boolean matches(Car car) {
        return car.getType() == FuelType.GAS;
    }

    @Override
    public void refuel(int carId) {
        System.out.println("Refueling gas for Car #" + carId);
        refuelCount++;

    }


}
