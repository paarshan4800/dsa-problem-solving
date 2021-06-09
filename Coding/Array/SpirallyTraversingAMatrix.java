// Given a matrix of size r*c. Traverse the matrix in spiral form.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1#

// Input:
// r = 4, c = 4
// matrix[][] = {{1, 2, 3, 4},
// {5, 6, 7, 8},
// {9, 10, 11, 12},
// {13, 14, 15,16}}
// Output:
// 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

// Input:
// r = 3, c = 4
// matrix[][] = {{1, 2, 3, 4},
// {5, 6, 7, 8},
// {9, 10, 11, 12}}
// Output:
// 1 2 3 4 8 12 11 10 9 5 6 7

// Time Complexity - O(r*c)
// Space Complexity - O(r*c)
class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {

        // Use boundaries to cover all four sides of the matrix
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        int dir = 0; // dir will tell which direction we are traversing
        ArrayList<Integer> res = new ArrayList<>();

        // Till we are within the four boundaries
        while (top <= bottom && left <= right) {
            if (dir == 0) { // dir == 0 means left to right
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++; // since top row has been traversed move to next one
                dir = 1; // update dir to goto next direction
            } else if (dir == 1) { // dir == 1 means top to bottom
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--; // since right column has been traversed move to next one
                dir = 2; // update dir to goto next direction
            } else if (dir == 2) { // dir == 0 means right to left
                for (int i = right; i >= left; i--) {
                    res.add(matrix[bottom][i]);
                }
                bottom--; // since bottom row has been traversed move to next one
                dir = 3;// update dir to goto next direction
            } else if (dir == 3) { // dir == 0 means bottom to top
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++; // since left column has been traversed move to next one
                dir = 0;// update dir to goto next direction
            }
        }

        return res;
    }
}
