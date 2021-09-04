// Given a boolean 2D array of n x m dimensions where each row is sorted. Find
// the 0-based index of the first row that has the maximum number of 1's.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#

// N = 4 , M = 4
// Arr[][] = {{0, 1, 1, 1},
// {0, 0, 1, 1},
// {1, 1, 1, 1},
// {0, 0, 0, 0}}
// Output: 2

// Input:
// N = 2, M = 2
// Arr[][] = {{0, 0}, {1, 1}}
// Output: 1

// Best Approach
// Time Complexity - O(m+n)
// Space Complexity - O(1)
class Solution {
    int rowWithMax1s(int arr[][], int n, int m) {
        // code here
        int col = m - 1, row = 0, res = -1;

        // Start from top right (row = 0 and col = m-1)
        while (row < n && col >= 0) {
            // If current cell is 1, this might be the result. So update res and move left
            if (arr[row][col] == 1) {
                res = row;
                col--;
            }
            // If not 1, move to next row
            else {
                row++;
            }
        }
        return res;
    }
}