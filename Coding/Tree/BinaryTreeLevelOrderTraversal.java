// Given the root of a binary tree, return the level order traversal of its
// nodes' values. (i.e., from left to right, level by level).

// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/94/trees/628/

// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Input: root = [1]
// Output: [[1]]

// Input: root = []
// Output: []

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        // Breadth First Search Approach

        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        // We use queue because we need to process all the nodes in the level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Till queue is not empty
        while (!queue.isEmpty()) {
            // Current queue size tells the level size
            int levelSize = queue.size();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll(); // Pop out to process

                temp.add(cur.val); // Add to temp

                // Push left and right child into the queue
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            res.add(temp); // Add temp to res
        }

        return res;

    }
}