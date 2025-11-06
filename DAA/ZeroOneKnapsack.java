// Program: 0-1 Knapsack using Dynamic Programming
// Author: Satyam Gawali
// Language: Java

import java.util.Scanner;

public class ZeroOneKnapsack {

    // Function to solve 0-1 Knapsack using DP
    public static int knapsack(int[] values, int[] weights, int n, int W) {
        // DP table: rows = items, cols = capacities
        int[][] dp = new int[n + 1][W + 1];

        // Build table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // Base case
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Return maximum value
        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " value: ");
            values[i] = sc.nextInt();
            System.out.print("Item " + (i + 1) + " weight: ");
            weights[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of the knapsack: ");
        int W = sc.nextInt();

        int maxValue = knapsack(values, weights, n, W);
        System.out.println("Maximum value in 0-1 Knapsack = " + maxValue);

        sc.close();
    }
}
