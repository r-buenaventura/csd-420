// Roxanne Buenaventura
// CSD420
// Module 2.2 Programming Assignment: Write a program that will read a display the data from BuenaventuraWriteData.java
// 1 November 2026

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class BuenaventuraReadData {

    public static void main(String[] args) {

        try (DataInputStream input = new DataInputStream(
                new FileInputStream("Buenaventura_datafile.dat"))) {

            int setNumber = 1;

            // Continue reading until the end of the file.
            while (true) {

                int[] integers = new int[5];
                double[] doubles = new double[5];

                // Read five integers.
                for (int i = 0; i < 5; i++) {
                    integers[i] = input.readInt();
                }

                // Read five doubles.
                for (int i = 0; i < 5; i++) {
                    doubles[i] = input.readDouble();
                }

                System.out.println("\nData Set " + setNumber);

                System.out.print("Integers: ");
                for (int number : integers) {
                    System.out.print(number + " ");
                }

                System.out.print("\nDoubles: ");
                for (double number : doubles) {
                    System.out.printf("%.2f ", number);
                }

                System.out.println();
                setNumber++;
            }

        } catch (EOFException e) {
            // Reaching the end of the file is expected.
            System.out.println("\nFinished reading file.");

        } catch (IOException e) {
            System.out.println("Error reading data: " + e.getMessage());
        }
    }
}