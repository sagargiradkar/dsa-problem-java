// D_04_Smallest_Distinct.java

/*
Problem Statement:
Given a string `str`, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

Examples:
Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-string "dbca" has the smallest length that contains all characters of str.

Input: str = "aaab"
Output: 2
Explanation: Sub-string "ab" has the smallest length that contains all characters of str.

Input: str = "geeksforgeeks"
Output: 8
Explanation: "geeksfor" and "forgeeks" are both smallest valid windows.

Constraints:
1 ≤ str.length() ≤ 10^5
str contains only lowercase English letters.
*/

import java.util.*;

public class D_04_Smallest_Distinct {
    
    // Function to find the length of the smallest window
    public static int findSubString(String str) {
        // Step 1: Count total unique characters
        Set<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int totalUnique = uniqueChars.size();

        // Step 2: Use sliding window approach
        Map<Character, Integer> windowCount = new HashMap<>();
        int i = 0, j = 0;
        int minLen = Integer.MAX_VALUE;
        int uniqueInWindow = 0;

        while (j < str.length()) {
            // Expand window by adding str[j]
            char endChar = str.charAt(j);
            windowCount.put(endChar, windowCount.getOrDefault(endChar, 0) + 1);

            // If it's first time this character is included in window
            if (windowCount.get(endChar) == 1) {
                uniqueInWindow++;
            }

            // Try to shrink window
            while (uniqueInWindow == totalUnique && i <= j) {
                // Update min length
                minLen = Math.min(minLen, j - i + 1);

                // Shrink from left
                char startChar = str.charAt(i);
                windowCount.put(startChar, windowCount.get(startChar) - 1);
                if (windowCount.get(startChar) == 0) {
                    uniqueInWindow--;
                }
                i++;
            }
            j++;
        }

        return minLen;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        // Test cases
        String str1 = "aabcbcdbca";
        String str2 = "aaab";
        String str3 = "geeksforgeeks";

        System.out.println("Test 1: " + findSubString(str1));  // Output: 4
        System.out.println("Test 2: " + findSubString(str2));  // Output: 2
        System.out.println("Test 3: " + findSubString(str3));  // Output: 8
    }
}
