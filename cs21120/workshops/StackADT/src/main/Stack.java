package main;

import java.util.NoSuchElementException;

/**
 * A main.Stack interface.
 * @author Christine Zarges
 * @version 2.0, 30 September 2022
 */
public interface Stack<E> {
    /**
     * Pushes an element onto the top of this stack.
     *
     * @param element the element to be pushed onto the top of this stack
     */
    void push(E element);

    /**
     * Removes the object at the top of this stack and returns that object as the value of this function.
     *
     * @return the object at the top of this stack (if any)
     * @throws NoSuchElementException if this stack is empty
     */
    E pop() throws NoSuchElementException;

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     *
     * @return the object at the top of this stack (if any)
     * @throws NoSuchElementException if this stack is empty
     */
    E peek() throws NoSuchElementException;

    /**
     * Tests if this stack is empty.
     *
     * @return True if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Returns the number of elements in this stack.
     *
     * @return  the number of elements in this stack
     */
    int getSize();
}
