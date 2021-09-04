// Given a 2D binary matrix A(0-based index) of dimensions NxM. Find the minimum
// number of steps required to reach from (0,0) to (X, Y).
// Note: You can only move left, right, up and down, and only through cells that
// contain 1.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1#

// Input:
// N=3
// M=4
// A=[[1,0,0,0],
// [1,1,0,1],[0,1,1,1]]
// X=2
// Y=3
// Output:
// 5
// Explanation:
// The shortest path is as follows:
// (0,0)->(1,0)->(1,1)->(2,1)->(2,2)->(2,3).

// Input:
// N=3
// M=4
// A=[[1,1,1,1],
// [0,0,0,1],[0,0,0,1]]
// X=0
// Y=3
// Output:
// 3
// Explanation:
// The shortest path is as follows:
// (0,0)->(0,1)->(0,2)->(0,3).

// Time Complexity - O(M*N)
class Solution {

    class Cell {
        int x;
        int y;
        int dist;

        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    boolean isValidCell(int x, int y, int N, int M) {
        if (x >= 0 && x < N && y >= 0 && y < M)
            return true;

        return false;
    }

    int shortestDistance(int N, int M, int A[][], int X, int Y) {

        if (A[0][0] != 1)
            return -1;

        Queue<Cell> queue = new LinkedList<>();
        queue.add(new Cell(0, 0, 0));

        Cell current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            // If reached destination, return
            if (current.x == X && current.y == Y)
                return current.dist;

            for (int x = -1; x <= 1; x++) {
                for (int y = -1; y <= 1; y++) {
                    if (Math.abs(x) == Math.abs(y))
                        continue;

                    int nextX = current.x + x;
                    int nextY = current.y + y;

                    // If valid cell and not already visited
                    if (isValidCell(nextX, nextY, N, M) && A[nextX][nextY] == 1) {
                        A[nextX][nextY] = 2; // Mark as visited i.e 2
                        queue.add(new Cell(nextX, nextY, current.dist + 1)); // push to queue
                    }
                }
            }
        }

        return -1;
    }
}