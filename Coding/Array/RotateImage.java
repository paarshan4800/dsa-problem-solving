// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// Leetcode - https://leetcode.com/problems/valid-sudoku/solution/
// Solution - https://www.youtube.com/watch?v=Pl7mMcBm2b8


// O(n^2) - Time Complexity
// O(1) - Space Complexity

class Solution {
        
    public void rotate(int[][] matrix) {

        // Approach
        // First take transpose of matrix
        // Then reverse each row
            
        int size = matrix.length;
        
        // Take transpose of the matrix
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                // Since diagonals remain the same, break when i == j
                if(i == j) {
                    break;
                }

                // Else swap(matrix[i][j],matrix[j][i])
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse each row of the matrix
        for(int i=0;i<size;i++) {
            // Two pointer approach
            int low = 0,high = size-1;
            while(low<high) {
                int temp = matrix[i][low];
                matrix[i][low] = matrix[i][high];
                matrix[i][high] = temp;
                low++;
                high--;
            }
        }
        
    }
}