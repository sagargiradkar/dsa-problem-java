// Problem: Search in an Almost Sorted Array
// Given a sorted integer array arr[] consisting of distinct elements, 
// where some elements of the array are moved to either of the adjacent positions,
// i.e., arr[i] may be present at arr[i-1] or arr[i+1].
// Given an integer target, return the index (0-based) of the target in the array.
// If target is not present, return -1.

// Example:
// Input: arr[] = [10, 3, 40, 20, 50, 80, 70], target = 40
// Output: 2

public class D_05_Search_Sorted_Array {

    public static int findTarget(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check mid, mid-1, and mid+1
            if (arr[mid] == target) {
                return mid;
            }
            if (mid > low && arr[mid - 1] == target) {
                return mid - 1;
            }
            if (mid < high && arr[mid + 1] == target) {
                return mid + 1;
            }

            // Adjust search space
            if (arr[mid] > target) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 3, 40, 20, 50, 80, 70};
        int target1 = 40;
        System.out.println("Index of " + target1 + ": " + findTarget(arr1, target1)); // Output: 2

        int target2 = 90;
        System.out.println("Index of " + target2 + ": " + findTarget(arr1, target2)); // Output: -1

        int[] arr2 = {-20};
        int target3 = -20;
        System.out.println("Index of " + target3 + ": " + findTarget(arr2, target3)); // Output: 0
    }
}
