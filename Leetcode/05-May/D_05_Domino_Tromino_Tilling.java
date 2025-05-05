// Problem: Leetcode 790. Domino and Tromino Tiling
// Difficulty: Medium
//
// You have two types of tiles: a 2 x 1 domino shape and an L-shaped tromino shape. You may rotate these shapes.
//
// Given an integer n, return the number of ways to tile a 2 x n board. Since the answer may be very large, return it modulo 10^9 + 7.
//
// A tiling is different if there are two 4-directionally adjacent cells on the board such that
// exactly one of the tilings has both squares occupied by a tile.
//
// Examples:
// Input: n = 3
// Output: 5
// Explanation: There are 5 ways to tile a 2 x 3 board.
//
// Input: n = 1
// Output: 1

public class D_05_Domino_Tromino_Tilling {

    public static int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % MOD + dp[i - 3]) % MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("Number of ways to tile 2 x " + n1 + " board: " + numTilings(n1)); // Output: 5

        int n2 = 1;
        System.out.println("Number of ways to tile 2 x " + n2 + " board: " + numTilings(n2)); // Output: 1

        int n3 = 5;
        System.out.println("Number of ways to tile 2 x " + n3 + " board: " + numTilings(n3)); // Output: 24
    }
}
