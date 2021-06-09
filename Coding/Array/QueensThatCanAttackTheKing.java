// On an 8x8 chessboard, there can be multiple Black Queens and one White King.

// Given an array of integer coordinates queens that represents the positions of
// the Black Queens, and a pair of coordinates king that represent the position
// of the White King, return the coordinates of all the queens (in any order)
// that can attack the King.

// Leetcode - https://leetcode.com/problems/queens-that-can-attack-the-king/

// Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
// Output: [[0,1],[1,0],[3,3]]
// Explanation:
// The queen at [0,1] can attack the king cause they're in the same row.
// The queen at [1,0] can attack the king cause they're in the same column.
// The queen at [3,3] can attack the king cause they're in the same diagnal.
// The queen at [0,4] can't attack the king cause it's blocked by the queen at
// [0,1].
// The queen at [4,0] can't attack the king cause it's blocked by the queen at
// [1,0].
// The queen at [2,4] can't attack the king cause it's not in the same
// row/column/diagnal as the king.

// Input: queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
// Output: [[2,2],[3,4],[4,4]]

// Time Complexity - O(n + 8*8)
// Space Complexity - O(64)
class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {

        // Map the given queens array to a 2D chess board
        boolean[][] board = new boolean[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]] = true;
        }

        List<List<Integer>> res = new ArrayList<>();

        // For all possible directions where the queen can move
        for (int xCoordinate = -1; xCoordinate <= 1; xCoordinate++) {
            for (int yCoordinate = -1; yCoordinate <= 1; yCoordinate++) {
                // 0,0 is a invalid move, so skip it
                if (xCoordinate == 0 && yCoordinate == 0) {
                    continue;
                }

                // Initialize king's position as x,y
                int x = king[0];
                int y = king[1];

                // Till x and y are within boundary of the chess board
                while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                    // If queen, add to result and break
                    if (board[x][y]) {
                        res.add(Arrays.asList(x, y));
                        break;
                    }
                    // Move to next step by updating x,y
                    x += xCoordinate;
                    y += yCoordinate;
                }
            }
        }

        return res;

    }
}