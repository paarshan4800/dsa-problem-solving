// Given the head of a singly linked list, group all the nodes with odd indices
// together followed by the nodes with even indices, and return the reordered
// list.

// The first node is considered odd, and the second node is even, and so on.

// Note that the relative order inside both the even and odd groups should
// remain as it was in the input.

// Leetcode - https://leetcode.com/problems/odd-even-linked-list/

// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]

// Input: head = [2,1,3,5,6,4,7]
// Output: [2,3,6,7,1,5,4]

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public void display(ListNode head) {
        for (; head != null; head = head.next) {
            System.out.println(head.val);
        }
    }

    public ListNode oddEvenList(ListNode head) {

        // If no element or only one element, return head
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head, even = odd.next; // odd and even points at odd and even node respectively
        ListNode end = head; // end points at the end of the original linked list

        // find end
        for (; end.next != null; end = end.next) {
        }

        ListNode tail = end; // tail points at the linked list after modification

        // till odd or even reaches end
        while (odd != end && even != end) {
            // change links
            tail.next = even;
            tail = tail.next;
            odd.next = tail.next;
            tail.next = null;

            // update odd and even
            odd = odd.next;
            even = odd.next;

        }

        // If even == end, then list length is even and the process of last two nodes is
        // skipped
        if (even == end) {
            tail.next = even;
            tail = tail.next;
            odd.next = tail.next;
            tail.next = null;
        }

        display(head);

        return head;

    }
}

// Clean code
class Solution {

    public ListNode oddEvenList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode odd = head, even = odd.next, evenHead = even;

        // After traversing till this condition, we will get odd and even node linked
        // list.
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Odd will be the tail of odd linked list. this is linked to the evenHead
        // (starting of even linked list)
        odd.next = evenHead;
        return head;

    }
}