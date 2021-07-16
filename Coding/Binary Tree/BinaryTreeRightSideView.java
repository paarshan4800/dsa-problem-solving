// Given the root of a binary tree, imagine yourself standing on the right side
// of it, return the values of the nodes you can see ordered from top to bottom.

// Leetcode - https://leetcode.com/problems/binary-tree-right-side-view/

// Input: root = [1,2,3,null,5,null,4]
// Output: [1,3,4]

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        // LEVEL ORDER TRAVERSAL

        List<Integer> res = new LinkedList<>();

        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // Add the last item of the queue to result
                if (i == size - 1)
                    res.add(current.val);

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }
        }

        return res;
    }
}

// Recursive Solution
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public void traverse(TreeNode root, int level, List<Integer> res) {
        if (root == null)
            return;

        if (level == res.size())
            res.add(root.val);

        traverse(root.right, level + 1, res);
        traverse(root.left, level + 1, res);

    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();

        if (root == null)
            return res;

        traverse(root, 0, res);

        return res;
    }
}