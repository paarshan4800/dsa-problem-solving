// Given two binary trees with head reference as T and S having at most N nodes.
// The task is to check if S is present as subtree in T.
// A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its
// descendants in T1.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/check-if-subtree/1/

// Time Complexity - O(n^2) TIME LIMIT EXCEEDED
class Solution {

    public static boolean isIdentical(Node T, Node S) {
        if (T == null && S == null)
            return true;

        if (T == null || S == null)
            return false;

        if (T.data != S.data)
            return false;

        return isIdentical(T.left, S.left) && isIdentical(T.right, S.right);
    }

    public static boolean isSubtree(Node T, Node S) {

        // Base condition
        // An empty subtree is a part of the main tree
        if (S == null)
            return true;

        // If root node of subtree is not null but current node of main tree is null,
        // then the subtree isnt part of main tree
        if (T == null)
            return false;

        // Check if both the trees given their root nodes are identical or not
        if (isIdentical(T, S))
            return true;

        // If not identical, recur left and right in the main tree
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
}

// Wrong Answer
// Time Complexity - O(n)
// Space Complexity - O(n)

// 1) Find inorder and preorder traversals of T, store them in two auxiliary
// arrays inT[] and preT[].
// 2) Find inorder and preorder traversals of S, store them in two auxiliary
// arrays inS[] and preS[].
// 3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is
// a subtree of T. Else not.

// The above algorithm doesn't work for cases where a tree is present
// in another tree, but not as a subtree.

// Efficient Answer
// Time Complexity - O(n)
// Space Complexity - O(n)
// The above algorithm can be extended to handle such cases by adding a special
// character whenever we encounter NULL in inorder and preorder traversals.

// Leetcode - https://leetcode.com/problems/subtree-of-another-tree/
class Solution {

    public void inorder(TreeNode root, StringBuilder traversal) {
        if (root == null) {
            traversal.append("N");
            return;
        }

        inorder(root.left, traversal);
        traversal.append(Integer.toString(root.val));
        inorder(root.right, traversal);
    }

    public void preorder(TreeNode root, StringBuilder traversal) {
        if (root == null) {
            traversal.append("N");
            return;
        }

        traversal.append(Integer.toString(root.val));
        preorder(root.left, traversal);
        preorder(root.right, traversal);
    }

    public boolean isSubtree(TreeNode T, TreeNode S) {

        StringBuilder inorderT = new StringBuilder();
        StringBuilder inorderS = new StringBuilder();
        StringBuilder preorderT = new StringBuilder();
        StringBuilder preorderS = new StringBuilder();

        inorder(T, inorderT);
        inorder(S, inorderS);

        if (inorderT.indexOf(inorderS.toString()) == -1)
            return false;

        preorder(T, preorderT);
        preorder(S, preorderS);

        if (preorderT.indexOf(preorderS.toString()) == -1)
            return false;

        return true;

    }
}