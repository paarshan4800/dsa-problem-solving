// You are given two non-empty linked lists representing two non-negative
// integers. The digits are stored in reverse order, and each of their nodes
// contains a single digit. Add the two numbers and return the sum as a linked
// list.

// You may assume the two numbers do not contain any leading zero, except the
// number 0 itself.

// Leetcode - https://leetcode.com/problems/add-two-numbers/

// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]

// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]

// Time Complexity - max(O(m,n))
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

    public void display(ListNode head) {
        for (; head != null; head = head.next) {
            System.out.print(head.val + "\t");
        }
    }

    public int getSize(ListNode head) {
        int size = 0;
        for (; head != null; head = head.next) {
            size++;
        }
        return size;
    }

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0; // carry initially is 0
        ListNode head = null;

        // Always make sure that list l1 holds the longest one
        if (getSize(l1) < getSize(l2)) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        // Till atleast one list is traversed
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry; // Find sum
            head = insert(head, sum % 10); // Insert sum%10 into result

            carry = sum / 10; // Find carry

            l1 = l1.next;
            l2 = l2.next;
        }

        // If there is no carry and the longest list l1 is traversed, then we have the
        // result
        if (carry == 0 && l1 == null) {
            return head;
        }

        // Else traverse l1
        while (l1 != null) {
            int sum = l1.val + carry;
            head = insert(head, sum % 10);
            carry = sum / 10;
            l1 = l1.next;
        }

        // If carry not 0, insert that also
        if (carry != 0) {
            head = insert(head, carry);
        }

        display(head);
        return head;

    }
}