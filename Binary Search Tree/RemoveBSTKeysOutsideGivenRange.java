// Given a Binary Search Tree (BST) and a range [min, max], remove all keys
// which are outside the given range. The modified tree should also be BST.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/remove-bst-keys-outside-given-range/1/

// Approach 1
// Find the elements to be included in the BST (Do inorder traversal)
// Create BST from the sorted array
class Solution {

    void inorder(Node root, ArrayList<Integer> list, int low, int high) {
        if (root == null)
            return;

        inorder(root.left, list, low, high);

        if (root.data >= low && root.data <= high)
            list.add(root.data);

        inorder(root.right, list, low, high);
    }

    // Find mid given low and high
    int findMid(int low, int high) {
        return low + (high - low) / 2; // To prevent integer overflow
    }

    Node createBST(ArrayList<Integer> list, int low, int high) {

        // Base condition
        if (low > high) {
            return null;
        }

        int mid = findMid(low, high);

        // Middle element is the root node.
        Node root = new Node(list.get(mid));

        // To find the left child, recur down with elements left of the middle (low,
        // mid-1)
        root.left = createBST(list, low, mid - 1);

        // To find the right child, recur down with elements right of the middle
        // (mid+1,high)
        root.right = createBST(list, mid + 1, high);

        return root; // return the root node

    }

    Node removekeys(Node root, int l, int r) {
        ArrayList<Integer> include = new ArrayList<>();
        inorder(root, include, l, r);

        return createBST(include, 0, include.size() - 1);
    }
}

// Approach 2
class Solution {

    // POSTORDER TRAVERSAL
    Node removekeys(Node root, int l, int r) {
        if (root == null)
            return null;

        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);

        // If current node's data is less than min range, then we need elements greater
        // than the current node's data. By BST properties, the current node's right
        // subtree will only have elements greater than current node. So return the
        // right subtree to the caller. By doing so, the current node will be deleted
        if (root.data < l)
            return root.right;

        // If current node's data is greater than max range, then we need elements
        // lesser than the current node's data. By BST properties, the current node's
        // left subtree will only have elements lesser than current node. So return the
        // left subtree to the caller. By doing so, the current node will be deleted
        if (root.data > r)
            return root.left;

        return root;
    }
}