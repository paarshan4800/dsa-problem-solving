// Given a BST, and a reference to a Node x in the BST. Find the Inorder
// Successor of the given node in the BST.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1/

// Time Complexity - O(n)
// Run Inorder Traversal
class Solution {
    // returns the inorder successor of the Node x in BST (rooted at 'root')
    Node res = null;
    Node prev = null;

    public void inorder(Node root, Node x) {
        if (root == null)
            return;

        inorder(root.right, x);

        if (root.data == x.data) {
            res = prev;
        }

        prev = root;

        inorder(root.left, x);
    }

    public Node inorderSuccessor(Node root, Node x) {
        inorder(root, x);
        return res;
    }
}

// Efficient Approach
// Time Complexity - O(h)
// YT - https://www.youtube.com/watch?v=5cPbNCrdotA
class Solution {
    public Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    public Node inorderSuccessor(Node root, Node x) {
        // Case 1 : Right Subtree is present
        // The inorder successor will the leftmost element at the right subtree (i.e
        // minimum element of the right subtree)
        if (x.right != null) {
            return findMin(x.right);
        }

        // Case 2 : No right subtree is present
        // The inorder successor will be the least largest value in the path from root
        // to the key node
        Node successor = null;
        Node ancestor = root;

        // Traverse through the path from root to the key

        // Till ancestor == key
        while (ancestor != x) {
            // If ancestor is greater than key, the ancestor might be the successor. So
            // update successor
            if (ancestor.data > x.data) {
                successor = ancestor;
                ancestor = ancestor.left;
            }
            // If ancestor is less than key, this ancestor cannot be the successor
            else {
                ancestor = ancestor.right;
            }
        }

        return successor;
    }
}