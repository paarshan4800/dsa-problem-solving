// Given a Binary Search Tree and a target sum. Check whether there's a pair of
// Nodes in the BST with value summing up to the target sum.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1/

class Solution {
    // root : the root Node of the given BST
    // target : the target sum

    // Perform inorder traversal to get the tree as a sorted array
    // Using two pointer technique to find whether pair exists or not

    public void inorder(Node root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public int isPairPresent(Node root, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);

        int low = 0, high = list.size() - 1;

        while (low < high) {
            if (list.get(low) + list.get(high) > target)
                high--;
            else if (list.get(low) + list.get(high) < target)
                low++;
            else
                return 1;
        }

        return 0;

    }
}