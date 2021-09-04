// Given a binary tree, find its minimum depth.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-depth-of-a-binary-tree/1/

// Input:
// 10
// / \
// 20 30
// \ \
// 40 60
// /
// 2

// Output: 3

// Explanation:
// Minimum depth is between nodes 10,20 and 40.

class Solution {

    // Like finding max depth, we can't return 0 for null element. Since we are
    // taking min of left and right subtree, min of anything greater than 0 and 0
    // would be 0 which wont lead us to the correct answer

    int minDepth(Node root) {
        if (root == null)
            return Integer.MAX_VALUE;

        // If leaf node, it yields 1
        if (root.left == null && root.right == null)
            return 1;

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
