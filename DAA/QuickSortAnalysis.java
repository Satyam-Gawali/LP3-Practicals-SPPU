// Program: Quick Sort Analysis (Deterministic and Randomized)
// Author: Satyam Gawali
// Language: Java

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class QuickSortAnalysis {

    // Deterministic Quick Sort (pivot = last element)
    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = deterministicPartition(arr, low, high);
            deterministicQuickSort(arr, low, pi - 1);
            deterministicQuickSort(arr, pi + 1, high);
        }
    }

    private static int deterministicPartition(int[] arr, int low, int high) {
        int pivot = arr[high]; // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap pivot to correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Randomized Quick Sort (pivot = random element)
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pi - 1);
            randomizedQuickSort(arr, pi + 1, high);
        }
    }

    private static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = low + rand.nextInt(high - low + 1);
        // Swap random pivot with last element
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[high];
        arr[high] = temp;

        return deterministicPartition(arr, low, high);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] arrDeterministic = Arrays.copyOf(arr, n);
        int[] arrRandomized = Arrays.copyOf(arr, n);

        // Measure deterministic Quick Sort
        long startDet = System.nanoTime();
        deterministicQuickSort(arrDeterministic, 0, n - 1);
        long endDet = System.nanoTime();
        double timeDeterministic = (endDet - startDet) / 1e6; // milliseconds

        // Measure randomized Quick Sort
        long startRand = System.nanoTime();
        randomizedQuickSort(arrRandomized, 0, n - 1);
        long endRand = System.nanoTime();
        double timeRandomized = (endRand - startRand) / 1e6; // milliseconds

        System.out.println("\nSorted array (Deterministic Quick Sort): " + Arrays.toString(arrDeterministic));
        System.out.println("Time taken (Deterministic): " + timeDeterministic + " ms");

        System.out.println("\nSorted array (Randomized Quick Sort): " + Arrays.toString(arrRandomized));
        System.out.println("Time taken (Randomized): " + timeRandomized + " ms");

        sc.close();
    }
}
