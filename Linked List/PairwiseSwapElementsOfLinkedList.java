// Given a singly linked list of size N. The task is to swap elements in the
// linked list pairwise.
// For example, if the input list is 1 2 3 4, the resulting list after swaps
// will be 2 1 4 3.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1#

// Input:
// LinkedList: 1->2->2->4->5->6->7->8
// Output: 2 1 4 2 6 5 8 7

// Input:
// LinkedList: 1->3->4->7->9->10->1
// Output: 3 1 7 4 10 9 1

class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should returns head of the modified list
    public Node pairwiseSwap(Node head) {
        // If length is 0 or 1, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Process two nodes in every iteration
        // Prev and cur points to the first and second node respectively
        Node prev = head, cur = prev.next, newHead = cur;

        while (true) {
            // save the first node of next two nodes to be processed
            Node next = cur.next;

            // Begin swapping (change next of second node to first node)
            cur.next = prev;

            // next == null means prev and cur are the last two nodes (even length)
            // next != null and next.next == null means only one node is left which cant be
            // swapped with its pair (doesnt have one) (odd length)
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // First node points to the second node of next iteration
            prev.next = next.next;

            // Move prev and cur so that in next iteration they point at the next two nodes
            prev = next;
            cur = prev.next;
        }

        return newHead;
    }
}