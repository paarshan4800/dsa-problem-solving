// Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
// check whether it contains any cycle or not.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1

// Using DFS
class Solution {
    // Function to detect cycle in a directed graph.

    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack, int start) {

        visited[start] = true;
        recStack[start] = true; // Add to recursion stack

        for (int i = 0; i < adj.get(start).size(); i++) {
            int v = adj.get(start).get(i);

            if (!visited[v] && dfs(adj, visited, recStack, v)) {
                return true;
            }
            // If the adjacent node is in the recursion stack, then cycle exists
            else if (recStack[v]) {
                return true;
            }

        }

        recStack[start] = false; // Remove from recursion stack
        return false;

    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(adj, visited, recStack, i)) {
                return true;
            }
        }

        return false;
    }
}

// Using Kahn's Algorithm (BFS based) (Topological Sort)
class Solution {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                indegree[adj.get(i).get(j)]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[V];
        int index = 0;

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[index++] = u;

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i);

                indegree[v]--;

                if (indegree[v] == 0)
                    queue.add(v);

            }

            // Increment count by after every node with indegree 0 is processed
            count++;
        }

        // If count != V, cycle exists
        return (count != V) ? true : false;
    }
}