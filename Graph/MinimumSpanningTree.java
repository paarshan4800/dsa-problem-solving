// Given a weighted, undirected and connected graph of V vertices and E edges.
// The task is to find the sum of weights of the edges of the Minimum Spanning
// Tree.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1#

// Prim's Algorithm
class Solution {
    static int findMin(int[] dist, boolean[] mst) {
        int ret = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < dist.length; i++) {
            if (!mst[i] && dist[i] < min) {
                min = dist[i];
                ret = i;
            }
        }

        return ret;
    }

    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean mst[] = new boolean[V];
        int dist[] = new int[V];

        // Distance of starting vertex is 0. All others is Integer.MAX
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < V - 1; i++) {
            // Find the unprocessed vertex with minimum distance
            int u = findMin(dist, mst);

            // Mark it as processed (Add to MST)
            mst[u] = true;

            // Explore its adjacent vertices
            for (int j = 0; j < adj.get(u).size(); j++) {
                int v = adj.get(u).get(j).get(0);
                int w = adj.get(u).get(j).get(1);

                // If not processed and relaxation is possible, then relax
                if (!mst[v] && w < dist[v]) {
                    dist[v] = w;
                }
            }
        }

        // Sum of the distance array is the minimum cost of the spanning tree
        int sum = 0;
        for (int val : dist)
            sum += val;

        return sum;

    }
}
