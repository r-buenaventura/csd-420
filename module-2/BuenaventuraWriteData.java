// Roxanne Buenaventura
// CSD420
// Module 2.2 Programming Assignment: Write a program that stores an array of 5 random integers and an array of 5 random double values.
// 1 November 2026

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BuenaventuraWriteData {

    public static void main(String[] args) {

        int[] integers = new int[5];
        double[] doubles = new double[5];
        Random random = new Random();

        // Generate five random integers and five random doubles.
        for (int i = 0; i < 5; i++) {
            integers[i] = random.nextInt(100) + 1;
            doubles[i] = random.nextDouble() * 100;
        }

        // Open the file in append mode.
        try (DataOutputStream output = new DataOutputStream(
                new FileOutputStream("Buenaventura_datafile.dat", true))) {

            // Write the five integers to the file.
            for (int number : integers) {
                output.writeInt(number);
            }

            // Write the five doubles to the file.
            for (double number : doubles) {
                output.writeDouble(number);
            }

            System.out.println("Data successfully written to file.");

        } catch (IOException e) {
            System.out.println("Error writing data: " + e.getMessage());
        }
    }
}