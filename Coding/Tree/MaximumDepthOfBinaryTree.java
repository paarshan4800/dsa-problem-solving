// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path
// from the root node down to the farthest leaf node.

// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/555/

// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// Input: root = [1,null,2]
// Output: 2

// Input: root = []
// Output: 0

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// Recursive Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int maxDepth(TreeNode root) {

        // Base condition
        // root == null contributes zero to the depth
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left); // Recur down the left node
        int rightDepth = maxDepth(root.right);// Recur down the right node

        // Return max(ans from left node, ans from right node) + 1
        return 1 + Math.max(leftDepth, rightDepth);
    }
}

// Iterative Approach
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int maxDepth(TreeNode root) {

        // If root is null
        if (root == null) {
            return 0;
        }

        Stack<StackNode> stack = new Stack<>();
        int res = 1;

        // Push the root and its depth 1 into stack
        stack.push(new StackNode(root, 1));

        // Till stack is not empty
        while (!stack.isEmpty()) {
            // Pop the node to process
            StackNode cur = stack.pop();

            // If leaf node, update res as max(res,current node's depth)
            if (cur.node.left == null && cur.node.right == null) {
                res = Math.max(res, cur.depth);
            }

            // If right child is present, push it into stack with depth as current depth + 1
            if (cur.node.right != null) {
                stack.push(new StackNode(cur.node.right, cur.depth + 1));
            }

            // If left child is present, push it into stack with depth as current depth + 1
            if (cur.node.left != null) {
                stack.push(new StackNode(cur.node.left, cur.depth + 1));
            }

            // First we push the right child and then the left child because we should
            // process the left child first. So popping out now from the stack we get the
            // left child first
        }

        return res;
    }

    class StackNode {
        TreeNode node;
        int depth;

        StackNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
