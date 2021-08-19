// A path in a binary tree is a sequence of nodes where each pair of adjacent
// nodes in the sequence has an edge connecting them. A node can only appear in
// the sequence at most once. Note that the path does not need to pass through
// the root.

// The path sum of a path is the sum of the node's values in the path.

// Given the root of a binary tree, return the maximum path sum of any path.

// Leetcode - https://leetcode.com/problems/binary-tree-maximum-path-sum/

// Input: root = [1,2,3]
// Output: 6
// Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 =
// 6.

// Input: root = [-10,9,20,null,null,15,7]
// Output: 42
// Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7
// = 42.

class Solution {

    int res;

    public int maxPathSumUtil(TreeNode root) {
        // Base case
        if (root == null)
            return 0;

        // Recur left and right
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);

        // Max of left and right subtree
        int maxLeftRight = Math.max(left, right);

        // Four possibilities
        // i) root only
        // ii) root and left
        // iii) root and right
        // iv) root, left and right

        // We return the max of first three to the caller, to extend the path
        // We update the res if any one of the possibilities is greater than res

        int throughRoot = Math.max(root.val, root.val + maxLeftRight);

        int maxAll = Math.max(root.val + left + right, throughRoot);

        res = Math.max(res, maxAll);

        return throughRoot;
    }

    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return res;
    }
}