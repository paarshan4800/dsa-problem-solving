// Given a Binary Tree, find the vertical traversal of it starting from the
// leftmost level to the rightmost level.
// If there are multiple nodes passing through a vertical line, then they should
// be printed as they appear in level order traversal of the tree.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1#

// Input : 1 2 3 4 5 6 7 N N N N N 8 N 9
// Output:
// 4 2 1 5 6 3 8 7 9

class Solution {

    // Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        // Key is the distance from the root node
        // Value is the list of nodes at that distance
        TreeMap<Integer, List<Integer>> hash = new TreeMap<>();

        // This queue stores the distance
        Queue<Integer> distanceQ = new LinkedList<>();

        // This queue stores the nodes
        Queue<Node> nodeQ = new LinkedList<>();

        // Intially push root node which is at distance 0
        distanceQ.add(0);
        nodeQ.add(root);

        // LEVEL ORDER TRAVERSAL
        while (!nodeQ.isEmpty()) {
            int size = nodeQ.size();

            for (int i = 0; i < size; i++) {
                int distance = distanceQ.poll();
                Node current = nodeQ.poll();

                if (hash.containsKey(distance)) {
                    hash.get(distance).add(current.data);
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(current.data);

                    hash.put(distance, list);
                }

                // When processing left children, distance decreases
                if (current.left != null) {
                    distanceQ.add(distance - 1);
                    nodeQ.add(current.left);
                }

                // When processing right children, distance increases
                if (current.right != null) {
                    distanceQ.add(distance + 1);
                    nodeQ.add(current.right);
                }

            }
        }

        // Iterate hash and add to res
        for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
            for (int val : entry.getValue()) {
                res.add(val);
            }
        }

        return res;
    }
}