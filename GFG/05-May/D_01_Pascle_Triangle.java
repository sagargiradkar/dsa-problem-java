/*
Problem Statement:
------------------
Given a positive integer n, return the nth row of Pascal's Triangle.

Pascal's triangle is a triangular array of the binomial coefficients
formed by summing up the elements of the previous row.

Examples:
---------
Input: n = 4
Output: [1, 3, 3, 1]

Input: n = 5
Output: [1, 4, 6, 4, 1]

Input: n = 1
Output: [1]

Constraints:
------------
1 ≤ n ≤ 20
*/

import java.util.ArrayList;

class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();
        long val = 1;
        row.add(1); // C(n-1, 0)

        for (int k = 1; k < n; k++) {
            val = val * (n - k) / k;
            row.add((int) val);
        }

        return row;
    }
}

public class D_01_Pascle_Triangle {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test case 1
        int n1 = 4;
        System.out.println("Input: n = " + n1);
        System.out.println("Output: " + sol.nthRowOfPascalTriangle(n1)); // [1, 3, 3, 1]

        // Test case 2
        int n2 = 5;
        System.out.println("Input: n = " + n2);
        System.out.println("Output: " + sol.nthRowOfPascalTriangle(n2)); // [1, 4, 6, 4, 1]

        // Test case 3
        int n3 = 1;
        System.out.println("Input: n = " + n3);
        System.out.println("Output: " + sol.nthRowOfPascalTriangle(n3)); // [1]
    }
}
