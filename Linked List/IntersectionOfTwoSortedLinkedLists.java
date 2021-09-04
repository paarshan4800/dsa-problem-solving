// Given two lists sorted in increasing order, create a new list representing
// the intersection of the two lists. The new list should be made with its own
// memory — the original lists should not be changed.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/intersection-of-two-sorted-linked-lists/1/

// Input:
// L1 = 1->2->3->4->6
// L2 = 2->4->6->8
// Output: 2 4 6
// Explanation: For the given first two
// linked list, 2, 4 and 6 are the elements
// in the intersection.

class Sol {
    public static Node findIntersection(Node head1, Node head2) {
        Node resHead = new Node(-1);
        Node res = resHead;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                res.next = new Node(head1.data);
                res = res.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return resHead.next;
    }
}