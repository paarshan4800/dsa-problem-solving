// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
// in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor
// is defined between two nodes p and q as the lowest node in T that has both p
// and q as descendants (where we allow a node to be a descendant of itself).”

// Leetcode -
// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/932/

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    public boolean findPath(TreeNode root, TreeNode key, List<TreeNode> list) {

        // Base condition
        if (root == null)
            return false;

        // Add root to list i.e current path
        list.add(root);

        // If root is the key, return true
        if (root == key)
            return true;

        // Recur down left child and right child
        if (findPath(root.left, key, list) || findPath(root.right, key, list))
            return true;

        // If both the branches dont have the key, remove the current node i.e root from
        // the path and return false
        list.remove(root);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        List<TreeNode> pList = new LinkedList<>();
        List<TreeNode> qList = new LinkedList<>();

        // Trace out in which path p lies
        findPath(root, p, pList);

        // Trace out in which path q lies
        findPath(root, q, qList);

        // Compare both paths and find the node where they branch differently
        int i = 0;
        for (i = 0; i < pList.size() && i < qList.size(); i++) {
            if (pList.get(i).val != qList.get(i).val)
                break;
        }

        return pList.get(i - 1);
    }
}