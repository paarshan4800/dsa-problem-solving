// Given a Binary Search Tree. Convert a given BST into a Special Max Heap with
// the condition that all the values in the left subtree of a node should be
// less than all the values in the right subtree of the node. This condition is
// applied on all the nodes in the so converted Max Heap.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/bst-to-max-heap/1/

// Map the inorder traversal values to the postorder traversal of the same tree
class Solution {

    public static void inorder(Node root, Queue<Integer> queue) {
        if (root == null)
            return;

        inorder(root.left, queue);
        queue.add(root.data);
        inorder(root.right, queue);
    }

    public static void postorder(Node root, Queue<Integer> queue) {
        if (root == null)
            return;

        postorder(root.left, queue);
        postorder(root.right, queue);
        root.data = queue.poll();
    }

    public static void convertToMaxHeapUtil(Node root) {
        Queue<Integer> queue = new LinkedList<>();

        inorder(root, queue);

        // Postorder traversal inserts the smaller elements at the leaf as first left
        // and right subtrees are explored and then root node is explored
        postorder(root, queue);
    }
}