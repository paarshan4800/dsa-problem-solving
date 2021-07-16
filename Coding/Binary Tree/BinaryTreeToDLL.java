// Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
// The left and right pointers in nodes are to be used as previous and next
// pointers respectively in converted DLL. The order of nodes in DLL must be
// same as Inorder of the given Binary Tree. The first node of Inorder traversal
// (leftmost node in BT) must be the head node of the DLL.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1#

// Input : 10 12 15 25 30 36 N
// Output : 25 12 30 10 36 15

class Solution {
    Node head = null, prev = null;

    // INORDER TRAVERSAL

    void inorder(Node root) {

        if (root == null)
            return;

        inorder(root.left);

        // We will reach the first node with head as null. Set head to first node of
        // inorder traversal
        if (head == null) {
            head = root;
        }
        // If head != null i.e not the fist node of inorder traversal
        else {
            // Set prev.right as root and root.left as prev
            prev.right = root;
            root.left = prev;
        }

        // Update prev
        prev = root;

        inorder(root.right);

    }

    Node bToDLL(Node root) {
        inorder(root);
        return head;

    }
}