// Given a Binary Tree of size N , where each node can have positive or negative
// values. Convert this to a tree where each node contains the sum of the left
// and right sub trees of the original tree. The values of leaf nodes are
// changed to 0.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1/

// Input:
// 10
// / \
// -2 6
// / \ / \
// 8 -4 7 5

// Output:
// 20
// / \
// 4 12
// / \ / \
// 0 0 0 0

class Solution {

    public int toSumTreeUtil(Node root) {

        if (root == null)
            return 0;

        if (root.left == null && root.right == null) {
            int ret = root.data;
            root.data = 0;
            return ret;
        }

        int left = toSumTreeUtil(root.left);
        int right = toSumTreeUtil(root.right);

        int ret = left + right + root.data;
        root.data = left + right;

        return ret;
    }

    public void toSumTree(Node root) {
        toSumTreeUtil(root);
    }
}