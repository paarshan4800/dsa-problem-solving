// Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. Find the order of characters in the alien language.
// Note: Many orders may be possible for a particular test case, thus you may return any valid order and output will be 1 if the order of string returned by the function is correct else 0 denoting incorrect string returned.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/alien-dictionary/1#

// Input: 
// N = 5, K = 4
// dict = {"baa","abcd","abca","cab","cad"}
// Output:
// 1
// Explanation:
// Here order of characters is 
// 'b', 'd', 'a', 'c' Note that words are sorted 
// and in the given language "baa" comes before 
// "abcd", therefore 'b' is before 'a' in output.
// Similarly we can find other orders.

// Input: 
// N = 3, K = 3
// dict = {"caa","aaa","aab"}
// Output:
// 1
// Explanation:
// Here order of characters is
// 'c', 'a', 'b' Note that words are sorted
// and in the given language "caa" comes before
// "aaa", therefore 'c' is before 'a' in output.
// Similarly we can find other orders.

// Time Complexity - (number of words * number of characters)
class Solution {
    public String topologicalSort(ArrayList<ArrayList<Integer>> adj) {

        int[] indegree = new int[adj.size()];

        for (int u = 0; u < adj.size(); u++) {
            for (int v = 0; v < adj.get(u).size(); v++) {
                indegree[adj.get(u).get(v)]++;
            }
        }

        StringBuilder res = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            char cur = (char) ('a' + u);
            res.append(cur);

            for (int i = 0; i < adj.get(u).size(); i++) {
                int v = adj.get(u).get(i);

                indegree[v]--;

                if (indegree[v] == 0)
                    queue.add(v);
            }
        }

        return res.toString();
    }

    public void addEdge(ArrayList<ArrayList<Integer>> adj, char u, char v) {
        adj.get(u - 'a').add(v - 'a');
    }

    public ArrayList<ArrayList<Integer>> buildGraph(String[] words, int V) {

        // Each node will represent each character (V characters)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        // Process two words at a time in the order they have given
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                // Draw am edge between the first two characters which are not matching
                if (word1.charAt(j) != word2.charAt(j)) {
                    addEdge(adj, word1.charAt(j), word2.charAt(j));
                    break;
                }
            }
        }

        return adj;

    }

    public String findOrder(String[] dict, int N, int K) {
        // Build a graph
        ArrayList<ArrayList<Integer>> adj = buildGraph(dict, K);

        // Run topological sort to get the order
        return topologicalSort(adj);

    }
}