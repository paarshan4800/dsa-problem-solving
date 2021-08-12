// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to
// reach the destination at (N - 1, N - 1). Find all possible paths that the rat
// can take to reach from source to destination. The directions in which the rat
// can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell
// in the matrix represents that it is blocked and rat cannot move to it while
// value 1 at a cell in the matrix represents that rat can be travel through it.
// Note: In a path, no cell can be visited more than one time.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

// Input:
// N = 4
// m[][] = {{1, 0, 0, 0},
// {1, 1, 0, 1},
// {1, 1, 0, 0},
// {0, 1, 1, 1}}
// Output:
// DDRDRR DRDDRR
// Explanation:
// The rat can reach the destination at
// (3, 3) from (0, 0) by two paths - DRDDRR
// and DDRDRR, when printed in sorted order
// we get DDRDRR DRDDRR.

class Solution {

    // Boundary Condition. Check whether the move made is valid or not
    public static boolean isValidCell(int x, int y, int[][] matrix, int N) {
        if (x >= 0 && x < N && y >= 0 && y < N && matrix[x][y] == 1)
            return true;

        return false;
    }

    public static void findPath(int x, int y, String cur, ArrayList<String> res, int[][] matrix, int N) {

        // If move made is incorrect, return (backtrack)
        if (!isValidCell(x, y, matrix, N)) {
            return;
        }

        // If destination is reached, add to result list
        if (x == N - 1 && y == N - 1 && matrix[x][y] == 1) {
            res.add(cur);
            return;
        }

        // Modify the current cell to any other number other 1. To avoid cycles.
        matrix[x][y] = 2;

        // Since lexographically sorted answer is asked, start branching in the order
        // D,L,R,U
        findPath(x + 1, y, cur + "D", res, matrix, N);
        findPath(x, y - 1, cur + "L", res, matrix, N);
        findPath(x, y + 1, cur + "R", res, matrix, N);
        findPath(x - 1, y, cur + "U", res, matrix, N);

        // Update current cell back to 1
        matrix[x][y] = 1;

    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        findPath(0, 0, "", res, m, n);
        return res;
    }
}