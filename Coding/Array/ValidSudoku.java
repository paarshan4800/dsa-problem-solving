// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition
// Leetcode - https://leetcode.com/problems/valid-sudoku/solution/
// Solution - https://www.youtube.com/watch?v=Pl7mMcBm2b8

// O(n^2) - Time Complexity
// O(n^2) - Space Complexity
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Instead of making seperate hash for row, column and box
        // Make a single hash of strings
        Set<String> hash = new HashSet<String>();
        
        // Traverse the matrix
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                // If element not empty
                if(board[i][j] != '.') {

                    // hash.add() returns true if added and false if already present

                    // If the current element is not added as a row record in index i, then add it.
                    // If already exists, then it contradicts the sudoku design, return false
                    if(!hash.add(board[i][j] + " row at " + i)) {
                        return false;
                    }
                    // If the current element is not added as a column record in index j, then add it.
                    // If already exists, then it contradicts the sudoku design, return false
                    if(!hash.add(board[i][j] + " column at " + j)) {
                        return false;
                    }
                    // If the current element is not added as a box record in index i/3,j/3, then add it.
                    // diving iterator by three gives the sub boxes number
                    // If already exists, then it contradicts the sudoku design, return false
                    if(!hash.add(board[i][j] + " box at " + i/3 + " " + j/3)) {
                        return false;
                    }
                }
            }
        }
        
        return true;
        
    }
}