public class D_03_Minimum_Domino_Rotation {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] tops1 = {2, 1, 2, 4, 2, 2};
        int[] bottoms1 = {5, 2, 6, 2, 3, 2};
        System.out.println("Minimum rotations for test case 1: " + solution.minDominoRotations(tops1, bottoms1));

        // Test case 2
        int[] tops2 = {3, 5, 1, 2, 3};
        int[] bottoms2 = {3, 6, 3, 3, 4};
        System.out.println("Minimum rotations for test case 2: " + solution.minDominoRotations(tops2, bottoms2));
    }

    static class Solution {
        public int minDominoRotations(int[] tops, int[] bottoms) {
            // Check for each number from 1 to 6 if we can make the row uniform with that number
            for (int target = 1; target <= 6; target++) {
                int topRotations = 0;
                int bottomRotations = 0;
                boolean isPossible = true;

                // Try to make both rows the same as target
                for (int i = 0; i < tops.length; i++) {
                    if (tops[i] != target && bottoms[i] != target) {
                        isPossible = false; // If neither top nor bottom is target, impossible
                        break;
                    }
                    if (tops[i] != target) {
                        topRotations++; // Need to rotate this domino to make the top = target
                    }
                    if (bottoms[i] != target) {
                        bottomRotations++; // Need to rotate this domino to make the bottom = target
                    }
                }

                // If it's possible to make the row uniform with the target, return the minimum rotations
                if (isPossible) {
                    return Math.min(topRotations, bottomRotations);
                }
            }

            // If no solution was found, return -1
            return -1;
        }
    }
}
