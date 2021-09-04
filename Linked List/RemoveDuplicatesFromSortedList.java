// Given the head of a sorted linked list, delete all duplicates such that each
// element appears only once. Return the linked list sorted as well.

// Leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-list/

// Input: head = [1,1,2]
// Output: [1,2]

// Input: head = [1,1,2,3,3]
// Output: [1,2,3]

// Time Complexity - O(n)
// Space Complexity - O(n)
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
// Hash based approach
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        HashSet<Integer> hash = new HashSet<>();

        ListNode newHead = new ListNode(-1);
        ListNode tail = newHead;

        // Traverse list
        for (; head != null; head = head.next) {
            // If already in hash set, its a duplicate so skip
            if (hash.contains(head.val)) {
                continue;
            }

            hash.add(head.val); // else add to hash
            tail.next = new ListNode(head.val); // add to new list
            tail = tail.next; // update tail
        }

        return newHead.next;
    }
}