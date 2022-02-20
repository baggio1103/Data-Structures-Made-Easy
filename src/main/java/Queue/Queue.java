package Queue;

public class Queue<T> {
    public Item<T> head;
    public Item<T> tail;
    public int size;

    public Queue() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void enqueue(T value) {
        Item<T> item = new Item<>(value);
        if (head == null) {
            tail = head = item;
        } else {
            tail.next = item;
            tail = item;
        }
        size++;
    }

    public T dequeue() {
        if (size > 0) {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }
        return null;
    }

    public T peek() {
        return head != null ? head.value : null;
    }

    public int size() {
        return size;
    }

}


class Item<T> {
    public Item<T> next;
    public T value;

    public Item(T value) {
        this.value = value;
        this.next = null;
    }

}