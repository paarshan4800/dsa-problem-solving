// Given an undirected graph with V vertices and E edges, check whether it
// contains any cycle or not.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1#

// Using DFS
class Solution {
    // Function to detect cycle in an undirected graph.

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int parent, int u, boolean[] visited) {

        visited[u] = true;

        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            // If not visited and dfs returns true, cycle exists
            if (!visited[v]) {
                if (dfs(adj, u, v, visited) == true) {
                    return true;
                }
            }
            // If visited and adjacent node is same as current node's parent, then cycle
            // exists
            else if (v != parent) {
                return true;
            }
        }

        return false;

    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        // This covers disconnected components also
        for (int i = 0; i < V; i++) {
            // If not visited and dfs returns true, then cycle exists
            if (!visited[i] && dfs(adj, -1, i, visited) == true) {
                return true;
            }
        }

        return false;
    }
}

// Using BFS
class Solution {

    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] visited, int V) {

        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[V]; // stores the parent of a node

        queue.add(start);
        visited[start] = true;
        parent[start] = -1;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int i = 0; i < adj.get(u).size(); i++) {

                int v = adj.get(u).get(i);
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                    parent[v] = u;
                } else if (v != parent[u]) {
                    return true;
                }
            }
        }

        return false;

    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && bfs(adj, i, visited, V) == true) {
                return true;
            }
        }

        return false;
    }
}