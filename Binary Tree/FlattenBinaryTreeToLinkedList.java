// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child
// pointer points to the next node in the list and the left child pointer is
// always null.
// The "linked list" should be in the same order as a pre-order traversal of the
// binary tree.

// Leetcode - https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    // INORDER TRAVERSAL

    public void flatten(TreeNode root) {

        if (root == null)
            return;

        // If leaf node, return
        if (root.left == null && root.right == null)
            return;

        // If left child is there, we need to move it to the root.right
        // If left child is not there, leave it as it is
        if (root.left != null) {

            // Recur left
            flatten(root.left);

            // Store root.right in temp. Move root.left to root.right. Make root.left null
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;

            // Traverse the right child of root, till iterator doesnt have a right child
            TreeNode it = root.right;

            while (it.right != null)
                it = it.right;

            // Set the iterator's right child as temp
            it.right = temp;

        }

        // Recur right
        flatten(root.right);

    }
}

// Another Approach
class Solution {

    // REVERSED PREORDER TRAVERSAL

    TreeNode prev = null;

    public void flatten(TreeNode root) {

        // Base condition
        if (root == null)
            return;

        // Recur down right
        flatten(root.right);

        // Recur down left
        flatten(root.left);

        // Set root.right as prev (previously processed node)
        // For the rightmost node, prev would be null. So prev.right would be nothing

        // For the rightmost node's sibling, prev would be rightmost node. So rightmost
        // node would be copied to its sibling's right.

        // For the parent of these two nodes, prev would be left child whose right child
        // has contents of parent's right child also. So set parent's right as prev and
        // clear left child to null

        root.right = prev;
        root.left = null;
        prev = root;

    }
}