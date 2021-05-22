// Given the head of a linked list, remove the nth node from the end of the list
// and return its head.
// Leetcode - https://leetcode.com/problems/remove-nth-node-from-end-of-list/

// Input: head = [1,2,3,4,5], n = 2
// Output: [1,2,3,5]

// Input: head = [1], n = 1
// Output: []

// Input: head = [1,2], n = 1
// Output: [1]

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

// Two traversal solution
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode cur = head;

        // Find length of the list
        int size = 0;
        for (; cur != null; cur = cur.next) {
            size++;
        }

        if (size - n == 0) {
            return head.next;
        }

        ListNode prev = null;
        cur = head;

        // Traverse till size-n nodes and delete
        for (int i = 0; i < (size - n); i++) {
            prev = cur;
            cur = cur.next;
        }

        prev.next = cur.next;
        cur.next = null;

        return head;
    }
}

// Single Traversal Solution
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Slow and Fast Pointer Approach
        ListNode slow = head, fast = head;

        // Move fast pointer n nodes forward
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // If fast == null (in the cases size of list == n), head should be deleted. So
        // return head.next
        if (fast == null) {
            return head.next;
        }

        // Till fast pointer reaches null, move both slow and fast pointer.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow pointer is the node before the node to be deleted
        // delete node by modifying next 
        ListNode delNode = slow.next;
        slow.next = delNode.next;
        delNode.next = null;

        return head;
    }
}