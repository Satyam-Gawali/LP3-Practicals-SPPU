// Program: Compare Recursive and Non-Recursive Fibonacci Implementations

import java.util.Scanner;

public class FibonacciAnalysis {

    // Non-Recursive (Iterative) Method
    static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;

        int prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // Recursive Method
    static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Main Function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Fibonacci term (n): ");
        int n = sc.nextInt();

        Runtime runtime = Runtime.getRuntime();

        // ---- ITERATIVE APPROACH ----
        System.out.println("\n--- Iterative Fibonacci ---");

        // Measure memory before
        runtime.gc();
        long beforeUsedMemIter = runtime.totalMemory() - runtime.freeMemory();
        long startTimeIter = System.nanoTime();

        int fibIter = fibonacciIterative(n);

        long endTimeIter = System.nanoTime();
        long afterUsedMemIter = runtime.totalMemory() - runtime.freeMemory();

        long timeTakenIter = endTimeIter - startTimeIter;
        long memoryUsedIter = afterUsedMemIter - beforeUsedMemIter;

        System.out.println("Fibonacci(" + n + ") = " + fibIter);
        System.out.println("Time Taken: " + timeTakenIter + " ns");
        System.out.println("Memory Used: " + memoryUsedIter + " bytes");

        // ---- RECURSIVE APPROACH ----
        System.out.println("\n--- Recursive Fibonacci ---");

        runtime.gc();
        long beforeUsedMemRec = runtime.totalMemory() - runtime.freeMemory();
        long startTimeRec = System.nanoTime();

        int fibRec = fibonacciRecursive(n);

        long endTimeRec = System.nanoTime();
        long afterUsedMemRec = runtime.totalMemory() - runtime.freeMemory();

        long timeTakenRec = endTimeRec - startTimeRec;
        long memoryUsedRec = afterUsedMemRec - beforeUsedMemRec;

        System.out.println("Fibonacci(" + n + ") = " + fibRec);
        System.out.println("Time Taken: " + timeTakenRec + " ns");
        System.out.println("Memory Used: " + memoryUsedRec + " bytes");

        sc.close();
    }
}
