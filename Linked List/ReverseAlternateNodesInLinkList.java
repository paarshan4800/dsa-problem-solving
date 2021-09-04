// Given a linked list, you have to perform the following task:

// Extract the alternative nodes starting from second node.
// Reverse the extracted list.
// Append the extracted list at the end of the original list.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/given-a-linked-list-reverse-alternate-nodes-and-append-at-the-end/1/

// Input:
// LinkedList = 10->4->9->1->3->5->9->4
// Output: 10 9 3 9 4 5 1 4
// Explanation: Reversing the alternative
// nodes from the given list, and then
// appending them to the end of the list
// results in a list with the elements as
// 10 9 3 9 4 5 1 4.

class Solution {
    public static Node reverse(Node head) {

        Node prev = null, cur = head, nextNode;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;
    }

    public static void rearrange(Node head) {
        if (head == null) {
            return;
        }

        Node odd = head, even = odd.next, evenHead = even;

        // After traversing till this condition, we will get odd and even node linked
        // list.
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        // Odd will be the tail of odd linked list. this is linked to the evenHead
        // (starting of even linked list)

        // Reverse the even part and attach it to odd part
        odd.next = reverse(evenHead);
    }
}
