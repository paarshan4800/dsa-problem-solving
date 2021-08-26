// Given a matrix of size n x m, where every row and column is sorted in
// increasing order, and a number x. Find whether element x is present in the
// matrix or not.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/search-in-a-matrix-1587115621/1/

// Input:
// n = 3, m = 3, x = 62
// matrix[][] = {{ 3, 30, 38},
// {36, 43, 60},
// {40, 51, 69}}
// Output: 0
// Explanation:
// 62 is not present in the matrix,
// so output is 0.

class Solution {
    // Function to search a given number in row-column sorted matrix.
    static boolean search(int matrix[][], int n, int m, int x) {
        int row = 0, col = m - 1;

        // Till row and col are within the boundaries
        while (row >= 0 && row < n && col >= 0 && col < m) {
            if (matrix[row][col] == x)
                return true;

            // If less than required value, go to next row
            if (matrix[row][col] < x)
                row++;
            // If greater than required value, go to previous column
            else
                col--;
        }

        return false;
    }
}
