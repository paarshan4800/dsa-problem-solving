// Given a Binary Tree, convert it to Binary Search Tree in such a way that
// keeps the original structure of Binary Tree intact.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1/

class Solution {

    // Store inorder traversal in an array
    // Sort the array
    // Using the sorted array, build BST

    public void inorder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public int findMid(int low, int high) {
        return low + (high - low) / 2;
    }

    public Node buildBST(ArrayList<Integer> list, int low, int high) {
        if (low > high)
            return null;

        int mid = findMid(low, high);

        Node root = new Node(list.get(mid));

        root.left = buildBST(list, low, mid - 1);
        root.right = buildBST(list, mid + 1, high);

        return root;
    }

    Node binaryTreeToBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        Collections.sort(list);

        return buildBST(list, 0, list.size() - 1);
    }
}
