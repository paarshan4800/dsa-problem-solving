// Given an m x n binary matrix filled with 0's and 1's, find the largest square
// containing only 1's and return its area.

// Leetcode - https://leetcode.com/problems/maximal-square/

// Input: matrix = [
// ["1","0","1","0","0"],
// ["1","0","1","1","1"],
// ["1","1","1","1","1"],
// ["1","0","0","1","0"]
// ]
// Output: 4

// Input: matrix = [
// ["0","1"],
// ["1","0"]
// ]
// Output: 1

// Recursive Approach (Time limit exceeded)
// Since we are traversing n*m matrix we get O(n*m) and then for each element we
// make recursive calls. Therefore, we branch by 3 each time and get a
// runtime of 3 * 3 * 3 * … or 3^x where x is the depth. Since in each turn, we
// either go down or left in our
// matrix, we can find that the maximum depth of our recursion is
// n + m for an n by m matrix.
// Time Complexity - O(n*m*3^(n+m))

// Space Complexity - O(n+m) - Recursion Call stack
class Solution {
    public int maximalSquare(char[][] matrix) {

        int side = 0; // Side of the square matrix (initially 0)

        // Traverse the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                side = Math.max(side, maximalSquare(matrix, i, j));
            }
        }

        return side * side; // Return area of the square matrix

    }

    public int maximalSquare(char[][] matrix, int i, int j) {
        // Boundary condition
        if (i == matrix.length || j == matrix[i].length) {
            return 0;
        }

        // If current element is False, return
        if (matrix[i][j] == '0') {
            return 0;
        }

        int right = maximalSquare(matrix, i, j + 1); // Recur in the right direction
        int bottomRight = maximalSquare(matrix, i + 1, j + 1); // Recur in the bottom right direction
        int bottom = maximalSquare(matrix, i + 1, j); // Recur in the bottom direction

        // The current cell yields 1 to the solution
        // We return 1 + min(right,bottomRight,bottom)
        // We add minimum of three values to 1 because if either one of the three cells
        // is invalid (is '0' or crossed boundary) the square matrix is not valid
        return 1 + Math.min(right, Math.min(bottomRight, bottom));
    }
}

// Top Down Approach - Memoization
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {

        // Memoization table
        int[][] memo = new int[matrix.length][matrix[0].length];

        int side = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                side = Math.max(side, maximalSquare(matrix, i, j, memo));
            }
        }

        return side * side;

    }

    public int maximalSquare(char[][] matrix, int i, int j, int[][] memo) {
        if (i == matrix.length || j == matrix[i].length) {
            return 0;
        }

        if (matrix[i][j] == '0') {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int right = maximalSquare(matrix, i, j + 1, memo);
        int bottomRight = maximalSquare(matrix, i + 1, j + 1, memo);
        int bottom = maximalSquare(matrix, i + 1, j, memo);

        memo[i][j] = 1 + Math.min(right, Math.min(bottomRight, bottom));
        return memo[i][j];
    }
}

// Bottom Up Approach
// Time Complexity - O(m*n)
// Space Complexity - O(m*n)
class Solution {
    public int maximalSquare(char[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        int side = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                // If element is in 0th row or column, its value gets filled
                // This is to find solutions for intial sub problem and use these values to find
                // solution for next subproblem
                if (i == 0 || j == 0) {
                    dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                }
                // If current element is '0', it can't make a valid square so it remains 0
                // (default value)
                // Else
                else if (matrix[i][j] == '1') {
                    // Each cell in the dp array is a subproblem.
                    // Solution to dp[i][j] is 1 + min(dp[left],dp[top],dp[topLeft])
                    int left = dp[i][j - 1];
                    int top = dp[i - 1][j];
                    int topLeft = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(left, Math.min(topLeft, top));
                }

                side = Math.max(side, dp[i][j]); // Keep updating the max value of dp
            }
        }

        return side * side;

    }

}