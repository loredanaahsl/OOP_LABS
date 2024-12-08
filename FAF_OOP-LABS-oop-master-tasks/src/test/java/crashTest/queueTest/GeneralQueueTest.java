package crashTest.queueTest;

import lab4.task1.DontReinventTheWheelQueue;
import lab4.task1.DoubtfulButOkayQueue;
import lab4.task1.NotJavaQueue;
import lab4.task1.SaneQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneralQueueTest {

    NotJavaQueue<Integer> queue;

    @BeforeEach
    void setUp() {
        queue = new DoubtfulButOkayQueue<>(10); // create here the instance of the needed queue.
    }

    @Test
    void orderTest() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    void sizeTest() {
        assertEquals(0, queue.getSize());

        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(2, queue.getSize());

        queue.dequeue();

        assertEquals(1, queue.getSize());
    }

    @Test
    void peekTest() {
        queue.enqueue(99);
        assertEquals(99, queue.peek());
        assertEquals(99, queue.peek());
    }

    @Test
    void emptyQueueTest() {
        assertThrows(Exception.class, () -> queue.dequeue());
        assertNull(queue.peek());
    }

    @Test
    void clearTest() {
        queue.enqueue(5);
        queue.enqueue(10);

        assertEquals(2, queue.getSize());

        queue.clear();

        assertEquals(0, queue.getSize());
        assertThrows(Exception.class, () -> queue.dequeue());
    }
}
