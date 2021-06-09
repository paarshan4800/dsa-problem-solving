// Given two integer arrays preorder and inorder where preorder is the preorder
// traversal of a binary tree and inorder is the inorder traversal of the same
// tree, construct and return the binary tree.

// Leetcode -
// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

// Recursive Solution
// Time Complexity - O(n)
// Space Complexity - O(n)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    int preorderIndex = 0;
    HashMap<Integer, Integer> inorderHash = new HashMap<Integer, Integer>();

    // Build an hash map for the inorder traversal array. It helps to reduce the
    // O(n^2) solution to O(n).
    public void buildInorderHash(int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderHash.put(inorder[i], i);
        }
    }

    public TreeNode buildTree(int[] preorder, int left, int right) {

        // Base condition
        if (left > right) {
            return null;
        }

        // Build the root node
        TreeNode root = new TreeNode(preorder[preorderIndex++]);

        root.left = buildTree(preorder, left, inorderHash.get(root.val) - 1);
        root.right = buildTree(preorder, inorderHash.get(root.val) + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        buildInorderHash(inorder);
        return buildTree(preorder, 0, preorder.length - 1);
    }
}