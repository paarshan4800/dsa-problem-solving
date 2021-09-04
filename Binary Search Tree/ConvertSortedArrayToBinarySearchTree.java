// Given an integer array nums where the elements are sorted in ascending order,
// convert it to a height-balanced binary search tree.

// A height-balanced binary tree is a binary tree in which the depth of the two
// subtrees of every node never differs by more than one.

// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/631/

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    // Find mid given low and high
    public int findMid(int low, int high) {
        return low + (high - low) / 2; // To prevent integer overflow
    }

    public TreeNode createBST(int[] nums, int low, int high) {

        // Base condition
        if (low > high) {
            return null;
        }

        int mid = findMid(low, high);

        // Middle element is the root node.
        TreeNode root = new TreeNode(nums[mid]);

        // To find the left child, recur down with elements left of the middle (low,
        // mid-1)
        root.left = createBST(nums, low, mid - 1);

        // To find the right child, recur down with elements right of the middle
        // (mid+1,high)
        root.right = createBST(nums, mid + 1, high);

        return root; // return the root node

    }

    public TreeNode sortedArrayToBST(int[] nums) {

        // Given a sorted array, use binary search recursive approach.
        return createBST(nums, 0, nums.length - 1);
    }
}