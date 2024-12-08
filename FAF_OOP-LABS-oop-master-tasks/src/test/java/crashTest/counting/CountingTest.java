package crashTest.counting;

import lab4.task2.ElectricStation;
import lab4.task2.PeopleDinner;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class CountingTest {


    @Test
    void countDinnersForPeoplesTest() {
        PeopleDinner peopleDInner = new PeopleDinner();
        peopleDInner.serveDinner(1);
        peopleDInner.serveDinner(2);
        peopleDInner.serveDinner(3);
        peopleDInner.serveDinner(1);

        assertEquals(4, peopleDInner.getDinnerServed());

    }

    @Test
    void countElectricRefuel() {
        ElectricStation electricStation = new ElectricStation();
        electricStation.refuel(1);
        electricStation.refuel(1);
        electricStation.refuel(1);
        electricStation.refuel(1);
        electricStation.refuel(1);

        assertEquals(5, electricStation.getRefuelCount());

    }

}
