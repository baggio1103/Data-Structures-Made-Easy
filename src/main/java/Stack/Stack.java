package Stack;

public class Stack<T> {
    public int size;
    public Item<T> head;

    public Stack() {
        this.size = 0;
        this.head = null;
    }

    public int size() {
        return size;
    }

    public T pop() {
        if (size > 0) {
            T value = head.value;
            head = head.next;
            size--;
            return value;
        }
        return null;
    }

    public void push(T value) {
        if (head == null) {
            head = new Item<>(value);
        } else {
            Item<T> temp = head;
            head = new Item<>(value);
            head.next = temp;
        }
        size++;
    }

    public T peek() {
        return head != null ? head.value : null;
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