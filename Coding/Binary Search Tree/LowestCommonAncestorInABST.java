// Given a Binary Search Tree (with all values unique) and two node values. Find
// the Lowest Common Ancestors of the two nodes in the BST.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1/

// Normal Approach
// Find LCA by finding paths of both the keys
// Time Complexity - O(n)

// Efficient Approach
// Make use of BST properties
// Time Complexity - O(h)

class BST {
    // Function to find the lowest common ancestor in a BST.
    Node LCA(Node root, int n1, int n2) {
        // Base condition
        if (root == null)
            return null;

        // If both n1 and n2 are greater than root (both n1 and n2 lie on the right
        // subtree), then recur right
        if (n1 > root.data && n2 > root.data)
            return LCA(root.right, n1, n2);

        // If both n1 and n2 are lesser than root (both n1 and n2 lie on the left
        // subtree), then recur left
        else if (n1 < root.data && n2 < root.data)
            return LCA(root.left, n1, n2);

        // If one lies on the left subtree and another one on the right subtree, then
        // there is a branch happening. So the current root is the least common ancestor
        // of n1 and n2

        return root;
    }

}