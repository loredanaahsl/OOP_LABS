package crashTest.queueServing;

import lab4.task2.ElectricStation;
import lab4.task2.RobotDinner;
import lab4.task3.Car;
import lab4.task3.CarStation;
import lab4.task3.FuelType;
import lab4.task3.PassengersType;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class QueueServingTest {

    @Test
    void testQueueWork() {
        CarStation carStation = new CarStation(new RobotDinner(), new ElectricStation());
        carStation.addCar(new Car(1, FuelType.ELECTRIC, PassengersType.ROBOTS, true, 10));
        carStation.addCar(new Car(2, FuelType.ELECTRIC, PassengersType.ROBOTS, false, 10));
        carStation.addCar(new Car(3, FuelType.ELECTRIC, PassengersType.ROBOTS, true, 10));
        assertEquals(3, carStation.getQueueLength());
        carStation.serveCars();
        assertEquals(0, carStation.getQueueLength());
    }

    @Test
    void testDianableCount() {
        CarStation carStation = new CarStation(new RobotDinner(), new ElectricStation());
        carStation.addCar(new Car(1, FuelType.ELECTRIC, PassengersType.ROBOTS, true, 10));
        carStation.addCar(new Car(2, FuelType.ELECTRIC, PassengersType.ROBOTS, false, 10));
        carStation.addCar(new Car(3, FuelType.ELECTRIC, PassengersType.ROBOTS, false, 10));
        carStation.serveCars();

        assertEquals(1, carStation.getDineableServiceClientCount());
        assertEquals(3, carStation.getRefuelableServiceClientCount());
        carStation.addCar(new Car(4, FuelType.ELECTRIC, PassengersType.ROBOTS, true, 10));

        // not served -> no difference
        assertEquals(1, carStation.getDineableServiceClientCount());
        assertEquals(3, carStation.getRefuelableServiceClientCount());

        // served car refueld and dinned
        carStation.serveCars();
        assertEquals(2, carStation.getDineableServiceClientCount());
        assertEquals(4, carStation.getRefuelableServiceClientCount());
    }
}
