package main;

import java.util.NoSuchElementException;

/**
 * A Deque interface.
 * @author Christine Zarges
 * @version 1.0, 23 September 2019
 */
public interface Deque<E> {
    /**
     * Adds an element to the front of this deque.
     *
     * @param element the element to be added
     */
    public void addFirst(E element);

    /**
     * Adds an element to the back of this deque.
     *
     * @param element the element to be added
     */
    public void addLast(E element);

    /**
     * Removes the object at the front of this deque and returns that object as the value of this function.
     *
     * @return the object at the front of this deque (if any)
     * @throws NoSuchElementException if this deque is empty
     */
    public E removeFirst() throws NoSuchElementException;

    /**
     * Removes the object at the back of this deque and returns that object as the value of this function.
     *
     * @return the object at the back of this deque (if any)
     * @throws NoSuchElementException if this deque is empty
     */
    public E removeLast() throws NoSuchElementException;

    /**
     * Looks at the object at the front of this deque without removing it from the deque.
     *
     * @return the object at the front of this deque (if any)
     * @throws NoSuchElementException if this deque is empty
     */
    public E getFirst() throws NoSuchElementException;

    /**
     * Looks at the object at the back of this deque without removing it from the deque.
     *
     * @return the object at the back of this deque (if any)
     * @throws NoSuchElementException if this deque is empty
     */
    public E getLast() throws NoSuchElementException;

    /**
     * Tests if this deque is empty.
     *
     * @return True if the deque is empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this deque.
     *
     * @return  the number of elements in this deque
     */
    public int getSize();
}
