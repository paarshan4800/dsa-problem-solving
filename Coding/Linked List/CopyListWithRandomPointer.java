// A linked list of length n is given such that each node contains an additional
// random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n
// brand new nodes, where each new node has its value set to the value of its
// corresponding original node. Both the next and random pointer of the new
// nodes should point to new nodes in the copied list such that the pointers in
// the original list and copied list represent the same list state. None of the
// pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where
// X.random --> Y, then for the corresponding two nodes x and y in the copied
// list, x.random --> y.

// Return the head of the copied linked list.

// Leetcode - https://leetcode.com/problems/copy-list-with-random-pointer/

// Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
// Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

// Input: head = [[1,1],[2,1]]
// Output: [[1,1],[2,1]]

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }

        Node originalHead = head;

        // Step 1 -> Insert clone nodes next to original nodes
        for (Node temp = head; temp != null; temp = temp.next.next) {
            Node nextNode = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = nextNode;
        }

        // Step 2 -> Copy the random pointers of original nodes to cloned nodex
        for (Node temp = head; temp != null; temp = temp.next.next) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            } else {
                temp.next.random = null;
            }
        }

        Node cloneHead = head.next;
        Node original = head, clone = head.next;

        // Step 3 -> Seperate original and clone list
        while (original != null && clone != null) {
            if (original.next != null) {
                original.next = original.next.next;
            }

            if (clone.next != null) {
                clone.next = clone.next.next;
            }

            original = original.next;
            clone = clone.next;
        }

        return cloneHead;
    }
}

// Another Approach
// Use Hashmap to store the data of nodes