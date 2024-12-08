package lab4.task5;

import lab4.task2.ElectricStation;
import lab4.task2.GasStation;
import lab4.task2.PeopleDinner;
import lab4.task2.RobotDinner;
import lab4.task3.Car;
import lab4.task3.CarStation;
import lab4.task4.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        Timer timer = new Timer();

        Semaphore semaphore = new Semaphore("src/main/resources/lab4/queue/");

        List<CarStation> carStationList = new ArrayList<>(List.of(
                new CarStation(new PeopleDinner(), new GasStation()),
                new CarStation(new PeopleDinner(), new ElectricStation()),
                new CarStation(new RobotDinner(), new ElectricStation()),
                new CarStation(new RobotDinner(), new GasStation())
        ));

        carStationList.forEach(semaphore::addStation);

        timer.schedule(semaphore, TimeUnit.SECONDS.toMillis(0), TimeUnit.SECONDS.toMillis(5));
        carStationList.forEach(carStation -> timer.schedule(carStation, 1, TimeUnit.SECONDS.toMillis(5)));
    }
}
