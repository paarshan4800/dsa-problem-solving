// Given the root of a Binary Search Tree (BST), convert it to a Greater Tree
// such that every key of the original BST is changed to the original key plus
// sum of all keys greater than the original key in BST.

// Leetcode -
// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

// Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
// Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    int curSum = 0;

    // DO REVERSE INORDER TRAVERSAL
    // So we start from largest number

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return null;
        }

        bstToGst(root.right);

        // Add the curSum to root.val and update curSum
        root.val += curSum;
        curSum = root.val;

        bstToGst(root.left);
        return root;
    }
}