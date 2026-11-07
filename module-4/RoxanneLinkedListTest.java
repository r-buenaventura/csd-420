// Roxanne Buenaventura
// CSD 420
// Module 4.2 Assignment: create a Java program that compares the time it takes to traverse a LinkedList using two different approaches: Iterator: moves through the list one element at a time, and get(index): retrieves each element by its index.
// 7 November 2026


// Performance Test Results:
//
// I tested the LinkedList using 50,000 and 500,000 integers to compare traversal times with an Iterator and get(index).
//
// With 50,000 integers, the Iterator took 1.63 ms, while get(index) took 933.07 ms.
//
// With 500,000 integers, the Iterator took 3.69 ms, while get(index) took 103,540.52 ms (about 103.5 seconds).
//
// What stood out to me was how much slower get(index) became as the list grew. Increasing the list size by 10 times made get(index) about 111 times slower, while the Iterator only took about 2.26 times longer.
//
// This happens because an Iterator moves directly from one element to the next, while get(index) must repeatedly traverse the LinkedList to find each requested element.
//
// Both methods passed the correctness tests and produced the expected sums. This shows that even when two methods produce the same results, choosing the right approach can make a huge difference in performance.
//


import java.util.LinkedList;
import java.util.Iterator;

public class RoxanneLinkedListTest {

    public static void main(String[] args) {

        // Test the LinkedList with 50,000 integers.
        testTraversal(50000);

        // Test the LinkedList with 500,000 integers.
        testTraversal(500000);
    }

    // Creates a LinkedList and compares traversal times.
    public static void testTraversal(int size) {

        LinkedList<Integer> list = new LinkedList<>();

        // Add integers to the LinkedList.
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        System.out.println("\nTesting LinkedList with "
                + size + " integers:");

        // Measure traversal time using an Iterator.
        long startTime = System.nanoTime();

        long iteratorSum = 0;
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            iteratorSum += iterator.next();
        }

        long iteratorTime = System.nanoTime() - startTime;

        // Measure traversal time using get(index).
        startTime = System.nanoTime();

        long indexSum = 0;

        for (int i = 0; i < list.size(); i++) {
            indexSum += list.get(i);
        }

        long indexTime = System.nanoTime() - startTime;

        // Display traversal times in milliseconds.
        System.out.println("Iterator time: "
                + iteratorTime / 1_000_000.0 + " ms");

        System.out.println("get(index) time: "
                + indexTime / 1_000_000.0 + " ms");

        // Verify that both methods produce the same sum.
        long expectedSum = (long) size * (size - 1) / 2;

        if (iteratorSum == expectedSum &&
                indexSum == expectedSum) {
            System.out.println("Test PASSED: Both methods "
                    + "produced the correct sum.");
        } else {
            System.out.println("Test FAILED: Results "
                    + "do not match.");
        }
    }
}
