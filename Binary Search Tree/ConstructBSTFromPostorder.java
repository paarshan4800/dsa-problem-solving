// Given postorder traversal of a Binary Search Tree, you need to construct a
// BST from postorder traversal. The output will be inorder traversal of the
// constructed BST.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/construct-bst-from-post-order/1/

// Input:
// 6
// 1 7 5 50 40 10

// Output:
// 1 5 7 10 40 50

class GFG {
    static int postIndex;

    public static Node constructTreeUtil(int post[], int n, int min, int max) {

        // If all elements are processed, return null
        if (postIndex < 0)
            return null;

        // If the current element to be placed doesnt satisfy the BST property, return
        // null
        if (post[postIndex] <= min || post[postIndex] >= max)
            return null;

        // Create new node
        Node root = new Node(post[postIndex--]);

        // Recur right and left
        root.right = constructTreeUtil(post, n, Math.max(root.data, min), max);
        root.left = constructTreeUtil(post, n, min, Math.min(root.data, max));

        return root;

    }

    public static Node constructTree(int post[], int n) {
        postIndex = n - 1;

        Node ret = constructTreeUtil(post, n, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return ret;
    }
}