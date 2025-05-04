/*
Problem Statement:
------------------
Given an array of integers arr[] that is first strictly increasing and 
then maybe strictly decreasing, find the bitonic point, 
that is the maximum element in the array.

Bitonic Point is a point before which elements are strictly increasing 
and after which elements are strictly decreasing.

It is guaranteed that the array contains exactly one bitonic point.

Examples:
---------
Input: arr[] = [1, 2, 4, 5, 7, 8, 3]
Output: 8

Input: arr[] = [10, 20, 30, 40, 50]
Output: 50

Input: arr[] = [120, 100, 80, 20, 0]
Output: 120

Constraints:
------------
3 ≤ arr.length ≤ 10^5
1 ≤ arr[i] ≤ 10^6
*/

class Solution {
    public int findMaximum(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Middle of the array and valid to compare both neighbors
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid]; // Bitonic point found
                } else if (arr[mid] < arr[mid + 1]) {
                    low = mid + 1; // Move right (increasing)
                } else {
                    high = mid - 1; // Move left (decreasing)
                }
            }
            // Edge cases
            else if (mid == 0) {
                return arr[0] > arr[1] ? arr[0] : arr[1];
            } else if (mid == arr.length - 1) {
                return arr[arr.length - 1] > arr[arr.length - 2] ? arr[arr.length - 1] : arr[arr.length - 2];
            }
        }

        return -1; // Should never occur if array is valid
    }
}

public class D_02_Bitonic_Point {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {1, 2, 4, 5, 7, 8, 3};
        int[] arr2 = {10, 20, 30, 40, 50};
        int[] arr3 = {120, 100, 80, 20, 0};

        System.out.println("Bitonic Point of arr1: " + sol.findMaximum(arr1)); // 8
        System.out.println("Bitonic Point of arr2: " + sol.findMaximum(arr2)); // 50
        System.out.println("Bitonic Point of arr3: " + sol.findMaximum(arr3)); // 120
    }
}
