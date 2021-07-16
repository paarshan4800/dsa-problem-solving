// Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.

// Time Complexity - O(V+E)
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            res.add(current);

            for (int i = 0; i < adj.get(current).size(); i++) {
                int v = adj.get(current).get(i);
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

        return res;
    }
}