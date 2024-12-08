package lab4.task1;

import java.util.LinkedList;
import java.util.Queue;

public class DontReinventTheWheelQueue<T> implements NotJavaQueue<T> {

    private final Queue<T> hiddenQueue;

    public DontReinventTheWheelQueue() {
        hiddenQueue = new LinkedList<>();
    }

    @Override
    public void enqueue(T o) {
        hiddenQueue.add(o);
    }

    @Override
    public T dequeue() {
        return hiddenQueue.remove();
    }

    @Override
    public long getSize() {
        return hiddenQueue.size();
    }

    @Override
    public void clear() {
        hiddenQueue.clear();
    }

    @Override
    public T peek() {
        return hiddenQueue.peek();
    }
}
