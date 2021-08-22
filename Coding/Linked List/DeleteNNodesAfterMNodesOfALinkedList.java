// Given a linked list, delete N nodes after skipping M nodes of a linked list
// until the last of the linked list.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1/

// Example:
// Input:
// 2
// 8
// 2 1
// 9 1 3 5 9 4 10 1
// 6
// 6 1
// 1 2 3 4 5 6

// Output:
// 9 1 5 9 10 1
// 1 2 3 4 5 6

// Explanation:
// Testcase 1: Deleting one node after skipping the M nodes each time, we have
// list as 9-> 1-> 5-> 9-> 10-> 1.

class Solution {
    static void linkdelete(Node head, int M, int N) {

        // If n == 0, no elements are required to be deleted. So just return
        if (N == 0)
            return;
        // If n != 0 and m == 0, all the elements are required to be deleted. So just
        // change head to null and return
        if (M == 0) {
            head = null;
            return;
        }

        Node cur = head;

        while (true) {

            Node prev = null;

            // Traverse M elements
            for (int i = 0; i < M; i++) {
                // If next is null, then no elements are to be deleted more. So return
                if (cur.next == null)
                    return;

                prev = cur;
                cur = cur.next;
            }

            // Traverse N elements
            for (int i = 0; i < N - 1; i++) {
                // If next element is null, delete the elements traversed till now
                if (cur.next == null)
                    break;

                cur = cur.next;
            }

            // Delinking elements to be deleted from list
            prev.next = cur.next;

            // If no more elements, return
            if (cur.next == null)
                return;

            // Else move cur
            cur.next = null;
            cur = prev.next;
        }
    }
}
