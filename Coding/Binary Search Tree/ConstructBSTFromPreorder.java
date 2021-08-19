// Given an array arr[] of N nodes representing preorder traversal of BST. The task is to print its postorder traversal.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/preorder-to-postorder4423/1/

class Solution {
    static int preIndex;

    public static Node constructTreeUtil(int pre[], int n, int min, int max) {

        // If all elements are processed, return null
        if (preIndex >= n)
            return null;

        // If the current element to be placed doesnt satisfy the BST property, return
        // null
        if (pre[preIndex] <= min || pre[preIndex] >= max)
            return null;

        // Create new node
        Node root = new Node(pre[preIndex++]);

        // Recur left and right
        root.left = constructTreeUtil(pre, n, min, Math.min(root.data, max));
        root.right = constructTreeUtil(pre, n, Math.max(root.data, min), max);

        return root;

    }

    public static Node constructTree(int pre[], int size) {
        preIndex = 0;

        Node ret = constructTreeUtil(pre, size, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return ret;
    }
}