// Given a singly linked list: A0→A1→…→An-1→An, reorder it to:
// A0→An→A1→An-1→A2→An-2→…
// For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

// Note: It is recommended do this in-place without altering the nodes' values.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/reorder-list/1/

// Input:
// LinkedList: 1->2->3
// Output: 1 3 2

// Input:
// LinkedList: 1->7->3->4
// Output: 1 4 7 3.

class gfg {

    Node reverse(Node head) {
        Node prev = null, cur = head, nextNode;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;
    }

    Node findMiddle(Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    Node merge(Node left, Node right) {
        Node resNode = new Node(-1);
        Node res = resNode;

        while (true) {
            if (left == null)
                break;
            res.next = left;
            res = res.next;
            left = left.next;

            if (right == null)
                break;
            res.next = right;
            res = res.next;
            right = right.next;
        }

        return resNode.next;
    }

    Node reorderlist(Node head) {

        Node mid = findMiddle(head); // Find middle node
        Node right = mid.next; // Starting of right portion
        right = reverse(right); // Reverse the right portion
        Node left = head; // Starting of left portion

        mid.next = null; // Delink left and right portion

        return merge(left, right); // Merge left and right portion alternatively
    }
}
