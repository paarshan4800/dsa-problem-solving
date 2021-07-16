// Given two integer arrays inorder and postorder where inorder is the inorder
// traversal of a binary tree and postorder is the postorder traversal of the
// same tree, construct and return the binary tree.

// Leetcode -
// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/942/

// Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
// Output: [3,9,20,null,null,15,7]

class Solution {

    int postorderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder, HashMap<Integer, Integer> hash, int low, int high) {

        // Base condition
        if (low > high)
            return null;

        // Create new node
        TreeNode root = new TreeNode(postorder[postorderIndex--]);

        root.right = buildTree(inorder, postorder, hash, hash.get(root.val) + 1, high);

        root.left = buildTree(inorder, postorder, hash, low, hash.get(root.val) - 1);

        return root;

    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        // Store the elements of inorder traversal with their index in hash for O(1)
        // lookup
        for (int i = 0; i < inorder.length; i++) {
            hash.put(inorder[i], i);
        }

        postorderIndex = postorder.length - 1;

        return buildTree(inorder, postorder, hash, 0, inorder.length - 1);
    }
}