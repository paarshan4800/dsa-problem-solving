// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

// Leetcode - https://leetcode.com/problems/reverse-nodes-in-k-group/

// Input: head = [1,2,3,4,5], k = 2
// Output: [2,1,4,3,5]

// Input: head = [1,2,3,4,5], k = 3
// Output: [3,2,1,4,5]

// Input: head = [1,2,3,4,5], k = 1
// Output: [1,2,3,4,5]

// Input: head = [1], k = 1
// Output: [1]

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k, int length) {

        // If length < k, the remaining shouldn't be modified, so return
        if (length < k) {
            return head;
        }

        // Reverse list with incrementing count
        ListNode prev = null, cur = head, next = null;
        int count = 0;
        while (cur != null && count < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        // If next != null means there are elements after this to be reversed.
        // So recur with next as head and update the length to length - k as we have
        // processed k elemets
        if (next != null) {
            head.next = reverseKGroup(next, k, length - k);
        }

        // If next == null means we have reached the end, so return prev which will be
        // the head of the reversed list
        return prev;

    }

    public int findLength(ListNode head) {
        int size = 0;
        for (; head != null; head = head.next) {
            size++;
        }
        return size;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = findLength(head);
        return reverseKGroup(head, k, length);
    }
}