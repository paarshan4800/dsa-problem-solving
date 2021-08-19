// Given a Binary Search Tree and a node value X. Delete the node with the given
// value X from the BST. If no node with value x exists, then do not make any
// change.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/delete-a-node-from-bst/1/

// 1) Node to be deleted is the leaf: Simply remove from the tree. 

// 2) Node to be deleted has only one child: Copy the child to the node and delete the child 

// 3) Node to be deleted has two children: Find inorder successor of the node. 
// Copy contents of the inorder successor to the node and delete the inorder successor. 
// Note that inorder predecessor can also be used. 

class Tree {
    // Function to delete a node from BST.
    public static int findInorderSuccessor(Node root) {
        int ret = root.data;

        while (root.left != null) {
            root = root.left;
            ret = root.data;
        }

        return ret;
    }

    public static Node deleteNode(Node root, int X) {

        // Search for the node with value X
        if (root == null)
            return null;

        if (X < root.data)
            root.left = deleteNode(root.left, X);

        else if (X > root.data)
            root.right = deleteNode(root.right, X);

        // If value is found
        else {

            // Zero or one children cases are covered in the if and if else conditions
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // If two children are there, then else is executed
            else {
                // Update the data of the root node to its inorder successor
                root.data = findInorderSuccessor(root.right);
                // Call deleteNode for the right subtree to delete its inorder successor
                root.right = deleteNode(root.right, root.data);
            }
        }

        return root;
    }
}