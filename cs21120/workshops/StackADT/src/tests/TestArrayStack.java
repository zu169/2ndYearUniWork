package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import main.ArrayStack;
import main.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TestArrayStack {
    private Stack<Character> arrayStack;

    @BeforeEach
    public void setUp() {
        arrayStack = new ArrayStack<>(3);
    }

    @Test
    @DisplayName("Empty stack.")
    public void testEmptyStack () {
        assertEquals(0, arrayStack.getSize(), "The size of an empty stack should be 0.");
        assertEquals(true, arrayStack.isEmpty(),"The stack should be empty.");
    }

    @Test
    @DisplayName("Push one element.")
    public void testPushOneObject(){
        arrayStack.push('a');
        assertEquals(1, arrayStack.getSize(), "The stack size after pushing one element should be 1.");
        assertEquals(false, arrayStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push two elements.")
    public void testPushTwoObjects(){
        arrayStack.push('a');
        arrayStack.push('b');
        assertEquals(2, arrayStack.getSize(), "The stack size after pushing two elements should be 2.");
        assertEquals(false, arrayStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push three elements and peek.")
    public void testPushThreeObjectsAndPeek(){
        arrayStack.push('a');
        arrayStack.push('b');
        arrayStack.push('c');
        char element = arrayStack.peek();
        assertEquals('c', arrayStack.peek(), "Peeked element should be the last one pushed onto the stack.");
        assertEquals(3, arrayStack.getSize(), "The stack size should be 3.");
        assertEquals(false, arrayStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push three elements and pop one.")
    public void testPushThreeObjectsAndPopOne(){
        arrayStack.push('a');
        arrayStack.push('b');
        arrayStack.push('c');
        assertEquals('c', arrayStack.pop(), "Popped element should be the last one pushed onto the stack.");
        assertEquals(2, arrayStack.getSize(), "The stack size should be 2.");
        assertEquals(false, arrayStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push three elements and pop all.")
    public void testPushThreeObjectsAndPopAll(){
        arrayStack.push('a');
        arrayStack.push('b');
        arrayStack.push('c');
        assertEquals('c', arrayStack.pop(), "The first popped element should be the third one pushed.");
        assertEquals('b', arrayStack.pop(), "The second popped element should be the second one pushed.");
        assertEquals('a', arrayStack.pop(), "The third popped element should be the first one pushed.");
        assertEquals(0, arrayStack.getSize(),"The stack should now have size 0.");
        assertEquals(true, arrayStack.isEmpty(),"The stack should now be empty.");
    }

    @Test
    @DisplayName("Push three elements, pop one, push another element.")
    public void testPushThreeObjectsPopOnePushOne(){
        arrayStack.push('a');
        arrayStack.push('b');
        arrayStack.push('c');
        assertEquals('c', arrayStack.pop(), "The first popped element should be the third one pushed.");
        arrayStack.push('d');
        assertEquals('d', arrayStack.pop(), "The second popped element should be the fourth one pushed.");
        assertEquals('b', arrayStack.pop(), "The third popped element should be the second one pushed.");
        assertEquals('a', arrayStack.pop(), "The fourth popped element should be the first one pushed.");
        assertEquals(0, arrayStack.getSize(),"The queue should now have size 0.");
        assertEquals(true, arrayStack.isEmpty(),"The queue should now be empty.");
    }

    @Test
    @DisplayName("Pop from empty stack.")
    public void popFromEmptyStack(){
        assertThrows(NoSuchElementException.class, () -> arrayStack.pop(),
                "Throw an NoSuchElementException if user tries to pop from an empty stack.");
    }

    @Test
    @DisplayName("Peek from empty stack.")
    public void peekFromEmptyStack(){
        assertThrows(NoSuchElementException.class, () -> arrayStack.peek(),
                "Throw an NoSuchElementException if user tries to peak an empty stack.");
    }

    @Test
    @DisplayName("Push to full stack.")
    public void pushToFullStack(){
        arrayStack.push('a');
        arrayStack.push('b');
        arrayStack.push('c');
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> arrayStack.push('d'),
                "Throw an ArrayIndexOutOfBoundsException if capacity is reached and" +
                        "a user tries to push another element");
    }
}
