package main;

import java.text.DecimalFormat;

/**
 * A simple profiler to perform some experiments with the two stack implementations.
 *
 * @author Christine Zarges
 * @version 2.0, 30 September 2022
 */
public class StackProfiler {

    /**
     * The two stacks.
     */
    Stack<Integer> arrayStack;
    Stack<Integer> listStack;

    /**
     * The capacity of the array in the array implementation.
     */
    int capacity = 1000;

    /**
     * The number of times a given series of push and pop operations is performed.
     */
    int repetitions = 1000000;

    public StackProfiler(){
    }

    public void run(){
        // Formatting of output
        DecimalFormat numberFormat = new DecimalFormat("#0.000000");

        System.out.println("Array-based stack:");
        long startTime = System.nanoTime();
        arrayStack = new ArrayStack<>(capacity);

        // perform push and pop operations on array implementation
        for (int i = 0; i < repetitions; i++) {
            // push until array is full
            for (int j = 0; j < capacity; j++)
                arrayStack.push(j);
            // pop all elements
            for (int j = 0; j < capacity; j++)
                arrayStack.pop();
        }
        long endTime = System.nanoTime();
        double elapsedTime = (double)(endTime-startTime)/1000000.0;
        System.out.println(numberFormat.format(elapsedTime)+" milliseconds ("
                +numberFormat.format(elapsedTime/1000.0)+" seconds).");

        System.out.println("List-based stack:");
        startTime = System.nanoTime();
        listStack = new ListStack<>();

        // perform push and pop operations on list implementation
        for (int i = 0; i < repetitions; i++) {
            // push the same number of elements as for the array implementation
            for (int j = 0; j < capacity; j++)
                listStack.push(j);
            // pop all elements
            for (int j = 0; j < capacity; j++)
                listStack.pop();
        }
        endTime = System.nanoTime();
        elapsedTime = (double)(endTime-startTime)/1000000.0;
        System.out.println(numberFormat.format(elapsedTime)+" milliseconds ("
                +numberFormat.format(elapsedTime/1000.0)+" seconds).");
    }

    public static void main(String[] args){
        StackProfiler profiler = new StackProfiler();
        profiler.run();
    }
}
