// Given the root of a binary tree, return the length of the longest path, where
// each node in the path has the same value. This path may or may not pass
// through the root.

// The length of the path between two nodes is represented by the number of
// edges between them.

// Leetcode - https://leetcode.com/problems/longest-univalue-path/

// Input: root = [5,4,5,1,1,5]
// Output: 2

// Input: root = [1,4,5,4,4,5]
// Output: 2

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    // Res as global variable
    int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        findLongestUniqueValuePath(root);
        return res;
    }

    public int findLongestUniqueValuePath(TreeNode root) {

        // Do postorder traversal

        // Base condition
        if (root == null)
            return 0;

        // Recur left and right
        int left = findLongestUniqueValuePath(root.left);
        int right = findLongestUniqueValuePath(root.right);

        int leftEdges = 0, rightEdges = 0;

        // If left child is there and has same val as root, leftEdges becomes left + 1
        if (root.left != null && root.left.val == root.val) {
            leftEdges = (left + 1);
        }

        // If right child is there and has same val as root, rightEdges becomes right +
        // 1
        if (root.right != null && root.right.val == root.val) {
            rightEdges = (right + 1);
        }

        // Update res if leftEdges + rightEdges is greater
        res = Math.max(res, leftEdges + rightEdges);

        return Math.max(leftEdges, rightEdges);

    }
}