// Given a binary tree root, the task is to return the maximum sum of all keys
// of any sub-tree which is also a Binary Search Tree (BST).

// Leetcode - https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/

// Input: root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
// Output: 20
// Explanation: Maximum sum in a valid Binary search tree is obtained in root
// node with key equal to 3.

// Input : [4,8,null,6,1,9,null,-5,4,null,null,null,-3,null,10]
// Output : 14

// Similar to Largest BST Problem

class Solution {

    int res = 0;

    class BSTInfo {
        int sum;
        int min;
        int max;

        public BSTInfo(int sum, int min, int max) {
            this.sum = sum;
            this.min = min;
            this.max = max;
        }
    }

    public BSTInfo findMaxSumBST(TreeNode root) {

        if (root == null) {
            return new BSTInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BSTInfo left = findMaxSumBST(root.left);
        BSTInfo right = findMaxSumBST(root.right);

        if (left == null || right == null) {
            return null;
        }

        if (root.val <= left.max || root.val >= right.min) {
            return null;
        }

        // Update res if the tree with root as root is BST
        res = Math.max(res, root.val + left.sum + right.sum);

        return new BSTInfo(root.val + left.sum + right.sum, Math.min(left.min, root.val),
                Math.max(right.max, root.val));

    }

    public int maxSumBST(TreeNode root) {
        findMaxSumBST(root);
        return res;
    }
}