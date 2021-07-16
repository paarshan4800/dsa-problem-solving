// Serialization is the process of converting a data structure or object into a
// sequence of bits so that it can be stored in a file or memory buffer, or
// transmitted across a network connection link to be reconstructed later in the
// same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no
// restriction on how your serialization/deserialization algorithm should work.
// You just need to ensure that a binary tree can be serialized to a string and
// this string can be deserialized to the original tree structure

// Leetcode -
// https://leetcode.com/explore/learn/card/data-structure-tree/133/conclusion/995/

// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        // Serialize the binary tree in Level Order Traversal fashion
        // , acts as a delimitter and # acts as a null

        StringBuilder res = new StringBuilder();

        if (root == null) {
            res.append("#");
            return res.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // If null, append #, to res
                if (current == null) {
                    res.append("#,");
                    continue;
                }

                // If not null, append value and , to res
                res.append(Integer.toString(current.val));
                res.append(",");

                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return res.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // Split by ","
        String[] nodes = data.split(",");

        // If length is 1, it means root is null. So return null
        if (nodes.length == 1)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);

        int i = 1;
        while (i < nodes.length) {
            TreeNode current = queue.poll();

            if (nodes[i].equals("#")) {
                current.left = null;
            } else {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }

            if (nodes[i + 1].equals("#")) {
                current.right = null;
            } else {
                current.right = new TreeNode(Integer.parseInt(nodes[i + 1]));
                queue.add(current.right);
            }

            i += 2;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));