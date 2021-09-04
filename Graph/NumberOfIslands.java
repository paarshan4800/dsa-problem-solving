// Given an m x n 2D binary grid grid which represents a map of '1's (land) and
// '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands
// horizontally or vertically. You may assume all four edges of the grid are all
// surrounded by water.

// Leetcode - https://leetcode.com/problems/number-of-islands/

// Input: grid = [
// ["1","1","1","1","0"],
// ["1","1","0","1","0"],
// ["1","1","0","0","0"],
// ["0","0","0","0","0"]
// ]
// Output: 1

// Input: grid = [
// ["1","1","0","0","0"],
// ["1","1","0","0","0"],
// ["0","0","1","0","0"],
// ["0","0","0","1","1"]
// ]
// Output: 3

// Using Breadth First Search
class Solution {

    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Coordinate[] directions = { new Coordinate(1, 0), new Coordinate(-1, 0), new Coordinate(0, 1),
            new Coordinate(0, -1) };

    // Helper method to check whether x,y is within the boundaries
    public boolean isValid(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    public void bfs(char[][] grid, int x, int y, int m, int n) {
        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(new Coordinate(x, y));
        grid[x][y] = '2'; // Make the cell as explored

        while (!queue.isEmpty()) {
            Coordinate u = queue.poll();

            for (Coordinate v : directions) {
                int nextX = u.x + v.x;
                int nextY = u.y + v.y;

                // If cell is valid and is an unexplored land
                if (isValid(nextX, nextY, m, n) && grid[nextX][nextY] == '1') {
                    grid[nextX][nextY] = '2'; // Make the cell as explored
                    queue.add(new Coordinate(nextX, nextY));
                }
            }
        }

    }

    public int numIslands(char[][] grid) {

        int res = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j, m, n);
                    res++;
                }
            }
        }

        return res;
    }
}

// Using Depth First Search
class Solution {

    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Coordinate[] directions = { new Coordinate(1, 0), new Coordinate(-1, 0), new Coordinate(0, 1),
            new Coordinate(0, -1) };

    public boolean isValid(int x, int y, int m, int n) {
        if (x >= 0 && x < m && y >= 0 && y < n) {
            return true;
        }
        return false;
    }

    public void dfs(char[][] grid, int x, int y, int m, int n) {
        grid[x][y] = '2';

        for (Coordinate v : directions) {
            int nextX = x + v.x;
            int nextY = y + v.y;

            if (isValid(nextX, nextY, m, n) && grid[nextX][nextY] == '1') {
                dfs(grid, nextX, nextY, m, n);
            }
        }
    }

    public int numIslands(char[][] grid) {

        int res = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    res++;
                }
            }
        }

        return res;
    }
}