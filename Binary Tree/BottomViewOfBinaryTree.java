// Given a binary tree, print the bottom view from left to right.
// A node is included in bottom view if it can be seen when we look at the tree
// from bottom.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1#

// Input : 10 20 30 40 60
// Output: 40 20 60 30

class Tree {

    // Function to return a list containing the bottom view of the given tree.
    public ArrayList<Integer> bottomView(Node root) {

        // DO VERTICAL ORDER TRAVERSAL

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        TreeMap<Integer, List<Integer>> hash = new TreeMap<>();

        Queue<Integer> distanceQ = new LinkedList<>();
        Queue<Node> nodeQ = new LinkedList<>();

        distanceQ.add(0);
        nodeQ.add(root);

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

                if (current.left != null) {
                    distanceQ.add(distance - 1);
                    nodeQ.add(current.left);
                }

                if (current.right != null) {
                    distanceQ.add(distance + 1);
                    nodeQ.add(current.right);
                }

            }
        }

        // Add the last element of each list of a distance to res
        for (Map.Entry<Integer, List<Integer>> entry : hash.entrySet()) {
            res.add(entry.getValue().get(entry.getValue().size() - 1));
        }

        return res;
    }
}