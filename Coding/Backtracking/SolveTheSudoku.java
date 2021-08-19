// Given an incomplete Sudoku configuration in terms of a 9 x 9 2-D square
// matrix (grid[][]), the task to find a solved Sudoku. For simplicity, you may
// assume that there will be only one unique solution.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1/

// Input:
// grid[][] =
// [[3 0 6 5 0 8 4 0 0],
// [5 2 0 0 0 0 0 0 0],
// [0 8 7 0 0 0 0 3 1 ],
// [0 0 3 0 1 0 0 8 0],
// [9 0 0 8 6 3 0 0 5],
// [0 5 0 0 9 0 6 0 0],
// [1 3 0 0 0 0 2 5 0],
// [0 0 0 0 0 0 0 7 4],
// [0 0 5 2 0 6 3 0 0]]
// Output:
// 3 1 6 5 7 8 4 9 2
// 5 2 9 1 3 4 7 6 8
// 4 8 7 6 2 9 5 3 1
// 2 6 3 4 1 5 9 8 7
// 9 7 4 8 6 3 1 2 5
// 8 5 1 7 9 2 6 4 3
// 1 3 8 9 4 7 2 5 6
// 6 9 2 3 5 1 8 7 4
// 7 4 5 2 8 6 3 1 9

// Time Complexity - O(9^n*n)
class Solution {
    // Function to find a solved Sudoku.

    static boolean isPlacementValid(int grid[][], int i, int j, int val) {

        // Row
        for (int y = 0; y < grid.length; y++) {
            if (grid[i][y] == val)
                return false;
        }

        // Column
        for (int x = 0; x < grid.length; x++) {
            if (grid[x][j] == val)
                return false;
        }

        // 3x3 box
        int xBox = 3 * (i / 3); // Gives the row of the sub-box
        int yBox = 3 * (j / 3); // Gives the column of the sub-box

        for (int x = xBox; x < xBox + 3; x++) {
            for (int y = yBox; y < yBox + 3; y++) {
                if (grid[x][y] == val)
                    return false;
            }
        }

        return true;
    }

    static boolean SolveSudoku(int grid[][], int i, int j) {

        // If the current row is exhausted, go to next row first column
        if (j == grid.length) {
            i++;
            j = 0;
        }

        // If all the cells have been explored, then we have reached the end. So return
        // true
        if (i == grid.length)
            return true;

        // If current cell is 0, need to place value
        if (grid[i][j] == 0) {
            // There are nine possible values
            for (int val = 1; val <= 9; val++) {
                // Check if placing the value is valid or not
                if (isPlacementValid(grid, i, j, val)) {
                    grid[i][j] = val; // Place the value
                    // Explore next cell
                    if (SolveSudoku(grid, i, j + 1))
                        return true;

                    // If placing the current value in the cell doesn't lead to a solution,
                    // backtrack
                    grid[i][j] = 0; // Revert (BACKTRACK)
                }
            }
        }
        // If current cell is non-zero, skip to next cell
        else {
            return SolveSudoku(grid, i, j + 1);
        }

        return false;
    }

    static boolean SolveSudoku(int grid[][]) {
        return SolveSudoku(grid, 0, 0);
    }

    // Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.printf("%d ", grid[i][j]);
            }
            // System.out.printf("\n");
        }
    }
}