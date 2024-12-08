package crashTest.reading;

import lab2.task2.FileReader;
import lab4.task3.Car;
import lab4.task3.FuelType;
import lab4.task3.JsonReader;
import lab4.task3.PassengersType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

public class ReadingJsonTest {


    @Test
    void readCarTest() {

        FileReader fileReader = new FileReader();

        try {
            String carOneString = fileReader.fileReaderIntoString("src/main/resources/lab4/singlecarread/Car1.json");
            JsonReader<Car> reader = new JsonReader<>(Car.class);
            Car carOneRead = reader.read(carOneString);
            Car carOneActual = new Car(1, FuelType.GAS, PassengersType.PEOPLE, false, 14); // since generator.py works as it wishes, should update this with actual info after each run
            assertEquals(carOneRead.toString(), carOneActual.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
