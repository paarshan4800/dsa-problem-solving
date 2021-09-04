// Given an integer N, find its factorial.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#

// Input: N = 5
// Output: 120
// Explanation : 5! = 1*2*3*4*5 = 120

// Input: N = 10
// Output: 3628800
// Explanation :
// 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800

class Solution {

    static class Node {
        int data;
        Node prev = null;

        Node() {
            this.data = 0;
        }

        Node(int data) {
            this.data = data;
        }
    }

    static void multiply(Node root, int n) {
        int carry = 0;

        do {
            int mult = carry + (root.data * n);
            root.data = mult % 10;
            carry = mult / 10;

            // If there is carry to be forwarded and no node is there to be forwarded,
            // create a new node
            if (carry != 0 && root.prev == null) {
                root.prev = new Node();
            }

            // Move to prev node
            root = root.prev;
        }
        // If carry is there or still numbers are left
        while (carry != 0 || root != null);

    }

    static ArrayList<Integer> factorial(int N) {
        // For 1!, it would be 1
        Node root = new Node(1);

        for (int n = 2; n <= N; n++) {
            multiply(root, n);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (Node temp = root; temp != null; temp = temp.prev) {
            res.add(0, temp.data);
        }

        return res;

    }
}