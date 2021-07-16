// Given a Binary Tree of N edges. The task is to convert this to a Circular
// Doubly Linked List(CDLL) in-place. The left and right pointers in nodes are
// to be used as previous and next pointers respectively in converted CDLL. The
// order of nodes in CDLL must be same as Inorder of the given Binary Tree. The
// first node of Inorder traversal (left most node in BT) must be head node of
// the CDLL.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/binary-tree-to-cdll/1#

// Input : 10 12 15 25 30 36 N
// Output : 25 12 30 10 36 15

// Same as Binary Tree to Doubly Linked List
// prev is tail node of the doubly linked list formed
// Make a circular link i.e head.left = prev and prev.next = head
