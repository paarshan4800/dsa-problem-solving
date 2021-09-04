// The problem is to find shortest distances between every pair of vertices in a
// given edge weighted directed Graph. The Graph is represented as adjancency
// matrix, and the matrix denotes the weight of the edegs (if it exists) else
// -1. Do it in-place.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1#

// Input: matrix = {{0,1,43},{1,0,6},{-1,-1,0}}
// Output: {{0,1,7},{1,0,6},{-1,-1,0}}
// Explanation: We can reach 3 from 1 as 1->2->3
// and the cost will be 1+6=7 which is less than
// 43.

// Can also run Djikstra Algorithm or Bellman Ford Algorithm(Single source shortest path) for each vertex 

// Floyd Warshall Algorithm
// Time Complexity - O(V^3)
class Solution {
    public void shortest_distance(int[][] matrix) {

        // If no egde, its given as -1. Change it to INT_MAX
        for (int u = 0; u < matrix.length; u++) {
            for (int v = 0; v < matrix[u].length; v++) {
                if (matrix[u][v] == -1)
                    matrix[u][v] = Integer.MAX_VALUE;
            }
        }

        for (int k = 0; k < matrix.length; k++) {
            for (int u = 0; u < matrix.length; u++) {
                for (int v = 0; v < matrix[u].length; v++) {
                    // If kth row or kth column or diagonal, skip
                    if (u == v || u == k || v == k)
                        continue;

                    // If there is no edge between either (u,k) or (k,v), skip
                    if (matrix[u][k] == Integer.MAX_VALUE || matrix[k][v] == Integer.MAX_VALUE)
                        continue;

                    // Relaxation
                    matrix[u][v] = Math.min(matrix[u][v], matrix[u][k] + matrix[k][v]);
                }
            }
        }

        // Change INT_MAX back to -1
        for (int u = 0; u < matrix.length; u++) {
            for (int v = 0; v < matrix[u].length; v++) {
                if (matrix[u][v] == Integer.MAX_VALUE)
                    matrix[u][v] = -1;
            }
        }

    }
}