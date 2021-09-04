// Given a singly linked list, remove all the nodes which have a greater value
// on its following nodes.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1/

// Input:
// LinkedList = 12->15->10->11->5->6->2->3
// Output: 15 11 6 3
// Explanation: Since, 12, 10, 5 and 2 are
// the elements which have greater elements
// on the following nodes. So, after deleting
// them, the linked list would like be 15,
// 11, 6, 3.

// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    Node compute(Node head) {
        Stack<Integer> stack = new Stack<>();

        Node res = null;

        while (head != null) {

            // Maintain the stack in decreasing order
            while (!stack.isEmpty() && stack.peek() < head.data) {
                stack.pop();
            }

            stack.push(head.data);

            head = head.next;
        }

        // Reverse of the stack is the result
        while (!stack.isEmpty()) {
            Node newNode = new Node(stack.pop());
            newNode.next = res;
            res = newNode;
        }

        return res;
    }
}

// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    Node compute(Node head) {
        if (head.next == null)
            return head;

        // Recur till the last node to the right
        Node rightNode = compute(head.next);

        // If node to the right is greater than current node, return the right node
        if (rightNode.data > head.data)
            return rightNode;

        // rightNode will have the next greater value than current node. So attach
        // current node to right node
        else
            head.next = rightNode;

        // return current node
        return head;

    }
}