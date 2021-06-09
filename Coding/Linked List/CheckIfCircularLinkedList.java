// Given a singly linked list, find if the linked list is circular or not. A
// linked list is called circular if it not NULL terminated and all nodes are
// connected in the form of a cycle. An empty linked list is considered as
// circular.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/circular-linked-list/1#

// Input:
// LinkedList: 1->2->3->4->5
// (the first and last node is connected,
// i.e. 5 --> 1)
// Output: 1

// Input:
// LinkedList: 2->4->6->7->5->1
// Output: 0
/* Structure of LinkedList
class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
*/
class GfG {
    boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }

        Node temp = head;

        while (temp.next != null && temp.next != head) {
            temp = temp.next;
        }

        // If null, no circular list
        if (temp.next == null) {
            return false;
        }
        // If head, circular list
        else {
            return true;
        }

    }
}