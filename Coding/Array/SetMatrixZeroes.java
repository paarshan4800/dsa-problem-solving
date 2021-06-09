// Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.

// Leetcode - https://leetcode.com/problems/set-matrix-zeroes/

// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

// Brute Force Approach
// Traverse the 2d matrix. If current cell is 0, traverse its row and column and fill all non-zero elements as -1.
// Dont change zero to -1 because we need to change that zero's row and column.
// Then traverse again and replace -1 with 0
// Time Complexity - O(m*n*(m+n))

// Efficient Approach
// Time Complexity - O(m*n)
// Space Complexity - O(m+n)
class Solution {
    public void setZeroes(int[][] matrix) {

        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];

        // Traverse the 2d matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // If current cell is zero
                if (matrix[i][j] == 0) {
                    row[i] = 1; // Fill row[i] as 1
                    column[j] = 1; // Fill column[j] as 1
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // If either row[current cell's index] == 1 or column[current cell's index] ==
                // 1, set matrix[i][j] = 0
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

    }
}