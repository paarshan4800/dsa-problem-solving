import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left = null;
    TreeNode right = null;

    TreeNode(int data) {
        this.data = data;
    }
}

class Solution {

    public void inorder(TreeNode root) {
        if (root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ; ");
        inorder(root.right);
    }

    public TreeNode buildTree(String[] input) {
        if (input.length == 0)
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (i < input.length) {
            TreeNode current = queue.poll();

            if (input[i].equals("N")) {
                current.left = null;
            } else {
                current.left = new TreeNode(Integer.parseInt(input[i]));
                queue.add(current.left);
            }

            if (input[i + 1].equals("N")) {
                current.right = null;
            } else {
                current.right = new TreeNode(Integer.parseInt(input[i + 1]));
                queue.add(current.right);
            }

            i += 2;
        }

        return root;
    }
}

public class BinaryTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inp = scanner.nextLine();

        String[] input = inp.split(" ");

        Solution solution = new Solution();

        System.out.println("Building tree");
        TreeNode root = solution.buildTree(input);
        System.out.println("Inorder");
        solution.inorder(root);
        System.out.println();
    }
}
