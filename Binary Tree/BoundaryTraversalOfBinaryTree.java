// Given a Binary Tree, find its Boundary Traversal. The traversal should be in
// the following order:

// Left boundary nodes: defined as the path from the root to the left-most node
// ie- the leaf node you could reach when you always travel preferring the left
// subtree over the right subtree.
// Leaf nodes: All the leaf nodes except for the ones that are part of left or
// right boundary.
// Reverse right boundary nodes: defined as the path from the right-most node to
// the root. The right-most node is the leaf node you could reach when you
// always travel preferring the right subtree over the left subtree. Exclude the
// root from this as it was already included in the traversal of left boundary
// nodes.
// Note: If the root doesn't have a left subtree or right subtree, then the root
// itself is the left or right boundary.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1#

// Input : 20 8 22 4 12 N 25 N N 10 14
// Output: 20 8 4 10 14 25 22

class Solution {

    // Print all left boundary nodes (doesnt include leaf nodes)
    void printLeft(Node root, ArrayList<Integer> res) {

        // Base condition
        if (root == null)
            return;

        // If left child is there, add it to res and recur left
        if (root.left != null) {
            res.add(root.data);
            printLeft(root.left, res);
        }
        // If the above condition fails, then root doesnt have left child. If it has a
        // right child, then root falls in the left boundary. Add it to res and recur
        // right
        else if (root.right != null) {
            res.add(root.data);
            printLeft(root.right, res);
        }

        // If both left and right child are not there, it is not a left boundary node.
    }

    // Print all right boundary nodes (doesnt include leaf nodes)
    void printRight(Node root, ArrayList<Integer> res) {

        // Base condition
        if (root == null)
            return;

        // If right child is there, first recur right and then add it to res (Since they
        // have asked the reverse order of right boundary elements)
        if (root.right != null) {
            printRight(root.right, res);
            res.add(root.data);
        }
        // If the above condition fails, then root doesnt have right child. If it has a
        // left child, then root falls in the right boundary. first recur left and then
        // add it to res (Since they
        // have asked the reverse order of right boundary elements)
        else if (root.left != null) {
            printRight(root.left, res);
            res.add(root.data);
        }

        // If both left and right child are not there, it is not a left boundary node.
    }

    // Print all leaf nodes
    void printLeaf(Node root, ArrayList<Integer> res) {

        // PREORDER TRAVERSAL

        // Base condition
        if (root == null)
            return;

        // If leaf node, add to res
        if (root.left == null && root.right == null) {
            res.add(root.data);
            return;
        }

        // Recur left and right
        printLeaf(root.left, res);
        printLeaf(root.right, res);
    }

    ArrayList<Integer> printBoundary(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        res.add(root.data);

        printLeft(root.left, res);

        printLeaf(root, res);

        printRight(root.right, res);

        return res;
    }
}
