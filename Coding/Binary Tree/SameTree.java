// Given the roots of two binary trees p and q, write a function to check if
// they are the same or not.

// Two binary trees are considered the same if they are structurally identical,
// and the nodes have the same value.

// Leetcode - https://leetcode.com/problems/same-tree/

// Input: p = [1,2,3], q = [1,2,3]
// Output: true

// Input: p = [1,2], q = [1,null,2]
// Output: false

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    // PREORDER TRAVERSAL

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // If both are null, return true
        if (p == null && q == null)
            return true;

        // If any one of them null, return false
        if (p == null || q == null)
            return false;

        // Check val
        if (p.val != q.val)
            return false;

        // Recur left and right
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }
}