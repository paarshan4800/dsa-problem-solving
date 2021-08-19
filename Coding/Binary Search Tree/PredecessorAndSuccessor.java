// There is BST given with root node with key part as integer only. You need to
// find the inorder successor and predecessor of a given key. In case, if the
// either of predecessor or successor is not found print -1.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1#

class GfG {

    // Performing inorder traversal, we will traverse the elements in sorted order
    // Predecessor is the greatest element less than key
    // Successor is the least element greater than key

    public static void findPreSuc(Node root, Res p, Res s, int key) {
        if (root == null)
            return;

        findPreSuc(root.left, p, s, key);

        // Till root.data >= key, keep updating the predecessor
        if (root.data < key) {
            p.pre = root;
        }

        // If root.data > key and this is the first element greater than key, then this
        // is the successor
        if (root.data > key && s.succ == null) {
            s.succ = root;
        }

        findPreSuc(root.right, p, s, key);
    }
}