// Given a binary search tree, return a balanced binary search tree with the
// same node values.

// A binary search tree is balanced if and only if the depth of the two subtrees
// of every node never differ by more than 1.

// If there is more than one answer, return any of them.

// Leetcode - https://leetcode.com/problems/balance-a-binary-search-tree/

// Input: root = [1,null,2,null,3,null,4,null,null]
// Output: [2,1,3,null,null,null,4]
// Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is
// also correct.

// Do inorder traversal and we'll get sorted array.
// Using sorted array, create BST.
// Refer to ./ConvertSortedArrayToBinarySearch.java