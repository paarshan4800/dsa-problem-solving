// Given K sorted arrays arranged in the form of a matrix of size K*K. The task
// is to merge them into one sorted array.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1/

// Input:
// K = 4
// arr[][]={{1,2,3,4}{2,2,3,4},
// {5,5,6,6},{7,8,9,9}}
// Output:
// 1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9
// Explanation: Above test case has 4 sorted
// arrays of size 4, 4, 4, 4
// arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4],
// [5, 5, 6, 6] [7, 8, 9, 9 ]]
// The merged list will be
// [1, 2, 2, 2, 3, 3, 4, 4, 5, 5,
// 6, 6, 7, 8, 9, 9 ].

class Solution {
    // Function to merge k sorted arrays.

    static class HeapNode {
        int val;
        int row;
        int col;

        HeapNode(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    static class HeapNodeComparator implements Comparator<HeapNode> {
        public int compare(HeapNode x, HeapNode y) {
            return x.val - y.val;
        }
    }

    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(new HeapNodeComparator());
        ArrayList<Integer> res = new ArrayList<>();

        // Add the first elements of all k matrices
        for (int i = 0; i < K; i++) {
            minHeap.add(new HeapNode(arr[i][0], i, 0));
        }

        while (!minHeap.isEmpty()) {
            // Pop the min heap and add it to res
            HeapNode cur = minHeap.poll();

            res.add(cur.val);

            // If still elements are there in the row of the popped out element, add it to
            // minHeap
            if (cur.col + 1 < K)
                minHeap.add(new HeapNode(arr[cur.row][cur.col + 1], cur.row, cur.col + 1));
        }

        return res;

    }
}