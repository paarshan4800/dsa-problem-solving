// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, Find the number of strongly connected components in the graph.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1#

// Time Complexity - O(V+E)
class Solution {
    // Function to find number of strongly connected components in the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int u, Stack<Integer> stack) {
        visited[u] = true;

        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if (!visited[v]) {
                dfs(adj, visited, v, stack);
            }
        }

        stack.push(u);
    }

    public void dfsRev(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int u) {
        visited[u] = true;

        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if (!visited[v]) {
                dfsRev(adj, visited, v);
            }
        }

    }

    public ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();

        // Create V vertices
        for (int u = 0; u < V; u++)
            revAdj.add(new ArrayList<Integer>());

        // reverse each edge
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < adj.get(u).size(); v++) {
                revAdj.get(adj.get(u).get(v)).add(u);
            }
        }

        return revAdj;
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {

        // Step 1 -> DFS
        // Run topological sort using DFS stack
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(adj, visited, i, stack);
        }

        // Step 2 -> Reverse edges of graph
        ArrayList<ArrayList<Integer>> revAdj = reverseGraph(adj, V);

        // Step 3 -> Run DFS on reversed graph

        // Reset visited array to false
        Arrays.fill(visited, false);

        int res = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!visited[u]) {
                dfsRev(revAdj, visited, u);
                res++;
            }
        }

        return res;
    }
}
