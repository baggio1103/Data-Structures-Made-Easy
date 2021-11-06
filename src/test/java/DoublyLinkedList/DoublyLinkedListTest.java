package DoublyLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    @Test
    void add() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(new Node(3));
        assertEquals(list.tail, list.head);
        assertNull(list.tail.next);
        assertNull(list.head.previous);

        list.add(new Node(11));
        assertEquals(11, list.tail.value);
        assertEquals(list.head, list.tail.previous);

        list.add(new Node(7));
        assertEquals(7, list.tail.value);
        assertEquals(11, list.tail.previous.value);
    }

    @Test
    void find() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertNull(list.find(22));
        list.add(new Node(7));
        list.add(new Node(3));
        list.add(new Node(22));
        list.add(new Node(11));
        assertNotNull(list.find(22));
        assertNotNull(list.find(11));
        assertEquals(11, list.tail.value);
        assertEquals(7, list.head.value);
        assertEquals(4, list.size());
    }

    @Test
    void remove() {
        DoublyLinkedList list = new DoublyLinkedList();
        assertFalse(list.remove(99));
        list.add(new Node(11));
        list.add(new Node(4));

        assertTrue(list.remove(4));
        assertEquals(list.head, list.tail);
        assertNull(list.head.previous);
        assertNull(list.tail.next);

        assertTrue(list.remove(11));
        assertNull(list.tail);
        assertNull(list.head);

        list.add(new Node(11));
        list.add(new Node(22));
        list.add(new Node(55));
        list.add(new Node(33));

        assertTrue(list.remove(22));
        assertEquals(11, list.head.value);
        Node node = list.head.next;
        assertEquals(node, list.tail.previous);
        assertEquals(55, node.value);
        assertEquals(list.head, node.previous);
        assertEquals(list.tail, node.next);

        assertFalse(list.remove(99));

        assertTrue(list.remove(11));
        assertEquals(55, list.head.value);
        assertNull(list.head.previous);
        assertEquals(2, list.size());

    }

    @Test
    void removeAll(){
        DoublyLinkedList list = new DoublyLinkedList();
        list.removeAll(99);
        list.add(new Node(11));
        list.add(new Node(7));
        list.add(new Node(7));
        list.add(new Node(7));
        list.add(new Node(7));
        list.removeAll(7);
        assertEquals(list.head, list.tail);
        assertEquals(11, list.head.value);
        list.clear();

        list.add(new Node(7));
        list.add(new Node(7));
        list.add(new Node(1));
        list.removeAll(7);
        assertEquals(list.head, list.tail);
        assertEquals(1, list.head.value);
        list.clear();

        list.add(new Node(11));
        list.add(new Node(22));
        list.add(new Node(22));
        list.add(new Node(8));
        list.removeAll(22);
        assertEquals(list.head.next, list.tail);
        assertEquals(list.head, list.tail.previous);
        assertEquals(2, list.size());
        list.clear();

        list.add(new Node(7));
        list.add(new Node(7));
        list.add(new Node(7));
        list.removeAll(7);
        assertNull(list.head);
        assertNull(list.tail);
        assertEquals(0, list.size());
    }

    @Test
    void insertAfter() {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(new Node(11));
        Node node = list.find(11);
        list.insertAfter(node, new Node(22));
        assertEquals(11, list.head.value);
        assertEquals(22, list.tail.value);
        assertNull(list.tail.next);
        assertEquals(2, list.size());
        list.clear();

        list.insertAfter(null, new Node(11));
        assertEquals(list.head, list.tail);
        assertEquals(11, list.head.value);
        list.clear();

        list.add(new Node(11));
        list.add(new Node(22));
        assertEquals(11, list.head.value);
        assertEquals(22, list.tail.value);
        node = list.find(11);
        list.insertAfter(node, new Node(4));
        Node newNode = list.find(4);
        Node head = list.head;
        Node tail = list.tail;
        assertEquals(3, list.size());
        assertEquals(head.next, newNode);
        assertEquals(tail.previous, newNode);
        list.clear();

        list.add(new Node(11));
        list.add(new Node(22));
        list.add(new Node(4));
        node = list.find(4);
        list.insertAfter(node, new Node(26));
        tail = list.find(26);
        assertEquals(26, tail.value);
        assertNull(tail.next);
        assertEquals(4, list.size());
    }

}