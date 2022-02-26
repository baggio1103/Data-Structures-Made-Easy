package Deque;

public class Deque<T> {
    public Item<T> head;
    public Item<T> tail;
    public int size;

    public Deque() {
        this.size = 0;
        this.head = this.tail = null;
    }

    public void offerFirst(T item) {
        if (size == 0) {
            head = tail = new Item<>(item);
        } else {
            Item<T> temp = head;
            head = new Item<>(item);
            head.next = temp;
            temp.previous = head;
        }
        size++;
    }

    public void offerLast(T item) {
        if (size == 0) {
            head = tail = new Item<>(item);
        } else {
            Item<T> temp = tail;
            tail = new Item<>(item);
            tail.previous = temp;
            temp.next = tail;
        }
        size++;
    }

    public T pollFirst() {
        if (size > 0) {
            T value = head.value;
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
            size--;
            return value;
        }
        return null;
    }

    public T pollLast() {
        if (size > 0) {
            T value = tail.value;
            tail = tail.previous;
            if (tail != null) {
                tail.next = null;
            }
            size--;
            return value;
        }
        return null;
    }

    public int size() {
        return size;
    }

}

class Item<T> {
    public Item<T> next;
    public Item<T> previous;
    public T value;

    public Item(T value) {
        this.value = value;
        this.previous = this.next = null;
    }

}