package main;

import java.util.NoSuchElementException;

/**
 * An implementation of a singly linked list.
 * @author Christine Zarges
 * @version 2.0, 19 September 2019
 */
public class SinglyLinkedList<E> {
    /**
     * Head and tail nodes.
     */
    private Node<E> head;
    private Node<E> tail;

    /**
     * The number of elements in the list.
     */
    int size;

    /**
     * Constructor creating an empty singly linked list.
     */
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds a new element to the front of the list.
     *
     * @param element the element to be added
     */
    public void addFirst(E element) {
        Node<E> node = new Node<E>(element);
        node.setNext(head);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            head = node;
        }
        size++;
    }

    /**
     * Adds a new element to the back of the list.
     *
     * @param element the element to be added
     */
    public void addLast(E element) {
        Node<E> node = new Node<E>(element);
        node.setNext(null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Removes the element at the front of the list.
     *
     * @return the element at the front of the list
     * @throws NoSuchElementException if list is empty
     */
    public E removeFirst() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException(); // list is empty
        else {
            Node<E> node = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.getNext();
            }
            size--;
            return node.getElement();
        }
    }

    /**
     * Removes the element at the back of the list.
     *
     * @return the element at the back of the list
     * @throws NoSuchElementException if list is empty
     */
    public E removeLast() throws NoSuchElementException {
        if (tail == null)
            throw new NoSuchElementException(); // list empty
        else {
            Node<E> node = tail;
            if (head == tail) { // 1 element
                head = null;
                tail = null;
            } else {
                Node<E> cur = head;
                while (cur.getNext() != tail)
                    cur = cur.getNext();
                cur.setNext(null);
                tail = cur;
            }
            size--;
            return node.getElement();
        }
    }

    /**
     * Returns the element at the front of the list without removing it.
     *
     * @return the element at the front of the list
     * @throws NoSuchElementException if list is empty
     */
    public E getFirst() throws NoSuchElementException {
        if (head == null)
            throw new NoSuchElementException(); // list is empty
        else {
            return head.getElement();
        }
    }

    /**
     * Returns the element at the back of the list without removing it.
     *
     * @return the element at the back of the list
     * @throws NoSuchElementException if list is empty
     */
    public E getLast() throws NoSuchElementException {
        if (tail == null)
            throw new NoSuchElementException(); // list empty
        else {
            return tail.getElement();
        }
    }

    /**
     * Tests if this list is empty.
     *
     * @return True if the list is empty, false otherwise
     */
    public boolean isEmpty(){
        return (head == null);
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int getSize(){
        return size;
    }

    /**
     * An implementation of a node for a singly linked list.
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
         * Constructor creating a new node with the specified content.
         * Sets reference to next node to null.
         *
         * @param element the content of the new node
         */
        public Node(E element) {
            this.element = element;
            this.next = null;
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
        public Node getNext() {
            return next;
        }

        /**
         * Sets the reference to the next node.
         *
         * @param next the next node in the list
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }
}
