package tests;

import main.ArrayDeque;
import main.Deque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestArrayDeque {
    private Deque<Character> arrayDeque;

    @BeforeEach
    public void setUp() {
        arrayDeque = new ArrayDeque<>(3);
    }

    @Test
    @DisplayName("Empty deque.")
    public void testEmptyDeque () {
        assertEquals(0, arrayDeque.getSize(), "The size of an empty deque should be 0.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should be empty.");
    }

    @Test
    @DisplayName("Add one element and remove.")
    public void testAddOneElementAndRemove(){
        // add to front, remove from front
        arrayDeque.addFirst('a');
        assertEquals(1, arrayDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, arrayDeque.isEmpty(),"The deque should not be empty.");
        assertEquals('a', arrayDeque.getFirst(), "Peeked element is not the first in the deque.");
        assertEquals('a', arrayDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");

        // add to front, remove from back
        arrayDeque.addFirst('a');
        assertEquals(1, arrayDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, arrayDeque.isEmpty(),"The deque is should not be empty.");
        assertEquals('a', arrayDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', arrayDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");

        // add to back, remove from front
        arrayDeque.addLast('a');
        assertEquals(1, arrayDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, arrayDeque.isEmpty(),"The deque should not be empty.");
        assertEquals('a', arrayDeque.getFirst(), "Peeked element is not the first in the deque.");
        assertEquals('a', arrayDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");

        // add to back, remove from back
        arrayDeque.addLast('a');
        assertEquals(1, arrayDeque.getSize(), "The deque size after adding one element should be 1.");
        assertEquals(false, arrayDeque.isEmpty(),"The deque is should not be empty.");
        assertEquals('a', arrayDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', arrayDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");
    }

    @Test
    @DisplayName("Add two elements and remove.")
    public void testAddTwoElementsAndRemove(){
        // add last, remove last
        arrayDeque.addLast('a');
        arrayDeque.addLast('b');
        assertEquals(2, arrayDeque.getSize(), "The deque size after adding two elements should be 2.");
        assertEquals('b', arrayDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('b', arrayDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals('a', arrayDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', arrayDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");

        // add last, remove first
        arrayDeque.addLast('a');
        arrayDeque.addLast('b');
        assertEquals('a', arrayDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('a', arrayDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals('b', arrayDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('b', arrayDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");

        // add first, remove last
        arrayDeque.addFirst('a');
        arrayDeque.addFirst('b');
        assertEquals(2, arrayDeque.getSize(), "The deque size after adding two elements should be 2.");
        assertEquals('a', arrayDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('a', arrayDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals('b', arrayDeque.getLast(), "Peeked element is not the last in the deque");
        assertEquals('b', arrayDeque.removeLast(), "Removed element is not the last in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");

        // add first, remove first
        arrayDeque.addFirst('a');
        arrayDeque.addFirst('b');
        assertEquals('b', arrayDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('b', arrayDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals('a', arrayDeque.getFirst(), "Peeked element is not the first in the deque");
        assertEquals('a', arrayDeque.removeFirst(), "Removed element is not the first in the deque.");
        assertEquals(true, arrayDeque.isEmpty(),"The deque should now be empty.");
    }

    @Test
    @DisplayName("Remove/Peek element from empty deque.")
    public void removeElementFromEmptyDeque(){
        assertThrows(NoSuchElementException.class, () -> arrayDeque.getFirst(),
                "Throw an NoSuchElementException if user tries to peek first element from an empty deque.");
        assertThrows(NoSuchElementException.class, () -> arrayDeque.getLast(),
                "Throw an NoSuchElementException if user tries to peek last element from an empty deque.");
        assertThrows(NoSuchElementException.class, () -> arrayDeque.removeFirst(),
                "Throw an NoSuchElementException if user tries to remove first element from an empty deque.");
        assertThrows(NoSuchElementException.class, () -> arrayDeque.removeLast(),
                "Throw an NoSuchElementException if user tries to remove last element from an empty deque.");
    }

    @Test
    @DisplayName("Add element to full deque without wrapping.")
    public void addElementToFullDeque(){
        arrayDeque.addLast('a');
        arrayDeque.addLast('b');
        arrayDeque.addLast('c');
        assertEquals(3, arrayDeque.getSize(), "The deque size after adding three elements should be 3.");
        assertThrows(IllegalStateException.class, () -> arrayDeque.addFirst('d'),
                "Throw an IllegalStateException if capacity is reached and" +
                        "a user tries to add another element to front.");
        assertThrows(IllegalStateException.class, () -> arrayDeque.addLast('d'),
                "Throw an IllegalStateException if capacity is reached and" +
                        "a user tries to add another element to back.");
    }

    @Test
    @DisplayName("Add element to full deque after wrapping right.")
    public void addElementToFullDequeAfterWrappingRight(){
        arrayDeque.addLast('a');
        arrayDeque.addLast('b');
        arrayDeque.addLast('c');
        arrayDeque.removeFirst();
        arrayDeque.addLast('d');
        assertEquals(3, arrayDeque.getSize(), "The deque size after adding 4 elements and removing 1 should be 3.");

        assertThrows(IllegalStateException.class, () -> arrayDeque.addFirst('e'),
                "Throw an IllegalStateException if capacity is reached and" +
                        "a user tries to add another element to front.");
        assertThrows(IllegalStateException.class, () -> arrayDeque.addLast('e'),
                "Throw an IllegalStateException if capacity is reached and" +
                        "a user tries to add another element to back.");
    }

    @Test
    @DisplayName("Add element to full deque after wrapping left.")
    public void addElementToFullDequeAfterWrappingLeft(){
        arrayDeque.addLast('a');
        arrayDeque.addLast('b');
        arrayDeque.addLast('c');
        arrayDeque.removeLast();
        arrayDeque.addFirst('d');

        assertEquals(3, arrayDeque.getSize(), "The deque size after adding 4 elements and removing 1 should be 3.");
        assertThrows(IllegalStateException.class, () -> arrayDeque.addFirst('e'),
                "Throw an IllegalStateException if capacity is reached and" +
                        "a user tries to add another element to front.");
        assertThrows(IllegalStateException.class, () -> arrayDeque.addLast('e'),
                "Throw an IllegalStateException if capacity is reached and" +
                        "a user tries to add another element to back.");
    }

    @Test
    @DisplayName("Add elements wrapping right.")
    public void addElementWrappingRight(){
        arrayDeque.addLast('a');
        arrayDeque.addLast('b');
        arrayDeque.addLast('c');
        arrayDeque.removeFirst();
        arrayDeque.addLast('d');

        assertEquals(3, arrayDeque.getSize(), "The deque size after adding 4 elements and removing 1 should be 3.");

        assertEquals('b', arrayDeque.getFirst(), "The head is pointing to the wrong element after wrapping right.");
        assertEquals('d', arrayDeque.getLast(), "The tail is pointing to the wrong element after wrapping right.");

        assertEquals('b', arrayDeque.removeFirst(), "The head is pointing to the wrong element after wrapping right.");
        assertEquals('d', arrayDeque.removeLast(), "The tail is pointing to the wrong element after wrapping right.");
    }

    @Test
    @DisplayName("Add elements wrapping left.")
    public void addElementWrappingLeft(){
        arrayDeque.addLast('a');
        arrayDeque.addLast('b');
        arrayDeque.addLast('c');
        arrayDeque.removeLast();
        arrayDeque.addFirst('d');

        assertEquals(3, arrayDeque.getSize(), "The deque size after adding 4 elements and removing 1 should be 3.");

        assertEquals('d', arrayDeque.getFirst(), "The head is pointing to the wrong element after wrapping left.");
        assertEquals('b', arrayDeque.getLast(), "The tail is pointing to the wrong element after wrapping left.");

        assertEquals('d', arrayDeque.removeFirst(), "The head is pointing to the wrong element after wrapping left.");
        assertEquals('b', arrayDeque.removeLast(), "The tail is pointing to the wrong element after wrapping left.");
    }
}
