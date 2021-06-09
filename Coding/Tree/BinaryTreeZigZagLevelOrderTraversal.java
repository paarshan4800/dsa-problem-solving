// Given the root of a binary tree, return the zigzag level order traversal of
// its nodes' values. (i.e., from left to right, then right to left for the next
// level and alternate between).

// Leetcode -
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

// Using two stacks - Iterative
// Time Complexity - O(n)
// Space Complexity - O(max width of binary tree)
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            // First stack stores element such that they are process later right to left
            while (!stack1.isEmpty()) {
                TreeNode cur = stack1.pop();
                temp.add(cur.val);
                if (cur.left != null) {
                    stack2.push(cur.left);
                }
                if (cur.right != null) {
                    stack2.push(cur.right);
                }
            }

            res.add(temp);

            temp = new ArrayList<>();
            // Second stack stores element such that they are process later left to right
            while (!stack2.isEmpty()) {
                TreeNode cur = stack2.pop();
                temp.add(cur.val);
                if (cur.right != null) {
                    stack1.push(cur.right);
                }
                if (cur.left != null) {
                    stack1.push(cur.left);
                }
            }
            if (temp.size() > 0) {
                res.add(temp);
            }
        }

        return res;

    }
}

// Recursive Solution
// Time Complexity - O(n^2) in case of skewed trees
class Solution {

    // Find height of the tree
    public int findHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public void zigzagLevelOrder(TreeNode root, int level, List<Integer> temp, boolean leftToRight) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            temp.add(root.val);
        } else {
            // Depending on leftToRight, we first recur down left and right alternatively
            if (leftToRight) {
                zigzagLevelOrder(root.left, level - 1, temp, leftToRight);
                zigzagLevelOrder(root.right, level - 1, temp, leftToRight);
            } else {
                zigzagLevelOrder(root.right, level - 1, temp, leftToRight);
                zigzagLevelOrder(root.left, level - 1, temp, leftToRight);
            }
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int height = findHeight(root);
        boolean leftToRight = true;

        for (int i = 1; i <= height; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            zigzagLevelOrder(root, i, temp, leftToRight);
            leftToRight = !leftToRight;
            res.add(temp);
        }

        return res;
    }
}