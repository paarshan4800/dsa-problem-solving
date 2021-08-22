// Given a sorted singly linked list and a data, your task is to insert the data
// in the linked list in a sorted way i.e. order of the list doesn't change.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/insert-in-a-sorted-list/1/

// Input:
// LinkedList: 25->36->47->58->69->80
// data: 19
// Output: 19 25 36 47 58 69 80

class Solution {

    Node insert(int key, Node prev, Node loc, Node head) {

        Node newNode = new Node(key);

        // At beginning
        if (prev == null) {
            newNode.next = head;
            return newNode;
        }

        // At the end
        if (loc == null) {
            prev.next = newNode;
            return head;
        }

        // elsewhere
        prev.next = newNode;
        newNode.next = loc;
        return head;
    }

    Node sortedInsert(Node head, int key) {

        Node prev = null;
        Node temp = head;

        while (temp != null) {
            if (temp.data > key)
                break;

            prev = temp;
            temp = temp.next;
        }

        return insert(key, prev, temp, head);

    }
}