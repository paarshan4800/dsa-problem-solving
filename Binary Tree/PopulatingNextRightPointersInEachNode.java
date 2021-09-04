// You are given a perfect binary tree where all leaves are on the same level,
// and every parent has two children. The binary tree has the following
// definition:

// struct Node {
// int val;
// Node *left;
// Node *right;
// Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no
// next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Leetcode -
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

// Input: root = [1,2,3,4,5,6,7]
// Output: [1,#,2,3,#,4,5,6,7,#]

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
// Level Order Traversal Modification
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {

    public void addNextNodesToQueue(Queue<Node> queue, Node node) {
        if (node.left != null) {
            queue.add(node.left);
        }

        if (node.right != null) {
            queue.add(node.right);
        }
    }

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node prevNode = null;
            for (int i = 0; i < size; i++) {
                if (prevNode == null) {
                    prevNode = queue.poll();
                    addNextNodesToQueue(queue, prevNode);
                } else {
                    prevNode.next = queue.poll();
                    addNextNodesToQueue(queue, prevNode.next);
                    prevNode = prevNode.next;
                }
            }
        }

        return root;

    }
}