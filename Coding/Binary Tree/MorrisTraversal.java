// Time Complexity - O(n)
// Space Complexity - O(1)

// Inorder Traversal
class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        TreeNode current = root;

        while (current != null) {
            // If there is no left subtree to be traversed, add the current node to res and
            // move on to the right subtree
            if (current.left == null) {
                res.add(current.val);
                current = current.right;
            }
            // If there is left subtree
            else {
                // Find the inorder predecessor
                TreeNode predecessor = current.left;

                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // Make a link from the predecessor to the current node and move further ahead
                // on the left subtree
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                // Else executes only when predecessor.right == current which means we have
                // processed all the nodes of the left subtree. So now add current to the res
                // and move on to the right subtree
                else {
                    predecessor.right = null; // Remove the temporary link
                    res.add(current.val);
                    current = current.right;
                }
            }
        }

        return res;
    }

}

// Preorder Travesal
class Solution {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null) {
            return res;
        }

        TreeNode current = root;

        while (current != null) {
            // If there is no left subtree to be traversed, add the current node to res and
            // move on to the right subtree
            if (current.left == null) {
                res.add(current.val);
                current = current.right;
            }
            // If there is left subtree
            else {
                // Find the inorder predecessor
                TreeNode predecessor = current.left;

                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // now add current to the res and Make a link from the predecessor to the
                // current node and move further ahead on the left subtree
                if (predecessor.right == null) {
                    res.add(current.val);
                    predecessor.right = current;
                    current = current.left;
                }
                // Else executes only when predecessor.right == current which means we have
                // processed all the nodes of the left subtree. So move on to the right subtree
                else {
                    predecessor.right = null; // Remove the temporary link
                    current = current.right;
                }
            }
        }

        return res;
    }
}