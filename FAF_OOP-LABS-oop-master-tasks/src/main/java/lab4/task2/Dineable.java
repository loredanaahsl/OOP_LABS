package lab4.task2;

import lab4.task3.Car;

public interface Dineable {
    void serveDinner(int cardId);

    int getDinnerServed();

    boolean matches(Car car);

}
