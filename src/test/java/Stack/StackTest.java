package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push() {
        Stack<String> stack = new Stack<String>();
        stack.push("Java");
        stack.push("Data Structures");
        stack.push("Algorithms");
        assertEquals(3, stack.size());
        assertEquals("Algorithms", stack.peek());
    }

    @Test
    void pop() {
        Stack<String> stack = new Stack<String>();
        stack.push("Java");
        stack.push("Data Structures");
        stack.push("Algorithms");
        assertEquals(3, stack.size());
        assertEquals("Algorithms", stack.pop());
        assertEquals(2, stack.size());
        assertEquals("Data Structures", stack.pop());
        assertEquals(1, stack.size());
        assertEquals("Java", stack.pop());
        assertNull(stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peek() {
        Stack<String> stack = new Stack<String>();
        stack.peek();
        stack.push("Java");
        stack.push("Maths");
        assertEquals("Maths", stack.peek());
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals("Java", stack.peek());
    }

}