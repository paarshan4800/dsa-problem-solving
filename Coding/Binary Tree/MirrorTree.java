// Given a Binary Tree, convert it into its mirror.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/mirror-tree/1#

// Input - 10 20 30 40 60

// Output - 30 10 60 20 40

class Solution {
    // POSTORDER TRAVERSAL
    void mirror(Node root) {

        if (root == null)
            return;

        mirror(root.left); // Recur left
        mirror(root.right); // Recur right

        // Swap left and right child
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

    }
}