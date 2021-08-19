// You are given the root of a binary search tree (BST), where exactly two nodes
// of the tree were swapped by mistake. Recover the tree without changing its
// structure.

// Leetcode - https://leetcode.com/problems/recover-binary-search-tree/

// Input: root = [3,1,4,null,null,2]
// Output: [2,1,4,null,null,3]
// Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2
// and 3 makes the BST valid.

class Solution {

    // Find inorder traversal of the given tree
    // Sort the inorder traversal of the given tree in a another array
    // Traverse both arrays and find the elements that are not sorted
    // Swap those two elements

    public void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public ArrayList<Integer> insertionSort(ArrayList<Integer> original) {

        ArrayList<Integer> list = new ArrayList<>(original);

        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int j = i;

            while (j - 1 >= 0 && list.get(j - 1) > current) {
                list.set(j, list.get(j - 1));
                j--;
            }

            list.set(j, current);
        }

        return list;
    }

    public void correctBST(TreeNode root, int x, int y) {
        if (root == null)
            return;

        correctBST(root.left, x, y);

        if (root.val == x) {
            root.val = y;
        }

        else if (root.val == y) {
            root.val = x;
        }

        correctBST(root.right, x, y);
    }

    public int[] convertToArray(ArrayList<Integer> list) {
        int[] arr = new int[list.size()];

        int i = 0;
        for (int num : list)
            arr[i++] = num;

        return arr;
    }

    public void recoverTree(TreeNode root) {
        ArrayList<Integer> original = new ArrayList<>();
        inorder(root, original);

        ArrayList<Integer> corrected = insertionSort(original);

        int[] originalArr = convertToArray(original);
        int[] correctedArr = convertToArray(corrected);

        for (int i = 0; i < originalArr.length; i++) {
            if (originalArr[i] != correctedArr[i]) {
                correctBST(root, originalArr[i], correctedArr[i]);
                break;
            }
        }
    }
}