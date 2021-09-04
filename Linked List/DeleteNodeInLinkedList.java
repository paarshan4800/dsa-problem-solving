// Write a function to delete a node in a singly-linked list. You will not be
// given access to the head of the list, instead you will be given access to the
// node to be deleted directly.
// It is guaranteed that the node to be deleted is not a tail node in the list.

// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/553/

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]


Input: head = [4,5,1,9], node = 1
Output: [4,5,9]

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next; // Get the next node
        node.val = nextNode.val; // Copy contents of next node to the node to be deleted
        node.next = nextNode.next; // Update the node.next such that it skips the next node
        nextNode.next = null; // Isolate the next node by making its next as null
    }
}