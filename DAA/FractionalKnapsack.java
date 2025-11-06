// Program: Fractional Knapsack using Greedy Method

import java.util.Arrays;
import java.util.Scanner;

// Class to represent an item
class Item {
    int value, weight;
    
    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

public class FractionalKnapsack {

    // Function to solve Fractional Knapsack problem
    public static double fractionalKnapsack(int W, Item[] items) {
        // Calculate value/weight ratio and sort items in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

        double totalValue = 0.0;
        int remainingWeight = W;

        for (Item item : items) {
            if (item.weight <= remainingWeight) {
                // Take full item
                totalValue += item.value;
                remainingWeight -= item.weight;
            } else {
                // Take fraction of item
                totalValue += item.value * ((double)remainingWeight / item.weight);
                break; // Knapsack is full
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] items = new Item[n];

        System.out.println("Enter value and weight of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i+1) + " value: ");
            int value = sc.nextInt();
            System.out.print("Item " + (i+1) + " weight: ");
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        System.out.print("Enter capacity of the knapsack: ");
        int W = sc.nextInt();

        double maxValue = fractionalKnapsack(W, items);
        System.out.printf("Maximum value in Knapsack = %.2f\n", maxValue);

        sc.close();
    }
}
