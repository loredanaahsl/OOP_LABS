package lab4.task3;

import lab4.task1.NotJavaQueue;
import lab4.task1.SaneQueue;
import lab4.task2.Dineable;
import lab4.task2.Refuelable;

import java.util.TimerTask;

public class CarStation extends TimerTask {

    private static int carStationCount = 0;
    private final int carStationId;

    private final Dineable dineableService;
    private final Refuelable refuelableService;

    private final NotJavaQueue<Car> queue;

    /**
     * Default NotJavaQueue implementation is SaneQueue
     */
    public CarStation(Dineable dineableService, Refuelable refuelableService) {
        this.dineableService = dineableService;
        carStationId = carStationCount++;
        this.refuelableService = refuelableService;
        queue = new SaneQueue<>();
    }

    public CarStation(Dineable dineableService, Refuelable refuelableService, NotJavaQueue<Car> queue) {
        this.dineableService = dineableService;
        carStationId = carStationCount++;
        this.refuelableService = refuelableService;
        this.queue = queue;
    }

    public int getDineableServiceClientCount() {
        return dineableService.getDinnerServed();
    }

    public int getRefuelableServiceClientCount() {
        return refuelableService.getRefuelCount();
    }

    public void serveCars() {

        synchronized (queue) {
            while (queue.peek() != null) {
                Car carToServe = queue.dequeue();
                refuelableService.refuel(carToServe.getId());
                if (carToServe.isDining()) dineableService.serveDinner(carToServe.getId());
            }
        }

    }
    public void addCar(Car car) {
        synchronized (queue) {
            queue.enqueue(car);
        }
    }

    public Class<?> getDinnerServiceType() {
        return dineableService.getClass();
    }

    public Class<?> getRefuelServiceType() {
        return refuelableService.getClass();
    }

    public int getCarStationId() {
        return this.carStationId;
    }

    public boolean dineableMatches(Car car) {
        return dineableService.matches(car);
    }

    public boolean refuelableMatches(Car car) {
        return refuelableService.matches(car);
    }


    public long getQueueLength() {
        synchronized (queue) {
            return queue.getSize();
        }
    }

    @Override
    public void run() {
        serveCars();
    }
}
