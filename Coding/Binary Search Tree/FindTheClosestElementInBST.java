// Given a BST and an integer. Find the least absolute difference between any
// node value of the BST and the given integer.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1/

class Solution {
    // Function to find the least absolute difference between any node
    // value of the BST and the given integer.
    static int minDiff(Node root, int K) {
        if (root == null)
            return Integer.MAX_VALUE;

        // Find the absolute difference of k and data of root node
        int rootDiff = Math.abs(root.data - K);
        int subtreeDiff;

        // Search for whether key exists in right or left subtree, recur and find the
        // minDiff
        if (K > root.data)
            subtreeDiff = minDiff(root.right, K);

        else
            subtreeDiff = minDiff(root.left, K);

        return Math.min(rootDiff, subtreeDiff);
    }
}
