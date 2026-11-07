// Roxanne Buenaventura
// CSD 420
// Module 3.2 Programming Assignment: Write a test program that contains a static method that returns a new ArratList containing all original values with no duplicates from the origional ArrayList.
// 7 November 2026


import java.util.ArrayList;
import java.util.Random;

public class RoxanneRemoveDuplicates {

    public static void main(String[] args) {

        // Create an ArrayList to store the original values.
        ArrayList<Integer> originalList = new ArrayList<>();

        Random random = new Random();

        // Generate 50 random integers between 1 and 20.
        for (int i = 0; i < 50; i++) {
            originalList.add(random.nextInt(20) + 1);
        }

        // Display the original ArrayList.
        System.out.println("Original ArrayList:");
        System.out.println(originalList);

        // Call the generic method to remove duplicates.
        ArrayList<Integer> uniqueList = removeDuplicates(originalList);

        // Display the new ArrayList without duplicates.
        System.out.println("\nArrayList Without Duplicates:");
        System.out.println(uniqueList);
    }

    // Returns a new ArrayList containing only unique values.
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> uniqueList = new ArrayList<>();

        // Check each element in the original list.
        for (E element : list) {

            // Add the element only if it is not already present.
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }
}
