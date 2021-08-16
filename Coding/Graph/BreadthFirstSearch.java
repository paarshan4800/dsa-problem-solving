// Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.

// Time Complexity - O(V+E)
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();

        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        // Add the starting node to the queue and mark it as visited
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            // Remove the node from front of the queue and add it to res
            int current = queue.poll();
            res.add(current);

            // Process the adjacent nodes of the popped node
            for (int i = 0; i < adj.get(current).size(); i++) {
                int v = adj.get(current).get(i);
                // If not visited yet ,add it to the queue and mark it as visited
                if (!visited[v]) {
                    queue.add(v);
                    visited[v] = true;
                }
            }
        }

        return res;
    }
}