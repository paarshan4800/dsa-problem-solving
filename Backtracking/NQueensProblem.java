// The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard
// such that no two queens can attack each other.
// Given an integer n, find all distinct solutions to the n-queens puzzle. Each
// solution contains distinct board configurations of the n-queens’ placement,
// where the solutions are a permutation of [1,2,3..n] in increasing order, here
// the number in the ith place denotes that the ith-column queen is placed in
// the row with that number. For eg below figure represents a chessboard [3 1 4
// 2].

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/n-queen-problem0315/1#

// Input:
// 4
// Output:
// [2 4 1 3 ] [3 1 4 2 ]
// Explaination:
// These are the 2 possible solutions.

// Input:
// 1
// Output:
// [1]
// Explaination:
// Only one queen can be placed
// in the single cell available.

class Solution {

    static boolean isSafe(int[][] board, int row, int col) {
        int i, j;
        int n = board[0].length;

        // Check the current row
        for (j = 0; j < col; j++) {
            if (board[row][j] == 1)
                return false;
        }

        // Check the lower left diagonal
        for (i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check the upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;

    }

    static void nQueen(int[][] board, int col, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
        // If all queens are placed, add to result
        if (col >= board[0].length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int row = 0; row < board[0].length; row++) {
            // If the current cell is safe
            if (isSafe(board, row, col)) {
                // Place the queen and add to current
                board[row][col] = 1;
                cur.add(row + 1);

                // Recur to place next queen
                nQueen(board, col + 1, cur, res);

                // BACKTRACK
                // Remove queen
                board[row][col] = 0;
                cur.remove(cur.size() - 1);
            }
        }

    }

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        int[][] board = new int[n][n];
        nQueen(board, 0, new ArrayList<Integer>(), res);

        return res;
    }
}