// D_03_Prime_List.java

/*
Problem Statement:
You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number.
If more than one prime number exists at an equal distance, choose the smallest one. Return the head of the modified linked list.

Examples:

Input: head = 2 → 6 → 10
Output: 2 → 5 → 11

Input: head = 1 → 15 → 20
Output: 2 → 13 → 19

Constraints:
1 <= no. of Nodes <= 10^4
1 <= node.val <= 10^4
*/

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

public class D_03_Prime_List {

    static final int MAX = 100010;
    static boolean[] isPrime = new boolean[MAX];

    // Static block to initialize the sieve of Eratosthenes
    static {
        for (int i = 0; i < MAX; i++) isPrime[i] = true;
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // Method to find the nearest prime
    static int nearestPrime(int num) {
        if (isPrime[num]) return num;

        int left = num - 1;
        int right = num + 1;

        while (left >= 2 || right < MAX) {
            if (left >= 2 && isPrime[left]) return left;
            if (right < MAX && isPrime[right]) return right;
            left--;
            right++;
        }
        return 2; // fallback
    }

    // Function to replace all nodes with nearest primes
    static Node primeList(Node head) {
        Node curr = head;
        while (curr != null) {
            curr.val = nearestPrime(curr.val);
            curr = curr.next;
        }
        return head;
    }

    // Helper method to create linked list from array
    static Node createList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node curr = head;
        for (int i = 1; i < arr.length; i++) {
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    // Helper method to print linked list
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" → ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Main method with sample inputs
    public static void main(String[] args) {
        int[] input1 = {2, 6, 10};
        int[] input2 = {1, 15, 20};

        Node list1 = createList(input1);
        Node list2 = createList(input2);

        System.out.print("Input 1: ");
        printList(list1);
        list1 = primeList(list1);
        System.out.print("Output 1: ");
        printList(list1);

        System.out.print("Input 2: ");
        printList(list2);
        list2 = primeList(list2);
        System.out.print("Output 2: ");
        printList(list2);
    }
}
