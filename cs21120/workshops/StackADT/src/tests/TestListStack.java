package tests;

import main.ListStack;
import main.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestListStack {
    private Stack<Character> listStack;

    @BeforeEach
    public void setUp() {
        listStack = new ListStack<>();
    }

    @Test
    @DisplayName("Empty stack.")
    public void testEmptyStack () {
        assertEquals(0, listStack.getSize(), "The size of an empty stack should be 0.");
        assertEquals(true, listStack.isEmpty(),"The stack should be empty.");
    }

    @Test
    @DisplayName("Push one element.")
    public void testPushOneObject(){
        listStack.push('a');
        assertEquals(1, listStack.getSize(), "The stack size after pushing one element should be 1.");
        assertEquals(false, listStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push two elements.")
    public void testPushTwoObjects(){
        listStack.push('a');
        listStack.push('b');
        assertEquals(2, listStack.getSize(), "The stack size after pushing two elements should be 2.");
        assertEquals(false, listStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push three elements and peek.")
    public void testPushThreeObjectsAndPeek(){
        listStack.push('a');
        listStack.push('b');
        listStack.push('c');
        char element = listStack.peek();
        assertEquals('c', listStack.peek(), "Peeked element should be the last one pushed onto the stack.");
        assertEquals(3, listStack.getSize(), "The stack size should be 3.");
        assertEquals(false, listStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push three elements and pop one.")
    public void testPushThreeObjectsAndPopOne(){
        listStack.push('a');
        listStack.push('b');
        listStack.push('c');
        assertEquals('c', listStack.pop(), "Popped element should be the last one pushed onto the stack.");
        assertEquals(2, listStack.getSize(), "The stack size should be 2.");
        assertEquals(false, listStack.isEmpty(),"The stack is not empty.");
    }

    @Test
    @DisplayName("Push three elements and pop all.")
    public void testPushThreeObjectsAndPopAll(){
        listStack.push('a');
        listStack.push('b');
        listStack.push('c');
        assertEquals('c', listStack.pop(), "The first popped element should be the third one pushed.");
        assertEquals('b', listStack.pop(), "The second popped element should be the second one pushed.");
        assertEquals('a', listStack.pop(), "The third popped element should be the first one pushed.");
        assertEquals(0, listStack.getSize(),"The stack should now have size 0.");
        assertEquals(true, listStack.isEmpty(),"The stack should now be empty.");
    }

    @Test
    @DisplayName("Push three elements, pop one, push another element.")
    public void testPushThreeObjectsPopOnePushOne(){
        listStack.push('a');
        listStack.push('b');
        listStack.push('c');
        assertEquals('c', listStack.pop(), "The first popped element should be the third one pushed.");
        listStack.push('d');
        assertEquals('d', listStack.pop(), "The second popped element should be the fourth one pushed.");
        assertEquals('b', listStack.pop(), "The third popped element should be the second one pushed.");
        assertEquals('a', listStack.pop(), "The fourth popped element should be the first one pushed.");
        assertEquals(0, listStack.getSize(),"The queue should now have size 0.");
        assertEquals(true, listStack.isEmpty(),"The queue should now be empty.");
    }

    @Test
    @DisplayName("Pop from empty stack.")
    public void popFromEmptyStack(){
        assertThrows(NoSuchElementException.class, () -> listStack.pop(),
                "Throw an NoSuchElementException if user tries to pop from an empty stack.");
    }

    @Test
    @DisplayName("Peek from empty stack.")
    public void peekFromEmptyStack(){
        assertThrows(NoSuchElementException.class, () -> listStack.peek(),
                "Throw an NoSuchElementException if user tries to peak an empty stack.");
    }

}
