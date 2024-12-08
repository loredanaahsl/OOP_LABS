package lab4.task1;

import java.util.NoSuchElementException;

public class DoubtfulButOkayQueue<T> implements NotJavaQueue<T> {

    private final T[] data;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    @SuppressWarnings("unchecked")
    public DoubtfulButOkayQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    @Override
    public void enqueue(T t) {
        if (size == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        data[rear] = t;
        rear = (rear + 1) % capacity;
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        T removedElement = data[front];
        data[front] = null; // Help garbage collection
        front = (front + 1) % capacity; // Move front pointer
        size--;
        return removedElement;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[(front + i) % capacity] = null;
        }
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public T peek() {
        if (size == 0) {
            return null;
        }
        return data[front];
    }
}
