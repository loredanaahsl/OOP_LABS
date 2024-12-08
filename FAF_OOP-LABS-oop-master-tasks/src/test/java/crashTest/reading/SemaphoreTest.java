package crashTest.reading;

import lab4.task1.DontReinventTheWheelQueue;
import lab4.task2.ElectricStation;
import lab4.task2.GasStation;
import lab4.task2.PeopleDinner;
import lab4.task2.RobotDinner;
import lab4.task3.Car;
import lab4.task3.CarStation;
import lab4.task4.Semaphore;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static java.lang.Long.sum;
import static junit.framework.Assert.assertEquals;

public class SemaphoreTest {

    @Test
    void testSemaphore() {
        Semaphore semaphore = new Semaphore("src/main/resources/lab4/queue");
        var cars = semaphore.scanCars(false);
        cars.forEach(System.out::println);
        assertEquals(cars.size(), 30);
    }

    @Test
    void testSemaphoreQueueDistribution() {
        Semaphore semaphore = new Semaphore("src/main/resources/lab4/testqueue");
        // gas - people - notdinning
        // electric - people - notdinning
        // electric - people - dinning

        // 1 gas refuel, 2 electric refuel
        // 1 people dinner

        CarStation robotsElectric = new CarStation(new RobotDinner(), new ElectricStation());
        CarStation robotsGas = new CarStation(new RobotDinner(), new GasStation());
        CarStation peopleElectric = new CarStation(new PeopleDinner(), new ElectricStation());
        CarStation peopleGas = new CarStation(new PeopleDinner(), new GasStation(), new DontReinventTheWheelQueue<>());

        semaphore.addStation(robotsElectric);
        semaphore.addStation(robotsGas);
        semaphore.addStation(peopleElectric);
        semaphore.addStation(peopleGas);

        semaphore.distributeHighwayCarsToQueues(false);
        semaphore.getCarStationList().forEach(CarStation::serveCars);

        int totalElectricRefuels = semaphore.getCarStationList().stream()
                .filter(s -> ElectricStation.class.isAssignableFrom(s.getRefuelServiceType()))
                .mapToInt(CarStation::getRefuelableServiceClientCount)
                .sum();

        int totalGasRefuels = semaphore.getCarStationList().stream()
                .filter(s -> GasStation.class.isAssignableFrom(s.getRefuelServiceType()))
                .mapToInt(CarStation::getRefuelableServiceClientCount)
                .sum();

        int totalPeopleDinnerServed = semaphore.getCarStationList().stream()
                .filter(s -> s.getDinnerServiceType().equals(PeopleDinner.class))
                .mapToInt(CarStation::getDineableServiceClientCount)
                .sum();

        int totalRobotsDinnerServed = semaphore.getCarStationList().stream()
                .filter(s -> s.getDinnerServiceType().equals(RobotDinner.class))
                .mapToInt(CarStation::getDineableServiceClientCount)
                .sum();

        int totalDinnerServed = semaphore.getCarStationList().stream().mapToInt(CarStation::getDineableServiceClientCount).sum();

        assertEquals(2, totalElectricRefuels);
        assertEquals(1, totalGasRefuels);
        assertEquals(1, totalPeopleDinnerServed);
        assertEquals(0, totalRobotsDinnerServed);
        assertEquals(1, totalDinnerServed);
    }

}
