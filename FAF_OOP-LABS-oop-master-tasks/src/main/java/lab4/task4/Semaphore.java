package lab4.task4;

import lab4.task3.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Semaphore extends TimerTask {
    private final List<CarStation> carStationList;
    private String highWaySrc; // directory of the queue folder;

    public void removeStation(CarStation carStation) {
        carStationList.remove(carStation);
    }

    public Semaphore(String highWaySrc) {
        carStationList = new ArrayList<>();
        this.highWaySrc = highWaySrc;
    }

    public Semaphore(List<CarStation> carStationList, String highWaySrc) {
        this.carStationList = carStationList;
        this.highWaySrc = highWaySrc;
    }

    public void removeStation(int i) {
        carStationList.remove(i);
    }

    public void addStation(CarStation carStation) {
        carStationList.add(carStation);
    }

    public void setHighWaySrc(String highWaySrc) {
        this.highWaySrc = highWaySrc;
    }

    public String getHighWaySrc() {
        return highWaySrc;
    }

    private CarStation guide(Car car) {

        List<CarStation> possibleStations = new ArrayList<>();

        for (CarStation carStation : carStationList) {
            if (carStation.refuelableMatches(car)) {
                if (!car.isDining() || carStation.dineableMatches(car)) {
                    possibleStations.add(carStation);
                }
            }
        }

        return possibleStations.stream().min(Comparator.comparingLong(CarStation::getQueueLength)).orElse(null);
    }

    public void distributeHighwayCarsToQueues(boolean deleteAfter) {
        List<Car> cars = scanCars(deleteAfter);
        cars.forEach(c -> {
            CarStation carStation = guide(c);
            if (carStation == null) {
                throw new RuntimeException("No Car station found for the car " + c.toString());
            }
            carStation.addCar(c);
        });
    }

    public List<Car> scanCars(boolean deleteAfterRead) {
        Path path = Paths.get(highWaySrc);
        File[] files = path.toFile().listFiles();

        JsonReader<Car> jsonCarReader = new JsonReader<>(Car.class);

        if (files == null) {
            return Collections.emptyList();
        }

        return Arrays.stream(files)
                .map(file -> {
                    try {
                        String carJsonString = Files.readString(file.toPath());
                        if (deleteAfterRead) {
                            Files.delete(file.toPath());
                        }
                        return jsonCarReader.read(carJsonString);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to read or delete file: " + file.getAbsolutePath(), e);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to parse JSON for file: " + file.getAbsolutePath(), e);
                    }
                })
                .collect(Collectors.toList());
    }

    public List<CarStation> getCarStationList() {
        return carStationList;
    }

    @Override
    public void run() {
        distributeHighwayCarsToQueues(true);
    }
}
