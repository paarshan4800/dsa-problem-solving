// Given a Directed Graph with V vertices and E edges, Find any Topological
// Sorting of that Graph.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/topological-sort/1/

// Using BFS (Kahn's Algorithm)
class Solution {
    // Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        // Find the indegree of each vertex
        int[] indegree = new int[V];
        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[V];
        int index = 0;

        // Add vertices with indegree of 0 to the queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[index++] = u;

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i);

                // Decrement indegree of v by 1
                indegree[v]--;

                // If indegree of v is 0, add to the queue
                if (indegree[v] == 0)
                    queue.add(v);

            }

        }

        return res;
    }
}

// Using DFS
class Solution {
    // Function to return list containing vertices in Topological order.

    static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, Stack<Integer> stack) {

        visited[u] = true;

        // Explore all dependenices
        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if (!visited[v]) {
                dfs(adj, v, visited, stack);
            }
        }

        // After exploring all dependencies, push u into stack
        stack.push(u);

    }

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, stack);
            }
        }

        int[] res = new int[V];
        int index = 0;

        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }

        return res;
    }
}
