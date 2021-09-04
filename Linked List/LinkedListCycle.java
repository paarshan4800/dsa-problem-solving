// Given head, the head of a linked list, determine if the linked list has a
// cycle in it.

// Leetcode - https://leetcode.com/problems/linked-list-cycle/

// Input: head = [3,2,0,-4], pos = 1
// Output: true

// Input: head = [1,2], pos = 0
// Output: true

/**
 * Definition for singly-linked list. class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

// Floyd Cycle Finding Algorithm
// Time Complexity - O(n)
// Space Complexity - O(1)
public class Solution {
    public boolean hasCycle(ListNode head) {

        // Slow and fast pointer approach
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast pointer meet each other, then cycle exists
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}

// Another Approach
// Hashing based
// While traversing, store the node in a hashset.
// If the node is found in the hashset, cycle exists.
// Time Complexity - O(n)
// Space Complexity - O(n)