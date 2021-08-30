// Given a square grid of size N, each cell of which contains integer cost which
// represents a cost to traverse through that cell, we need to find a path from
// top left cell to bottom right cell by which the total cost incurred is
// minimum.
// From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).

// Note: It is assumed that negative cost cycles do not exist in the input
// matrix.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-cost-path3833/1/

// Input: grid = {{9,4,9,9},{6,7,6,4},
// {8,3,3,7},{7,4,9,10}}
// Output: 43
// Explanation: The grid is-
// 9 4 9 9
// 6 7 6 4
// 8 3 3 7
// 7 4 9 10
// The minimum cost is-
// 9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.

// Greedy or Dynamic Programming Approach wont work
// Use Djikstra's Algorithm considering each cell in the matrix as a graph node

class Solution {
    // Function to return the minimum cost to react at bottom
    // right cell from top left cell.

    class Cell {
        int x;
        int y;
        int distance;

        Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public boolean isValid(int i, int j, int n) {
        if (i < 0 || i >= n || j < 0 || j >= n)
            return false;

        return true;
    }

    // To find the node with minimum distance, use minHeap to improve time
    // complexity from O(n^2)
    public class SortByDistance implements Comparator<Cell> {
        public int compare(Cell a, Cell b) {
            return a.distance - b.distance;
        }
    }

    public int minimumCostPath(int[][] grid) {
        int dx[] = { 1, 0, -1, 0 };
        int dy[] = { 0, -1, 0, 1 };

        int dist[][] = new int[grid.length][grid.length];

        for (int[] arr : dist)
            Arrays.fill(arr, Integer.MAX_VALUE);

        // Distance of the starting node
        dist[0][0] = grid[0][0];

        PriorityQueue<Cell> minHeap = new PriorityQueue<>(new SortByDistance());

        // Push the starting node to the minHeap
        minHeap.add(new Cell(0, 0, dist[0][0]));

        while (!minHeap.isEmpty()) {

            Cell u = minHeap.poll();

            // Check all four possible directions
            for (int i = 0; i < 4; i++) {
                int nextX = u.x + dx[i];
                int nextY = u.y + dy[i];

                // If the cell is valid
                if (isValid(nextX, nextY, grid.length)) {

                    // Check if relaxation is possible
                    if (u.distance + grid[nextX][nextY] < dist[nextX][nextY]) {

                        // If already visited, remove from minHeap and the node with the relaxed value
                        // into the minHeap
                        if (dist[nextX][nextY] != Integer.MAX_VALUE) {
                            minHeap.remove(new Cell(nextX, nextY, dist[nextX][nextY]));
                        }

                        dist[nextX][nextY] = u.distance + grid[nextX][nextY];
                        minHeap.add(new Cell(nextX, nextY, dist[nextX][nextY]));
                    }
                }
            }
        }

        return dist[grid.length - 1][grid.length - 1];
    }
}