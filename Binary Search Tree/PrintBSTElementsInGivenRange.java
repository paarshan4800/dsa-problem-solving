// Given a Binary Search Tree and a range. Find all the numbers in the BST that
// lie in the given range.
// Note: Element greater than or equal to root go to the right side.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/print-bst-elements-in-given-range/1#

// Input : 16 7 20 1 10
// l = 13, h = 23

// Output: 16 20

class Solution {
    // Function to return a list of BST elements in a given range.

    // DO INORDER TRAVERSAL (RESULT IN ASCENDING ORDER)

    public static void printNearNodes(Node root, int low, int high, ArrayList<Integer> res) {

        if (root == null)
            return;

        printNearNodes(root.left, low, high, res);

        // If in range, add to list
        if (root.data >= low && root.data <= high)
            res.add(root.data);

        printNearNodes(root.right, low, high, res);

    }

    public static ArrayList<Integer> printNearNodes(Node root, int low, int high) {
        ArrayList<Integer> res = new ArrayList<>();
        printNearNodes(root, low, high, res);
        return res;
    }

}