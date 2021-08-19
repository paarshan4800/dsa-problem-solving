// Given a Binary Tree. Return 1 if, for every node X in the tree other than the
// leaves, its value is equal to the sum of its left subtree's value and its
// right subtree's value. Else return 0.

// An empty tree is also a Sum Tree as the sum of an empty tree can be
// considered to be 0. A leaf node is also considered a Sum Tree.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/sum-tree/1/

// Input:

// 10
// / \
// 20 30
// / \
// 10 10

// Output: 0
// Explanation:
// The given tree is not a sum tree.
// For the root node, sum of elements
// in left subtree is 40 and sum of elements
// in right subtree is 30. Root element = 10
// which is not equal to 30+40.

class Solution {

    // POST ORDER TRAVERSAL

    boolean res = true;

    int isSumTreeUtil(Node root) {
        if (root == null)
            return 0;

        // If leaf node, return root.data
        if (root.left == null && root.right == null)
            return root.data;

        // Calculate left subtree's sum
        int leftSum = isSumTreeUtil(root.left);

        // Calculate right subtree's sum
        int rightSum = isSumTreeUtil(root.right);

        // If sum of left subtree and right subtree is not equal to the root.data, then
        // the whole answer is false
        if (leftSum + rightSum != root.data) {
            res = false;
        }

        // return the sum of two subtrees and root.data to the caller
        return leftSum + rightSum + root.data;
    }

    boolean isSumTree(Node root) {
        isSumTreeUtil(root);
        return res;
    }
}
