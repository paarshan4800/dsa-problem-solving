// Given a binary tree and two node values your task is to find the minimum
// distance between them.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1#

// Input : 20 8 22 4 12 N 25 N N 10 14 , a = 4, b = 14

// Output : 3

class GfG {

    // FIND THE LEASE COMMON ANCESTOR OF THE TWO NODES

    boolean findPath(Node root, int key, List<Node> path) {

        if (root == null)
            return false;

        path.add(root);

        if (root.data == key)
            return true;

        if (findPath(root.left, key, path) || findPath(root.right, key, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;

    }

    int findDist(Node root, int a, int b) {
        if (root == null)
            return -1;

        // Should store the nodes instead of data in the path as tree nodes wont be
        // unique

        List<Node> aPath = new LinkedList<>();
        List<Node> bPath = new LinkedList<>();

        findPath(root, a, aPath);
        findPath(root, b, bPath);

        int i = 0;
        for (i = 0; i < aPath.size() && i < bPath.size(); i++) {
            if (aPath.get(i) != bPath.get(i)) {
                break;
            }
        }

        // Return the sum of remaining nodes in both paths
        return aPath.size() - i + bPath.size() - i;
    }
}
