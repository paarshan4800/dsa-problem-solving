// Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
// Leetcode - https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/771/

// Input: l1 = [1,2,4], l2 = [1,3,4]
// Output: [1,1,2,3,4,4]

// Input: l1 = [], l2 = []
// Output: []

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

// Iterative Approach (New List for answer)
// Merge sort Merging Approach
class Solution {

    public ListNode insert(ListNode head, int val) {
        if (head == null) {
            head = new ListNode(val);
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new ListNode(val);
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head = insert(head, l2.val);
                l2 = l2.next;
            } else {
                head = insert(head, l1.val);
                l1 = l1.next;
            }
        }

        for (; l1 != null; l1 = l1.next) {
            head = insert(head, l1.val);
        }

        for (; l2 != null; l2 = l2.next) {
            head = insert(head, l2.val);
        }

        return head;
    }
}

// Recursive Approach (In-place)
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // Base condition
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // If l1 < l2, l1 is fixed. l1.next will be the min(l1.next,l2). Recur
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        // If l1 >= l2, l2 is fixed. l2.next will be the min(l1,l2.next). Recur
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}