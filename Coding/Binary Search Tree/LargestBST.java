// Given a binary tree. Find the size of its largest subtree that is a Binary
// Search Tree.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/largest-bst/1#

// Input :50 30 60 5 20 45 70 N N N N N N 65 80
// Output : 5

class BSTInfo {
    boolean isBST;
    int size;
    int min;
    int max;

    BSTInfo(boolean isBST, int size, int min, int max) {
        this.isBST = isBST;
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

class Solution {

    // Return the size of the largest sub-tree which is also a BST

    // POSTORDER TRAVERSAL

    static BSTInfo findLargestBst(Node root) {

        // Base condition
        if (root == null) {
            return new BSTInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BSTInfo left = findLargestBst(root.left);

        BSTInfo right = findLargestBst(root.right);

        // If any one of the subtrees is not a bst, return false with size as maximum
        // size of the two subtrees
        if (!left.isBST || !right.isBST) {
            return new BSTInfo(false, Math.max(left.size, right.size), 0, 0);
        }

        // If the current node doesn't satisfy the BST property, return
        if (root.data <= left.max || root.data >= right.min) {
            return new BSTInfo(false, Math.max(left.size, right.size), 0, 0);
        }

        // Return isBST -> true, size -> sum of size of two subtrees + 1 (root), min ->
        // minimum(root.data, left.min), max -> maximum (root.data, right.max)
        return new BSTInfo(true, 1 + left.size + right.size, Math.min(left.min, root.data),
                Math.max(right.max, root.data));

    }

    static int largestBst(Node root) {
        // Write your code here
        return findLargestBst(root).size;

    }

}