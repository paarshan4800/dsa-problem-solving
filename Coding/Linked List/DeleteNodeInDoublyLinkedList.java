// Given a doubly linked list and a position. The task is to delete a node from
// given position in a doubly linked list

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/delete-node-in-doubly-linked-list/1/

// Input:
// LinkedList = 1 <--> 5 <--> 2 <--> 9
// x = 1
// Output: 5 2 9

class Solution {
    // function returns the head of the linkedlist
    Node deleteNode(Node head, int x) {
        Node delNode = head;

        for (int i = 0; i < x - 1; i++) {
            delNode = delNode.next;
        }

        // At the beginning -> IF 1,2 gets executed
        // At the end -> IF 3 gets executed
        // At the middle -> IF 2,3 gets executed

        // If the node to be deleted is the head node, move the head forward
        if (delNode == head) {
            head = delNode.next;
        }

        // If the next of delNode is not null
        if (delNode.next != null) {
            delNode.next.prev = delNode.prev;
        }

        // If the prev of delNode is not null
        if (delNode.prev != null) {
            delNode.prev.next = delNode.next;
        }

        return head;
    }
}