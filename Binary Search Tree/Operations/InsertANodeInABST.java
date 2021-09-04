// Given a BST and a key K. If K is not present in the BST, Insert a new Node
// with a value equal to K into the BST.
// Note: If K is already present in the BST, don't modify the BST.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/insert-a-node-in-a-bst/1/

class Solution {
    // New element is always inserted at the leaf
    // Search for the value to be inserted till hitting null
    // Insert there and return
    Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val > root.data)
            root.right = insert(root.right, val);

        else if (val < root.data)
            root.left = insert(root.left, val);

        return root;
    }
}