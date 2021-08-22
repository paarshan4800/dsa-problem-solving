// Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s
// only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros
// segregate to head side, 2s at the end of the linked list, and 1s in the mid
// of 0s and 2s.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1/

// Input:
// N = 8
// value[] = {1,2,2,1,2,0,2,2}
// Output: 0 1 1 2 2 2 2 2

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {

        // To avoid null checks, insert nodes in this manner
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead, one = oneHead, two = twoHead;

        for (Node cur = head; cur != null; cur = cur.next) {
            if (cur.data == 0) {
                zero.next = cur;
                zero = zero.next;
            } else if (cur.data == 1) {
                one.next = cur;
                one = one.next;
            } else {
                two.next = cur;
                two = two.next;
            }
        }

        // oneHead.next != null means there elements with value 1. So attach zero to
        // oneHead.next
        // oneHead.next == null means there are no elements with value 1. So skip one
        // and attach zero directly to twoHead.next
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return zeroHead.next;
    }
}
