// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// Leetcode - https://leetcode.com/problems/validate-binary-search-tree/

// Input: root = [2,1,3]
// Output: true

// Input: root = [5,1,4,null,null,3,6]
// Output: false

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// Recursive Approach
class Solution {

    public boolean validateBST(TreeNode root, Integer low, Integer high) {

        // PREORDER TRAVERSAL
        // Process -> Recur Left -> Recur Right

        // Empty node is a valid BST (Base Condition)
        if (root == null) {
            return true;
        }

        // root.val <= low ----> left child > root contradicts
        // root.val >= high ---> right child < root contradicts
        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        // Recur down the left and right child by updating their limits
        // Recurring left child should have limits (low,root val)
        // Recurring right child should have limits (root val,high)
        return validateBST(root.left, low, root.val) && validateBST(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        // Use min and max limits (at the beginning they are null)
        // validate the root node with limits (null,null)
        return validateBST(root, null, null);

    }
}

// Iterative Solution
class Solution {
    public boolean isValidBST(TreeNode root) {

        // PREORDER TRAVERSAL

        // Empty node is a valid BST
        if (root == null) {
            return true;
        }

        Stack<StackNode> stack = new Stack<>();

        // Push the root node with limits (null,null) into the stack
        stack.push(new StackNode(root, null, null));

        // Till stack isn't empty
        while (!stack.isEmpty()) {
            // Pop and process
            StackNode cur = stack.pop();

            // Process
            if ((cur.low != null && cur.node.val <= cur.low) || (cur.high != null && cur.node.val >= cur.high)) {
                return false;
            }

            // Push right child into stack with updated limits
            if (cur.node.right != null) {
                stack.push(new StackNode(cur.node.right, cur.node.val, cur.high));
            }

            // Push left child into stack with updated limits
            if (cur.node.left != null) {
                stack.push(new StackNode(cur.node.left, cur.low, cur.node.val));
            }
        }

        return true;
    }

    class StackNode {
        TreeNode node;
        Integer low;
        Integer high;

        StackNode(TreeNode node, Integer low, Integer high) {
            this.node = node;
            this.low = low;
            this.high = high;
        }
    }
}