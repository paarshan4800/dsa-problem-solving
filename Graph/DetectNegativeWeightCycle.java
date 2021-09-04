// Given a weighted directed graph with n nodes and m edges. Nodes are labeled
// from 0 to n-1, the task is to check if it contains a negative weight cycle or
// not.
// Note: edges[i] is defined as u, v and weight.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1#

// Bellman Ford Algorithm - Single Source Shortest Path
// Time Complexity - O(V * E^2) ==> O(n^3) Worst case (complete graph)

class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        int[] dist = new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;

        // 0 is the starting vertex
        dist[0] = 0;

        // Relax all edges vertices-1 times
        for (int count = 0; count < n - 1; count++) {
            for (int edge = 0; edge < edges.length; edge++) {
                int u = edges[edge][0];
                int v = edges[edge][1];
                int w = edges[edge][2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // If any one of the edge gets relaxed after vertices-1 times, then there is a
        // cycle
        for (int edge = 0; edge < edges.length; edge++) {
            int u = edges[edge][0];
            int v = edges[edge][1];
            int w = edges[edge][2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                dist[v] = dist[u] + w;
                return 1;
            }
        }

        return 0;

    }
}