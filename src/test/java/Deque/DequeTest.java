package Deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void offerFirst() {
        Deque<String> deque = new Deque<String>();
        deque.offerFirst("Maths");
        assertEquals("Maths", deque.head.value);
        assertEquals(deque.head, deque.tail);
        deque.offerFirst("Logic");
        assertEquals("Logic", deque.head.value);
        assertEquals("Maths", deque.tail.value);
        assertEquals(deque.head, deque.tail.previous);
        deque.offerFirst("OS");
        assertEquals("OS", deque.head.value);
        assertEquals("Maths", deque.tail.value);
    }

    @Test
    void offerLast() {
        Deque<String> deque = new Deque<String>();
        deque.offerLast("Maths");
        assertEquals("Maths", deque.tail.value);
        assertEquals("Maths", deque.head.value);
        assertEquals(deque.head, deque.tail);

        deque.offerLast("Logic");
        assertEquals("Logic", deque.tail.value);
        assertEquals(deque.head, deque.tail.previous);
        assertEquals(deque.head.next, deque.tail);
        assertNull(deque.tail.next);


        deque.offerLast("OS");
        assertEquals("OS", deque.tail.value);
        assertEquals("Maths", deque.head.value);
        assertEquals(3, deque.size());
        assertNull(deque.tail.next);
        assertNull(deque.head.previous);
    }

    @Test
    void pollFirst() {
        Deque<String> deque = new Deque<String>();
        deque.offerLast("OS");
        deque.offerLast("Logic");
        deque.offerLast("Maths");
        deque.offerLast("Programming");

        assertEquals("OS", deque.head.value);
        assertEquals("Programming", deque.tail.value);

        assertEquals(4, deque.size());

        assertEquals("OS", deque.pollFirst());
        assertEquals("Logic", deque.pollFirst());
        assertEquals("Maths", deque.pollFirst());

        assertEquals(1, deque.size());
        assertEquals(deque.head, deque.tail);
        assertNull(deque.head.next);
        assertNull(deque.head.previous);
        assertNull(deque.tail.next);
        assertNull(deque.tail.previous);

        assertEquals("Programming", deque.tail.value);

        deque.offerFirst("Database");
        assertEquals("Programming", deque.tail.value);
        assertEquals("Database", deque.head.value);

        assertEquals(deque.tail, deque.head.next);
        assertEquals(deque.head, deque.tail.previous);

        assertNull(deque.tail.next);
        assertNull(deque.head.previous);

        assertEquals(2, deque.size());
    }

    @Test
    void pollLast() {
        Deque<String> deque = new Deque<String>();
        deque.offerFirst("OS");
        deque.offerFirst("Logic");
        deque.offerFirst("Maths");
        deque.offerFirst("Programming");

        assertEquals(4, deque.size());
        assertEquals("OS", deque.tail.value);
        assertEquals("Programming", deque.head.value);

        assertEquals("OS", deque.pollLast());
        assertEquals("Logic", deque.pollLast());
        assertEquals("Maths", deque.pollLast());

        assertEquals(1, deque.size());
        assertEquals("Programming", deque.tail.value);
        assertEquals("Programming", deque.head.value);

        assertNull(deque.tail.next);
        assertNull(deque.tail.previous);
        assertNull(deque.head.next);
        assertNull(deque.head.previous);

        deque.offerLast("Data Structures");
        assertEquals(2, deque.size());
    }

    @Test
    void size() {
        Deque<String> deque = new Deque<String>();

        assertEquals(0, deque.size());

        deque.offerFirst("OS");
        deque.offerFirst("Logic");
        deque.offerFirst("Maths");
        deque.offerFirst("Programming");

        assertEquals(4, deque.size());

        deque.pollFirst();
        deque.pollLast();
        deque.pollFirst();
        deque.pollLast();

        assertEquals(0, deque.size);

        deque.pollFirst();
        deque.pollLast();

        assertEquals(0, deque.size);

        deque.offerFirst("Algorithms");
        assertEquals(1, deque.size());
    }
    
}