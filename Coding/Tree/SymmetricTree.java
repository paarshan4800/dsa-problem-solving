// Given the root of a binary tree, check whether it is a mirror of itself
// (i.e., symmetric around its center)

// Leetcode - https://leetcode.com/problems/symmetric-tree/

// Input: root = [1,2,2,3,4,4,3]
// Output: true

// Input: root = [1,2,2,null,3,null,3]
// Output: false

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// Recursive Approach
class Solution {

    public boolean isSymmetric(TreeNode root1, TreeNode root2) {
        // If both are null, they are the same
        if (root1 == null && root2 == null) {
            return true;
        }

        // If any one is null, they are not the same
        if (root1 == null || root2 == null) {
            return false;
        }

        // If both are not equal, return false
        if (root1.val != root2.val) {
            return false;
        }

        // Recur
        return isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
    }

    public boolean isSymmetric(TreeNode root) {

        // Split as two seperate trees (left and right)
        return isSymmetric(root.left, root.right);
    }
}

// Iterative Approach
class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.push(new StackNode(root.left, root.right));

        while (!stack.isEmpty()) {
            StackNode cur = stack.pop();

            if (cur.node1 == null && cur.node2 == null) {
                continue;
            }

            if (cur.node1 == null || cur.node2 == null) {
                return false;
            }

            if (cur.node1.val != cur.node2.val) {
                return false;
            }

            stack.push(new StackNode(cur.node1.left, cur.node2.right));
            stack.push(new StackNode(cur.node1.right, cur.node2.left));
        }

        return true;
    }

    class StackNode {
        TreeNode node1;
        TreeNode node2;

        StackNode(TreeNode node1, TreeNode node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }
}