package main;

import java.util.NoSuchElementException;

/**
 * An implementation of a singly linked list.
 * @author Christine Zarges
 * @version 2.0, 19 September 2019
 */
public class DoublyLinkedList<E> {
    /**
     * Head and tail nodes.
     */
    private Node<E> head;
    private Node<E> tail;

    /**
     * The number of elements in the dequeu.
     */
    int size;

    /**
     * Constructor creating an empty singly linked list.
     */
    public DoublyLinkedList() {
        head = new Node(null, null, null);
        tail = new Node(null, head, null);
        head.setNext(tail);
        size = 0;
    }

    /**
     * Adds a new element to the front of the list.
     *
     * @param element the element to be added
     */
    public void addFirst(E element) {
        Node<E> node = new Node<E>(element, head, head.getNext());
        head.getNext().setPrevious(node);
        head.setNext(node);
        size++;
    }

    /**
     * Adds a new element to the back of the list.
     *
     * @param element the element to be added
     */
    public void addLast(E element) {
        Node<E> node = new Node<E>(element, tail.getPrevious(), tail);
        tail.getPrevious().setNext(node);
        tail.setPrevious(node);
        size++;
    }

    /**
     * Removes the element at the front of the list.
     *
     * @return the element at the front of the list
     * @throws NoSuchElementException if list is empty
     */
    public E removeFirst() throws NoSuchElementException {
        if (head.getNext() == tail)
            throw new NoSuchElementException(); // list is empty
        else {
            Node<E> element = head.getNext();
            head.getNext().getNext().setPrevious(head);
            head.setNext(head.getNext().getNext());
            size--;
            return element.getElement();
        }
    }

    /**
     * Removes the element at the back of the list.
     *
     * @return the element at the back of the list
     * @throws NoSuchElementException if list is empty
     */
    public E removeLast() throws NoSuchElementException {
        if (head.getNext() == tail)
            throw new NoSuchElementException(); // list empty
        else {
            Node<E> element = tail.getPrevious();
            tail.getPrevious().getPrevious().setNext(tail);
            tail.setPrevious(tail.getPrevious().getPrevious());
            size--;
            return element.getElement();
        }
    }

    /**
     * Get the element at the head of the list.
     *
     * @return the first element in the list
     * @throws NoSuchElementException if list is empty
     */
    public E getFirst() throws NoSuchElementException {
        if (head.getNext() == tail)
            throw new NoSuchElementException();
        return head.getNext().getElement();
    }

    /**
     * Get the element at the tail of the list.
     *
     * @return the last element in the list
     * @throws NoSuchElementException if list is empty
     */
    public E getLast() throws NoSuchElementException {
        if (tail.getPrevious() == head)
            throw new NoSuchElementException();
        return tail.getPrevious().getElement();
    }

    /**
     * Determines if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty(){
        return (head.getNext()==tail);
    }

    /**
     * Determines the number of elements in the list
     *
     * @return the number of elements in the list
     */
    public int getSize(){
        return size;
    }

    /**
     * A node class for a doubly linked list.
     *
     * @param <E> the type of the data stored in a node
     */
    public class Node<E> {
        /**
         * The content of the node.
         */
        private E element;

        /**
         * A reference to the next node in the list.
         */
        private Node<E> next;

        /**
         * A reference to the previous node in the list.
         */
        private Node<E> previous;

        /**
         * Constructor creating a new node with the specified content.
         * Sets reference to next and previous node to null.
         *
         * @param element the content of the new node
         */
        public Node(E element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        /**
         * Constructor creating a new node with the specified content.
         * Sets reference to next and previous node to null.
         *
         * @param element the content of the new node
         * @param next reference to the next node
         * @param previous reference to the previous node
         */
        public Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

        /**
         * Returns the content of the node.
         *
         * @return the content of the node
         */
        public E getElement() {
            return element;
        }

        /**
         * Sets the content of the node.
         *
         * @param element the new content of the node
         */
        public void setElement(E element) {
            this.element = element;
        }

        /**
         * Returns the reference to the next node.
         *
         * @return the next node in the list
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Sets the reference to the next node.
         *
         * @param next the next node in the list
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * Returns the reference to the previous node.
         *
         * @return the previous node in the list
         */
        public Node<E> getPrevious() {
            return previous;
        }

        /**
         * Sets the reference to the previous node.
         *
         * @param previous the previous previous in the list
         */
        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }
}
