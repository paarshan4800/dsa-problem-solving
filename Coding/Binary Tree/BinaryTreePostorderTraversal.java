// Given the root of a binary tree, return the postorder traversal of its nodes'
// values.

// Leetcode -
// https://leetcode.com/explore/learn/card/data-structure-tree/134/traverse-a-tree/930/

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

    public void postorder(TreeNode root, List<Integer> res) {

        // Base condition
        if (root == null)
            return;

        postorder(root.left, res); // Recur left
        postorder(root.right, res); // Recur right
        res.add(root.val); // Process root node

    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;
    }
}

// Iterative Solution
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null)
            return res;

        TreeNode prev = null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode current = stack.peek();

            // If prev == null ==> root of the tree
            // If prev.left == currnet ==> left child
            // If prev.right == current ==> right child
            if (prev == null || prev.left == current || prev.right == current) {

                // If left child is there, push left child to stack
                if (current.left != null)
                    stack.push(current.left);

                // If right child is there, push right child to stack
                else if (current.right != null)
                    stack.push(current.right);

                // If current is a leaf node, pop out from stack and add to res
                else
                    res.add(stack.pop().val);

            }
            // If current.left == prev, it means going up from left child
            else if (current.left == prev) {
                // If right child is there, push right child to stack
                if (current.right != null)
                    stack.push(current.right);

                // If right child is not there, we have also processed the left child, pop out
                // from stack and add to res
                else
                    res.add(stack.pop().val);

            }
            // If current.right == prev, it means going up from right child
            else if (current.right == prev) {
                // we have also processed both the left and right child, pop out from stack and
                // add to res
                res.add(stack.pop().val);
            }

            prev = current; // Update prev
        }

        return res;
    }
}