// Given a Binary Tree of size N, find all the nodes which don't have any
// sibling. Root node can not have a sibling.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/print-all-nodes-that-dont-have-sibling/1#

class Tree {

    // PREORDER TRAVERSAL

    public void preorder(Node root, ArrayList<Integer> res) {

        // Base condition
        if (root == null)
            return;

        // If leaf node, return
        if (root.left == null && root.right == null) {
            return;
        }

        // If left child is not there, right child would be there (previous condition
        // failed). Add right child data to res
        if (root.left == null)
            res.add(root.right.data);

        // If right child is not there, left child would be there (previous condition
        // failed). Add left child data to res
        if (root.right == null)
            res.add(root.left.data);

        // Recur left
        preorder(root.left, res);

        // Recur right
        preorder(root.right, res);

    }

    ArrayList<Integer> noSibling(Node node) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();

        preorder(node, res);

        if (res.size() == 0) {
            res.add(-1);
        }

        Collections.sort(res);

        return res;
    }
}