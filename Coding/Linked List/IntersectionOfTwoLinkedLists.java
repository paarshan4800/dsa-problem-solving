// Given the heads of two singly linked-lists headA and headB, return the node
// at which the two lists intersect. If the two linked lists have no
// intersection at all, return null

// Leetcode - https://leetcode.com/problems/intersection-of-two-linked-lists/

// Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA =
// 2, skipB = 3
// Output: Intersected at '8'

// Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3,
// skipB = 1
// Output: Intersected at '2'

// Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
// Output: No intersection

// Brute Force Approach
// For every node in A, search in B
// Time Complexity - O(n^2)
// Space Complexity - O(1)

// Hashing Approach
// Traverse A and store in hash. Then traverse B and for every node in B, search
// in hash
// Time Complexity - O(m+n)
// Space Complexity - O(m)

// Efficient Approach
// Time Complexity - O(m+n)
// Space Complexity - O(1)
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {

    public int getLength(ListNode head) {
        int size = 0;
        for (; head != null; head = head.next) {
            size++;
        }
        return size;
    }

    // move k steps forward given list head and k
    public ListNode moveKSteps(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = getLength(headA);
        int sizeB = getLength(headB);
        int diff = Math.abs(sizeA - sizeB);

        // Should move diff steps forward in longest list
        if (sizeA > sizeB) {
            headA = moveKSteps(headA, diff);
        } else if (sizeA < sizeB) {
            headB = moveKSteps(headB, diff);
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}