// Given the root of a binary tree, return the inorder traversal of its nodes'
// values.

// Leetcode - https://leetcode.com/problems/binary-tree-inorder-traversal

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversal(root, res);
        return res;
    }

    public void inorderTraversal(TreeNode root, List<Integer> res) {
        // Base condition
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, res); // Recur left
        res.add(root.val); // Process node
        inorderTraversal(root.right, res); // Recur right
    }

}

// Iterative Solution
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            // Go down left by pushing nodes to the stack (LEFT)
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // Pop and add to res (PROCESS)
            cur = stack.pop();
            res.add(cur.val);

            // Go down right (RIGHT)
            cur = cur.right;
        }

        return res;
    }

}