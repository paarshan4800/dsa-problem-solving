// Given two BSTs, return elements of both BSTs in sorted form.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1/

class Solution {
    // Techniques used - ITERATIVE INORDER TRAVERSAL AND MERGING PART OF MERGE SORT

    public Node inorder(Node current, Stack<Node> stack) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        return stack.isEmpty() ? null : stack.pop();
    }

    public List<Integer> merge(Node root1, Node root2) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        List<Integer> res = new ArrayList<>();

        Node current1 = inorder(root1, stack1);
        Node current2 = inorder(root2, stack2);

        while ((current1 != null && current2 != null) || (!stack1.isEmpty() && !stack2.isEmpty())) {

            if (current1.data < current2.data) {
                res.add(current1.data);
                current1 = current1.right;
                current1 = inorder(current1, stack1);
            } else {
                res.add(current2.data);
                current2 = current2.right;
                current2 = inorder(current2, stack2);
            }

        }

        // Flush out current1
        while (current1 != null || !stack1.isEmpty()) {
            res.add(current1.data);
            current1 = current1.right;
            current1 = inorder(current1, stack1);
        }

        // Flush out current2
        while (current2 != null || !stack2.isEmpty()) {
            res.add(current2.data);
            current2 = current2.right;
            current2 = inorder(current2, stack2);
        }

        return res;
    }
}
