// Given the head of a singly linked list, reverse the list, and return the reversed list.

// Leetcode - https://leetcode.com/problems/reverse-linked-list/

// Input: head = [1,2,3,4,5]
// Output: [5,4,3,2,1]

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

// Iterative Approach
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head, nextNode;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;

    }
}

// Recursive Approach
// Recur till reaching last node
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    public ListNode reverseList(ListNode head) {
        // Base condition
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next); // Recur

        // Reverse the two nodes (head and head.next)
        head.next.next = head;
        head.next = null;
        return newHead;

    }
}