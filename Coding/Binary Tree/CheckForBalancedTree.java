// Given a binary tree, find if it is height balanced or not. 
// A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1/

// Time Complexity - O(n^2)
class Tree {

    // A tree is balanced if its
    // i) difference between height of left and right subtree is <=1
    // ii) left subtree is balanced
    // iii) right subtree is balanced
    int findHeight(Node root) {
        if (root == null)
            return 0;

        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }

    // Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
// Store the heights of each node in hash for O(1) access
