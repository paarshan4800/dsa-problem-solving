// Given Pointer/Reference to the head of the linked list, the task is to Sort
// the given linked list using Merge Sort.
// Note: If the length of linked list is odd, then the extra node should go in
// the first list while splitting.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1/

// Input:
// N = 5
// value[] = {3,5,2,4,1}

class Solution {
    // Function to sort the given linked list using Merge Sort.
    static Node merge(Node x, Node y) {
        if (x == null)
            return y;

        if (y == null)
            return x;

        Node res = null;

        if (x.data < y.data) {
            res = x;
            res.next = merge(x.next, y);
        } else {
            res = y;
            res.next = merge(x, y.next);
        }

        return res;
    }

    static Node findMiddle(Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    static Node mergeSort(Node head) {
        // Base condition
        if (head == null || head.next == null)
            return head;

        // find middle node
        Node mid = findMiddle(head);
        Node rightStart = mid.next; // starting of right portion

        mid.next = null; // remove the link between left and right portion

        Node left = mergeSort(head); // sort the left portion
        Node right = mergeSort(rightStart); // sort the right portion

        // Merge two sorted portions
        return merge(left, right);

    }
}
