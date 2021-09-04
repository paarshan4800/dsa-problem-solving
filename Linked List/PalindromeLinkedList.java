// Given the head of a singly linked list, return true if it is a palindrome.

// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/93/linked-list/772/

// Input: head = [1,2,2,1]
// Output: true

// Input: head = [1,2,2,1]
// Output: true

// Stack based aproach
// Push everything into the stack.
// Pop one by one and compare while traversing

// Efficient Approach
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    // Get size of linked list
    public int getLength(ListNode head) {
        int count = 0;
        for (; head != null; head = head.next) {
            count++;
        }
        return count;
    }

    // Find middle element of linked list (using slow and fast pointer efficient
    // approach)
    public ListNode findMiddle(ListNode head, boolean isEven) {

        // Slow pointer moves one step at a time
        // Fast pointer moves two steps at a time
        ListNode slow = head, fast = head, prevSlow = null;

        while (fast != null && fast.next != null) {
            prevSlow = slow; // Prev holds the previous node of slow pointer
            slow = slow.next;
            fast = fast.next.next;
        }

        // If size is even, prevSlow is middle. Else slow
        return isEven ? prevSlow : slow;

    }

    // Reverse Linked List
    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head, nextNode;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        boolean res = true;

        int size = getLength(head);
        boolean isEven = (size % 2 == 0) ? true : false;

        // Find the middle of the list
        ListNode sep = findMiddle(head, isEven);

        // secHead is the head of second part of linked list
        ListNode secHead = reverse(sep.next);

        // temp1 and temp2 are used to traverse first and second part of linked list
        ListNode temp1 = head, temp2 = secHead;
        while (temp2 != null) {
            if (temp1.val != temp2.val) {
                res = false;
                break;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        // Reverse it back
        secHead = reverse(secHead);

        return res;

    }
}