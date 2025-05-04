// D_04_Number_Equvalent.java

/*
Problem Statement:
Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

Examples:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1

Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
Output: 3

Constraints:
1 <= dominoes.length <= 4 * 10^4
dominoes[i].length == 2
1 <= dominoes[i][j] <= 9
*/

import java.util.*;

public class D_04_Number_Equvalent {

    public int numEquivDominoPairs(int[][] dominoes) {
        // HashMap to store the count of each normalized domino
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        // Loop through each domino in the input
        for (int[] domino : dominoes) {
            // Normalize the domino by sorting its elements (min, max)
            int a = domino[0];
            int b = domino[1];
            String key = a < b ? a + "," + b : b + "," + a;

            // If the domino exists in the map, it means we've seen it before
            if (map.containsKey(key)) {
                count += map.get(key); // Add the number of equivalent pairs
            }

            // Update the map with the normalized domino
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return count;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Create an instance of the solution class
        D_04_Number_Equvalent solution = new D_04_Number_Equvalent();

        // Test cases
        int[][] dominoes1 = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        int[][] dominoes2 = {{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}};

        // Print results
        System.out.println("Test 1: " + solution.numEquivDominoPairs(dominoes1));  // Output: 1
        System.out.println("Test 2: " + solution.numEquivDominoPairs(dominoes2));  // Output: 3
    }
}
