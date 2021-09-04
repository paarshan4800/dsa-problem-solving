// Given a weighted, undirected and connected graph of V vertices and E edges,
// Find the shortest distance of all the vertex's from the source vertex S.
// Note: The Graph doesn't contain any negative weight cycle.

// INPUT FORMAT - [
// [[1, 1], [2, 6]],
// [[0, 1], [2, 3]],
// [[1, 3], [0, 6]]
// ]

// [u1, u2, u3]
// u1 -> [[adjacent node, weight],[adjacent node, weight]]

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1#

class Solution {
    // Function to find the shortest distance of all the vertices
    // from the source vertex S.

    static int findIndexOfMinimumDistance(int[] dist, boolean[] processed) {
        int minIndex = 0;
        int minDist = Integer.MAX_VALUE;

        // Find the unprocessed node with the least distance
        for (int i = 0; i < dist.length; i++) {
            if (!processed[i] && dist[i] < minDist) {
                minDist = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {

        int[] dist = new int[V];

        boolean[] processed = new boolean[V];

        for (int i = 0; i < dist.length; i++)
            dist[i] = Integer.MAX_VALUE;

        // Update distance of source vertex to 0
        dist[S] = 0;

        // For the remaining V-1 vertices (excluding source)
        for (int count = 0; count < V - 1; count++) {
            // Find u
            int u = findIndexOfMinimumDistance(dist, processed);

            // Mark u as processed
            processed[u] = true;

            // Process its adjacent nodes
            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i).get(0);
                int w = adj.get(u).get(i).get(1);

                // If adjancent node is not yet processed and weight of the edge is not equal to
                // zero and relaxation is possible, then relax
                // RELAXATION ---> If dist[u] + w < dist[v], then dist[v] = dist[u] + w
                if (!processed[v] && w != 0 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist;
    }
}
