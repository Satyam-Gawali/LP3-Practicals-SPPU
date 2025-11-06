// Program: Huffman Encoding using Greedy Strategy
// Author: Satyam Gawali
// Language: Java

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

// A Huffman tree node
class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }

    Node(int freq, Node left, Node right) {
        this.ch = '\0'; // Internal node (not a character)
        this.freq = freq;
        this.left = left;
        this.right = right;
    }
}

public class HuffmanEncoding {

    // Recursive function to print Huffman codes from the root
    public static void printCodes(Node root, String code) {
        if (root == null)
            return;

        // Leaf node
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Main function to build Huffman tree and print codes
    public static void buildHuffmanTree(char[] chars, int[] freq) {
        // Step 1: Create a min-heap (priority queue) for Huffman tree nodes
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.freq));

        // Step 2: Create a leaf node for each character and add to the queue
        for (int i = 0; i < chars.length; i++) {
            pq.add(new Node(chars[i], freq[i]));
        }

        // Step 3: Build the Huffman Tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            // Combine two smallest nodes
            Node merged = new Node(left.freq + right.freq, left, right);
            pq.add(merged);
        }

        // Step 4: The remaining node is the root node
        Node root = pq.peek();

        System.out.println("\nHuffman Codes:");
        printCodes(root, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        char[] chars = new char[n];
        int[] freq = new int[n];

        System.out.println("Enter characters and their frequencies:");
        for (int i = 0; i < n; i++) {
            System.out.print("Character " + (i + 1) + ": ");
            chars[i] = sc.next().charAt(0);
            System.out.print("Frequency of " + chars[i] + ": ");
            freq[i] = sc.nextInt();
        }

        buildHuffmanTree(chars, freq);
        sc.close();
    }
}
