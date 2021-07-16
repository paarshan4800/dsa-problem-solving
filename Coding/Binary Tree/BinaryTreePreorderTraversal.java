// Given the root of a binary tree, return the preorder traversal of its nodes'
// values.

// Leetcode -
// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/928/

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

    public void preorder(TreeNode root, List<Integer> res) {

        // Base condition
        if (root == null)
            return;

        res.add(root.val); // Process root node
        preorder(root.left, res); // Recur left
        preorder(root.right, res); // Recur right

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        preorder(root, res);
        return res;
    }
}

// Iterative Solution
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null)
            return res;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // Pop and add to res (PROCESS)
            TreeNode temp = stack.pop();
            res.add(temp.val);

            // If right child is there, add it to stack
            if (temp.right != null) {
                stack.push(temp.right);
            }

            // If left child is there, add it to stack
            if (temp.left != null) {
                stack.push(temp.left);
            }

            // First we push right child and then left child to stack because the last
            // pushed element comes out first in stack. We need to process the left child
            // first. So we push the left child after the right child
        }

        return res;
    }
}