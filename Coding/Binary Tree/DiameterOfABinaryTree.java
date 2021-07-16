// Given a Binary Tree, find diameter of it.
// The diameter of a tree is the number of nodes on the longest path between two
// end nodes in the tree

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1#

// Input - 10 20 30 40 60 N N N 50 N 70
// Output - 5

// Time Complexity - O(n^2) Since height of tree is computed at every recursion
// Space Complexity - O(1)
class Solution {

    // Helper method to find height
    public int findHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    int diameter(Node root) {
        if (root == null)
            return 0;

        // The diameter of tree with root as root is the maximum of three possibilites
        // d1 -> Longest between leaf nodes going through the root
        // d2 -> Diameter of left subtree
        // d3 -> Diameter of right subtree
        int d1 = 1 + findHeight(root.left) + findHeight(root.right);
        int d2 = diameter(root.left);
        int d3 = diameter(root.right);

        return Math.max(d1, Math.max(d2, d3));
    }
}

// Better Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
// Compute the height of all nodes and store it in a hash

// Efficient Approach
// Time Complexity - O(n)
// Space Complexity - O(1)

class Solution {
    // Intuition - Diameter of a node is 1 + height of left subtree + height of
    // right subtree

    int res = 0;

    // Modify find heigth method
    public int findHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        // Update res if diameter is greater than res
        res = Math.max(res, 1 + leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    int diameter(Node root) {
        if (root == null)
            return 0;

        findHeight(root);

        return res;

    }
}