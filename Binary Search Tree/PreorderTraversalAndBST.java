// Given an array arr[ ] of size N, write a program that returns 1 if given
// array can represent preorder traversal of a possible BST, else returns 0.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1/

// Approach 1 - Stack Overflow Error
// Create a BST by considering the given array as preorder traversal
// After building the tree is complete, check if all the elements of the array
// have been created in the tree or not i.e preorderIndex == size
// If so, it is a valid preorder traversal

// Approach 2
class Solution {

    // Intuition - for any item ( say x ) if there is a larger item present after it
    // ( i.e. the left subtree part is over now ) .Then after the larger item there
    // should be no item smaller than x

    static int canRepresentBST(int pre[], int size) {

        Stack<Integer> stack = new Stack<>();

        ArrayList<Integer> list = new ArrayList<>();

        for (int num : pre) {

            // Make sure that the stack is in decreasing order
            while (!stack.isEmpty() && stack.peek() < num) {
                // Pop from stack and add to list
                list.add(stack.pop());
            }

            stack.push(num);
        }

        // FLush stack to list
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        // If list is sorted, then it is a valid preorder traversal
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1))
                return 0;
        }

        return 1;

    }
}