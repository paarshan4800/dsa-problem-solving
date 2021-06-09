// Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.

// Leetcode - https://leetcode.com/problems/kth-smallest-element-in-a-bst/

// Input: root = [3,1,4,null,2], k = 1
// Output: 1

// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */

// Iterative Inorder Traversal
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // In processing step, after k-- check if k == 0
            cur = stack.pop();
            k--;

            if (k == 0) {
                return cur.val;
            }

            cur = cur.right;
        }

        return -1;

    }
}