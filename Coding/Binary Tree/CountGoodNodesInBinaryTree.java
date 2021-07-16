// Given a binary tree root, a node X in the tree is named good if in the path
// from root to X there are no nodes with a value greater than X.

// Return the number of good nodes in the binary tree.

// Leetcode - https://leetcode.com/problems/count-good-nodes-in-binary-tree/

// Input: root = [3,1,4,3,null,1,5]
// Output: 4
// Explanation : Root Node (3) is always a good node.
// Node 4 -> (3,4) is the maximum value in the path starting from the root.
// Node 5 -> (3,4,5) is the maximum value in the path
// Node 3 -> (3,1,3) is the maximum value in the path.

class Solution {

    // PREORDER TRAVERSAL

    public int goodNodes(TreeNode root, int prevMax) {

        if (root == null)
            return 0;

        // New max is passed to the next recursion.
        int newMax = (root.val > prevMax) ? root.val : prevMax;

        // Get result from left subtree
        int left = goodNodes(root.left, newMax);

        // Get result from right subtree
        int right = goodNodes(root.right, newMax);

        return
        // If current node val >= prevMax, include current node also
        (root.val >= prevMax) ? 1 + left + right : left + right;

    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
}