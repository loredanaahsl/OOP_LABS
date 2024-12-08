package lab4.task3;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private int id;
    private FuelType type;
    private PassengersType passengers;

    @JsonProperty("isDining") // others have no problems so no marked
    private boolean isDining;
    private int consumption;

    public Car(int id, FuelType type, PassengersType passengersType, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengersType;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    private Car() {} // i forbid you to use non-args constructor


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FuelType getType() {
        return type;
    }

    public void setType(FuelType type) {
        this.type = type;
    }

    public PassengersType getPassengers() {
        return passengers;
    }

    public void setPassengers(PassengersType passengersType) {
        this.passengers = passengersType;
    }

    public boolean isDining() {
        return isDining;
    }

    public void setDining(boolean dining) {
        isDining = dining;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public String toString() {
        return String.format("Car #%d; type: %s; passenger type: %s; consumption: %d, isDining: %b", id, type.name(), passengers, consumption, isDining);
    }
}
