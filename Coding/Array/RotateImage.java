// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
// Leetcode - https://leetcode.com/problems/rotate-image/solution/
// Solution - https://www.youtube.com/watch?v=Pl7mMcBm2b8

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]

// Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
// Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

// Input: matrix = [[1]]
// Output: [[1]]

// Input: matrix = [[1,2],[3,4]]
// Output: [[3,1],[4,2]]



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