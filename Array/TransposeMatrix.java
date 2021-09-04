// Given a 2D integer array matrix, return the transpose of matrix.

// The transpose of a matrix is the matrix flipped over its main diagonal,
// switching the matrix's row and column indices.

// Leetcode - https://leetcode.com/problems/transpose-matrix/

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[1,4,7],[2,5,8],[3,6,9]]

// Input: matrix = [[1,2,3],[4,5,6]]
// Output: [[1,4],[2,5],[3,6]]

// Time Complexity - O(m*n)
class Solution {
    public int[][] transpose(int[][] matrix) {

        int[][] res = new int[matrix[0].length][matrix.length];

        // Copy matrix[i][j] into res[j][i]
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[j][i] = matrix[i][j];
            }
        }

        return res;

    }
}