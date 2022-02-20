package Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class QueueTest {

    @Test
    void enqueue() {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Java");
        queue.enqueue("Calculus");
        queue.enqueue("Algorithms");
        queue.enqueue("Discrete Maths");
        assertEquals("Java", queue.peek());
        queue.dequeue();
        assertEquals("Calculus", queue.dequeue());
    }

    @Test
    void dequeue() {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Java");
        queue.dequeue();
        assertNull(queue.dequeue());
        queue.enqueue("Calculus");
        queue.enqueue("Algorithms");
        assertEquals("Calculus", queue.peek());
        assertEquals("Calculus", queue.dequeue());
        assertEquals("Algorithms", queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void peek() {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Java");
        assertEquals("Java", queue.peek());
        queue.enqueue("Calculus");
        assertEquals("Java", queue.peek());
        queue.enqueue("Algorithms");
        assertEquals("Java", queue.peek());
        queue.enqueue("Discrete Maths");
        assertEquals("Java", queue.peek());
    }

    @Test
    void size() {
        Queue<String> queue = new Queue<String>();
        assertEquals(0, queue.size);
        queue.enqueue("Java");
        assertEquals(1, queue.size());
        queue.enqueue("Calculus");
        assertEquals(2, queue.size());
        queue.enqueue("Algorithms");
        assertEquals(3, queue.size());
        queue.enqueue("Discrete Maths");
        assertEquals(4, queue.size());
    }

}