// Given an array of lowercase strings A[] of size N, determine if the strings
// can be chained together to form a circle.
// A string X can be chained together with another string Y if the last
// character of X is same as first
// character of Y. If every string of the array can be chained, it will form a
// circle.

// For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer
// will be Yes as the given strings can be chained as "for", "rig", "geek" and
// "kaf"

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1#

// Input:
// N = 3
// A[] = { "abc", "bcd", "cdf" }
// Output:
// 0
// Explaination:
// These strings can't form a circle
// because no string has 'd'at the starting index.

// Input:
// N = 4
// A[] = { "ab" , "bc", "cd", "da" }
// Output:
// 1
// Explaination:
// These strings can form a circle
// of strings.

// For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer
// will be Yes as the given strings can be chained as "for", "rig", "geek" and
// "kaf"

class Solution {

    // The idea is to create a directed graph of all characters and then find if
    // their is an eulerian circuit in the graph or not.

    // If there is an eulerian circuit, then chain can be formed, otherwise not.

    // Note that a directed graph has eulerian circuit only if in degree and out
    // degree of every vertex is same, and all non-zero degree vertices form a
    // single strongly connected component.

    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int u) {
        visited[u] = true;

        for (int i = 0; i < adj.get(u).size(); i++) {
            int v = adj.get(u).get(i);
            if (!visited[v]) {
                dfs(adj, visited, v);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> reverseGraph(ArrayList<ArrayList<Integer>> adj, int V) {
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

    static boolean isASingleStronglyConnectedComponent(ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[26];
        int start = 0;

        // Find the vertex which hash outdegree > 0
        for (int i = 0; i < 26; i++) {
            if (adj.get(i).size() > 0) {
                start = i;
                break;
            }
        }

        // Run dfs with the above start vertex
        dfs(adj, visited, start);

        // Check if all the vertices with outdegree > 0 are marked visited or not
        for (int i = 0; i < visited.length; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;
            }
        }

        // Reverse edges of graph
        ArrayList<ArrayList<Integer>> revAdj = reverseGraph(adj, 26);

        // Reset visited array to false
        Arrays.fill(visited, false);

        // Run DFS on reversed graph with the same start vertex
        dfs(revAdj, visited, start);

        // Check if all the vertices with outdegree > 0 are marked visited or not
        for (int i = 0; i < visited.length; i++) {
            if (adj.get(i).size() > 0 && !visited[i]) {
                return false;
            }
        }

        return true;
    }

    static boolean hasSameDegrees(ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[26];

        for (int u = 0; u < adj.size(); u++) {
            for (int v = 0; v < adj.get(u).size(); v++) {
                indegree[adj.get(u).get(v)]++;
            }
        }

        // adj.get(i).size() is the outdegree of vertex i
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] != adj.get(i).size())
                return false;
        }

        return true;
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, char u, char v) {
        adj.get(u - 'a').add(v - 'a');
    }

    static ArrayList<ArrayList<Integer>> buildGraph(String A[]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(26);

        for (int i = 0; i < 26; i++)
            adj.add(new ArrayList<>());

        for (String word : A) {
            addEdge(adj, word.charAt(0), word.charAt(word.length() - 1));
        }

        return adj;
    }

    static int isCircle(int N, String A[]) {
        // Build a graph
        ArrayList<ArrayList<Integer>> adj = buildGraph(A);

        // The graph should be a single strongly connected component and the indegree
        // and outdegree of all the vertices should be the same
        boolean isSSCC = isASingleStronglyConnectedComponent(adj);
        boolean sameDegree = hasSameDegrees(adj);

        return (isSSCC && sameDegree) ? 1 : 0;
    }
}