// Given a string S of distinct character of size N and their corresponding
// frequency f[ ] i.e. character S[i] has f[i] frequency. Your task is to build
// the Huffman tree print all the huffman codes in preorder traversal of the
// tree.
// Note: If two elements have same frequency, then the element which occur at
// first will be taken on the left of Binary Tree and other one to the right.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/huffman-encoding3345/1/

// S = "abcdef"
// f[] = {5, 9, 12, 13, 16, 45}
// Output:
// 0 100 101 1100 1101 111
// Explanation:
// HuffmanCodes will be:
// f : 0
// c : 100
// d : 101
// a : 1100
// b : 1101
// e : 111
// Hence printing them in the PreOrder of Binary
// Tree.

class Solution {

    class HeapNode {
        char letter;
        int count;
        HeapNode left = null;
        HeapNode right = null;

        HeapNode(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
    }

    class MyComparator implements Comparator<HeapNode> {
        public int compare(HeapNode x, HeapNode y) {
            // Same frequency, retain the same order (given in question)
            if (x.count == y.count)
                return 1;
            return x.count - y.count;
        }
    }

    public void preorder(HeapNode root, ArrayList<String> res, String path) {
        // Preorder Traversal
        if (root.left == null && root.right == null && Character.isLetter(root.letter)) {
            res.add(path);
            return;
        }

        // Left path means "0"
        preorder(root.left, res, path + "0");

        // Left path means "1"
        preorder(root.right, res, path + "1");
    }

    public ArrayList<String> huffmanCodes(String S, int f[], int N) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(new MyComparator());

        // Insert letter with frequency into the minHeap
        for (int i = 0; i < N; i++) {
            minHeap.add(new HeapNode(S.charAt(i), f[i]));
        }

        HeapNode root = null;

        while (minHeap.size() > 1) {
            HeapNode x = minHeap.poll();
            HeapNode y = minHeap.poll();

            // The root will have frequency of left node + right node
            HeapNode newNode = new HeapNode('-', x.count + y.count);
            newNode.left = x;
            newNode.right = y;

            root = newNode;
            minHeap.add(newNode);
        }

        ArrayList<String> res = new ArrayList<>();
        preorder(root, res, "");
        return res;
    }
}