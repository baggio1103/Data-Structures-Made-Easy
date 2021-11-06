package LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @org.junit.jupiter.api.Test
    void add() {
        LinkedList list = new LinkedList();
        assertNull(list.tail);
        assertNull(list.head);
        list.add(new Node(1));
        assertEquals(list.tail, list.head);

        list.add(new Node(2));
        assertEquals(2, list.tail.value);
        list.add(new Node(7));
        assertEquals(7, list.tail.value);
        list.add(new Node(5));
        assertEquals(5, list.tail.value);
        assertNull(list.tail.next);
    }

    @org.junit.jupiter.api.Test
    void find() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(6));
        list.add(new Node(8));
        list.add(new Node(11));
        list.add(new Node(2));
        assertNotNull(list.find(11));
        assertNotNull(list.find(8));
        assertNull(list.find(22));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        LinkedList list = new LinkedList();
        assertNull(list.tail);
        assertNull(list.head);
        assertFalse(list.remove(3));

        list.add(new Node(22));
        list.remove(22);
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.size());
        list.clear();

        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(7));
        list.add(new Node(5));

        assertTrue(list.remove(1));
        assertEquals(2, list.head.value);

        assertTrue(list.remove(5));
        assertEquals(7, list.tail.value);
        assertNull(list.tail.next);

        list.add(new Node(8));
        assertEquals(8, list.tail.value);

        assertFalse(list.remove(10));
        assertEquals(2, list.head.value);

        assertTrue(list.remove(7));
        assertEquals(list.head.next, list.tail);
        assertEquals(2, list.size());
    }

    @org.junit.jupiter.api.Test
    void removeAll() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(7));
        list.add(new Node(2));
        list.removeAll(1);
        list.removeAll(2);
        assertEquals(list.tail, list.head);
        assertEquals(7, list.head.value);
        list.removeAll(7);
        list.printList();
    }

    @org.junit.jupiter.api.Test
    void clear() {
        LinkedList list = new LinkedList();
        list.add(new Node(1));
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(1));
        list.add(new Node(2));
        list.add(new Node(7));
        list.add(new Node(9));
        assertEquals(7, list.size());
        list.clear();
        assertEquals(0, list.size());
    }

}