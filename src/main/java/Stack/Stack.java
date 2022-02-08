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
            if (head != null) {
                head.prev = null;
            }
            size--;
            return value;
        }
        return null;
    }

    public void push(T item) {
        if (head == null) {
            head = new Item<>(item);
        } else {
            Item<T> temp = head;
            head = new Item<>(item);
            head.next = temp;
            temp.prev = head;
        }
        size++;
    }

    public T peek() {
        return head != null ? head.value : null;
    }

}

class Item<T> {
    public Item<T> next;
    public Item<T> prev;
    public T value;

    public Item(T value) {
        this.value = value;
        this.next = this.prev = null;
    }

}