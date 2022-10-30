package tests;

import main.List;
import main.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestList {
    private List list;

    @BeforeEach
    public void setUp() {
        list = new SinglyLinkedList();
    }

    @Test
    @DisplayName("Remove from empty list.")
    public void testRemoveFromEmptyList () {
        assertThrows(NoSuchElementException.class, () -> list.removeFirst(),
                "Throw an NoSuchElementException if user tries to remove the first element from an empty list.");
        assertThrows(NoSuchElementException.class, () -> list.removeLast(),
                "Throw an NoSuchElementException if user tries to remove the last element from an empty list.");
        assertThrows(NoSuchElementException.class, () -> list.getFirst(),
                "Throw an NoSuchElementException if user tries to retrieve the first element from an empty list.");
        assertThrows(NoSuchElementException.class, () -> list.getLast(),
                "Throw an NoSuchElementException if user tries to retrieve the last element from an empty list.");
    }

    @Test
    @DisplayName("Add one element.")
    public void testAddOne() {
        list.addFirst("1");
        assertEquals("1", list.getFirst(), "Head should reference inserted element.");
        assertEquals("1", list.getLast(), "Tail should reference inserted element.");
    }

    @Test
    @DisplayName("Add two elements at front.")
    public void testAddTwoHead () {
        list.addFirst("1");
        list.addFirst("2");
        assertEquals("2", list.getFirst(), "First element in list incorrect.");
        assertEquals("1", list.getLast(), "Last element in list incorrect.");
    }

    @Test
    @DisplayName("Add two elements at tail.")
    public void testAddTwoTail () {
        list.addLast("1");
        list.addLast("2");
        assertEquals("1", list.getFirst(), "First element in list incorrect.");
        assertEquals("2", list.getLast(), "Last element in list incorrect.");
    }

    @Test
    @DisplayName("Add three elements at front.")
    public void testAddThreeHead () {
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        assertEquals("3->2->1", list.toString(),
                "toString method incorrect or something wrong in addFirst (next references do not connect the nodes correctly).");
        assertEquals("3", list.getFirst(), "First element in list incorrect.");
        assertEquals("1", list.getLast(), "Last element in list incorrect.");
    }

    @Test
    @DisplayName("Add three elements at tail.")
    public void testAddThreeTail () {
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");
        assertEquals("1->2->3", list.toString(),
                "toString method incorrect or something wrong in addLast (next references do not connect the nodes correctly).");
        assertEquals("1", list.getFirst(), "First element in list incorrect.");
        assertEquals("3", list.getLast(), "Last element in list incorrect.");
    }

    @Test
    @DisplayName("Add three elements and remove from front.")
    public void testAddThreeRemoveFromFront () {
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        assertEquals("3", list.removeFirst(), "First element in list incorrect.");
        assertEquals("2->1", list.toString(),
                "toString method incorrect or something wrong in removeFirst (next references do not connect the nodes correctly).");
        assertEquals("2", list.removeFirst(), "Second element in list incorrect.");
        assertEquals("1", list.removeFirst(), "Third element in list incorrect.");
        assertThrows(NoSuchElementException.class, () -> list.removeFirst(),
                "List should be empty.");
    }

    @Test
    @DisplayName("Add three elements and remove from back.")
    public void testAddThreeRemoveFromBack() {
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        assertEquals("1", list.removeLast(), "Third element in list incorrect.");
        assertEquals("3->2", list.toString(),
                "toString method incorrect or something wrong in removeLast (next references do not connect the nodes correctly).");
        assertEquals("2", list.removeLast(), "Second element in list incorrect.");
        assertEquals("3", list.removeLast(), "First element in list incorrect.");
        assertThrows(NoSuchElementException.class, () -> list.removeLast(),
                "List should be empty.");
    }
}
