package tests;

import main.Deque;
import main.ListDeque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestListDeque {
    private Deque<Character> listDeque;

    @BeforeEach
    public void setUp() {
        listDeque = new ListDeque<>();
    }

    @Test
    @DisplayName("Empty deque.")
    public void testEmptyDeque () {
        assertEquals(0, listDeque.getSize(), "The size of an empty deque should be 0.");
        assertEquals(true, listDeque.isEmpty(),"The deque should be empty.");
    }

    @Test
    @DisplayName("Add one element and remove.")
    public void testAddOneElementAndRemove(){
        // add to front, remove from front
        listDeque.addFirst('a');
        assertEquals(1, listDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, listDeque.isEmpty(),"The deque should not be empty.");
        assertEquals('a', listDeque.getFirst(), "Peeked element is not the first in the deque.");
        assertEquals('a', listDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");

        // add to front, remove from back
        listDeque.addFirst('a');
        assertEquals(1, listDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, listDeque.isEmpty(),"The deque is should not be empty.");
        assertEquals('a', listDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', listDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");

        // add to back, remove from front
        listDeque.addLast('a');
        assertEquals(1, listDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, listDeque.isEmpty(),"The deque should not be empty.");
        assertEquals('a', listDeque.getFirst(), "Peeked element is not the first in the deque.");
        assertEquals('a', listDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");

        // add to back, remove from back
        listDeque.addLast('a');
        assertEquals(1, listDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, listDeque.isEmpty(),"The deque is should not be empty.");
        assertEquals('a', listDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', listDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");
    }

    @Test
    @DisplayName("Add two elements and remove.")
    public void testAddTwoElementsAndRemove(){
        // add last, remove last
        listDeque.addLast('a');
        listDeque.addLast('b');
        assertEquals(2, listDeque.getSize(), "The deque size after adding two elements should be 2.");
        assertEquals('b', listDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('b', listDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals('a', listDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', listDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");

        // add last, remove first
        listDeque.addLast('a');
        listDeque.addLast('b');
        assertEquals('a', listDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('a', listDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals('b', listDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('b', listDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");

        // add first, remove last
        listDeque.addFirst('a');
        listDeque.addFirst('b');
        assertEquals(2, listDeque.getSize(), "The deque size after adding two elements should be 2.");
        assertEquals('a', listDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', listDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals('b', listDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('b', listDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");

        // add first, remove first
        listDeque.addFirst('a');
        listDeque.addFirst('b');
        assertEquals('b', listDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('b', listDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals('a', listDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('a', listDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, listDeque.isEmpty(),"The deque should now be empty.");
    }

    @Test
    @DisplayName("Remove/Peek element from empty deque.")
    public void removeElementFromEmptyDeque(){
        assertThrows(NoSuchElementException.class, () -> listDeque.removeFirst(),
                "Throw an NoSuchElementException if user tries to remove first element from an empty deque.");
        assertThrows(NoSuchElementException.class, () -> listDeque.removeLast(),
                "Throw an NoSuchElementException if user tries to remove last element from an empty deque.");
        assertThrows(NoSuchElementException.class, () -> listDeque.getFirst(),
                "Throw an NoSuchElementException if user tries to peek first element from an empty deque.");
        assertThrows(NoSuchElementException.class, () -> listDeque.getLast(),
                "Throw an NoSuchElementException if user tries to peek last element from an empty deque.");
    }
}
