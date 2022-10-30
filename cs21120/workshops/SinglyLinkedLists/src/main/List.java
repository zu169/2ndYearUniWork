package main;

import java.util.NoSuchElementException;

/**
 * A list interface.
 * @author Christine Zarges
 * @version 1.0, 30 September 2019
 */
public interface List {
    /**
     * Adds a new element to the front of the list.
     *
     * @param element the element to be added
     */
    void addFirst(String element);

    /**
     * Adds a new element to the back of the list.
     *
     * @param element the element to be added
     */
    void addLast(String element);

    /**
     * Removes the element at the front of the list.
     *
     * @return the element at the front of the list
     * @throws NoSuchElementException if list is empty
     */
    String removeFirst() throws NoSuchElementException;

    /**
     * Removes the element at the back of the list.
     *
     * @return the element at the back of the list
     * @throws NoSuchElementException if list is empty
     */
    String removeLast() throws NoSuchElementException;

    /**
     * Get the element at the head of the list.
     *
     * @return the first element in the list
     * @throws NoSuchElementException if list is empty
     */
    String getFirst() throws NoSuchElementException;

    /**
     * Get the element at the tail of the list.
     *
     * @return the last element in the list
     * @throws NoSuchElementException if list is empty
     */
    String getLast() throws NoSuchElementException;

    /**
     * Creates a string that prints the list: all elements separated by '->', e.g., a->b->c
     *
     * @return the string representing the list
     */
    String toString();
}
