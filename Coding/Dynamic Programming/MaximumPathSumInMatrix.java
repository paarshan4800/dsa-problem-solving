// Given a NxN matrix of positive integers. There are only three possible moves
// from a cell Matrix[r][c].

// Matrix [r+1] [c]
// Matrix [r+1] [c-1]
// Matrix [r+1] [c+1]
// Starting from any column in row 0 return the largest sum of any of the paths
// up to row N-1.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1/

// Input: N = 2
// Matrix = {{348, 391},
// {618, 193}}
// Output: 1009
// Explaination: The best path is 391 -> 618.
// It gives the sum = 1009.

class Solution {

    static class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int maximumPath(int N, int Matrix[][]) {
        int[][] dp = new int[N][N];
        Coordinate[] coordinates = { new Coordinate(-1, 0), new Coordinate(-1, 1), new Coordinate(-1, -1) };

        for (int j = 0; j < N; j++)
            dp[0][j] = Matrix[0][j];

        // For cell i,j --> the result is Matrix[i][j] +
        // Math.max(dp[i-1][j],dp[i-1][j+1],dp[i-1][j-1]);
        // Comes from top left, top and top right
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = 0;

                for (Coordinate coordinate : coordinates) {
                    int nextI = i + coordinate.x;
                    int nextJ = j + coordinate.y;

                    if (nextI < 0 || nextI >= N || nextJ < 0 || nextJ >= N)
                        continue;

                    temp = Math.max(temp, Matrix[i][j] + dp[nextI][nextJ]);
                }

                dp[i][j] = temp;
            }
        }

        int res = 0;
        for (int j = 0; j < N; j++)
            res = Math.max(res, dp[N - 1][j]);

        return res;
    }
}