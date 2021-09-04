// Given the root of a binary tree and an integer targetSum, return true if the
// tree has a root-to-leaf path such that adding up all the values along the
// path equals targetSum.

// A leaf is a node with no children.

// Leetcode -
// https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/

// Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
// Output: true

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        // Base condition
        if (root == null)
            return false;

        // If leaf node
        if (root.left == null && root.right == null) {
            // Subtract root.val from targetSum. If 0, required path exists. Return true
            if (targetSum - root.val == 0)
                return true;
            else
                return false;
        }

        // Recur left by reducing the targetSum by root.val
        boolean leftRes = hasPathSum(root.left, targetSum - root.val);

        // Recur right by reducing the targetSum by root.val
        boolean rightRes = hasPathSum(root.right, targetSum - root.val);

        // If any one of the subtrees have the required path, return true
        return leftRes || rightRes;

    }
}