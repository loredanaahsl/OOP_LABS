package lab4.task1;

public interface NotJavaQueue<T> {
    void enqueue(T t);
    T dequeue();
    long getSize();

    void clear();

    T peek();

}
