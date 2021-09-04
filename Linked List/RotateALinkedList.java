// Given a singly linked list of size N. The task is to rotate the linked list
// counter-clockwise by k nodes, where k is a given positive integer smaller
// than or equal to length of the linked list.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1#

// Input:
// N = 5
// value[] = {2, 4, 7, 8, 9}
// k = 3
// Output: 8 9 2 4 7

// Input:
// N = 8
// value[] = {1, 2, 3, 4, 5, 6, 7, 8}
// k = 4
// Output: 5 6 7 8 1 2 3 4

class Solution {

    // Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here

        Node pre = null, cur = head;
        for (int i = 0; i < k; i++) {
            // If cur == null, list over. Reset cur to head
            if (cur == null) {
                cur = head;
                pre = null;
            }
            // Else update pre and move cur forward
            else {
                pre = cur;
                cur = cur.next;
            }
        }

        // If cur or pre is null, then no rotating is required
        if (cur == null || pre == null) {
            return head;
        }

        pre.next = null; // cut off link so that pre acts as tail of resultant list
        Node newHead = cur;

        // Iterate till the end and connect it to the original head
        for (; cur.next != null; cur = cur.next) {

        }

        cur.next = head;

        return newHead;
    }
}