// Given a connected undirected graph. Perform a Depth First Traversal of the
// graph.

class Solution {
    // Function to return a list containing the DFS traversal of the graph.

    public void dfsRecur(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, ArrayList<Integer> res) {

        visited[u] = true;
        res.add(u);

        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);

            if (!visited[v]) {
                dfsRecur(adj, v, visited, res);
            }
        }

    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];

        dfsRecur(adj, 0, visited, res);

        return res;
    }
}