package lab4.task1;

import java.util.NoSuchElementException;

public class SaneQueue<T> implements NotJavaQueue<T> {

    private int size;
    private Node<T> rear; // Points to the rear (end) of the queue
    private Node<T> front; // Points to the front (start) of the queue

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    public SaneQueue() {
        this.size = 0;
        this.rear = null;
        this.front = null;
    }

    @Override
    public void enqueue(T t) {
        Node<T> newNode = new Node<>(t);

        if (rear == null) { // Queue is empty
            front = rear = newNode;
        } else {
            rear.next = newNode; // Add the new node at the end
            rear = newNode; // Update the rear pointer
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (front == null) { // Queue is empty
            throw new NoSuchElementException("Queue is empty");
        }

        T value = front.value;
        front = front.next; // Move the front pointer to the next node

        if (front == null) { // If the queue becomes empty
            rear = null;
        }

        size--;
        return value;
    }

    @Override
    public long getSize() {
        return size;
    }

    @Override
    public void clear() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public T peek() {
        if (front == null) {
            return null;
        }
        return front.value;
    }
}
