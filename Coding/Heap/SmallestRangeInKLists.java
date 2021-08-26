// Given K sorted lists of integers of size N each, find the smallest range that
// includes at least one element from each of the K lists. If more than one such
// range's are found, find the first such range found.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/find-smallest-range-containing-elements-from-k-lists/1/

// YT - https://www.youtube.com/watch?v=Fqal25ZgEDo

// Input:
// N = 5, K = 3
// KSortedArray[][] = {{1 3 5 7 9},
// {0 2 4 6 8},
// {2 3 5 7 11}}
// Output: 1 2
// Explanation: K = 3
// A:[1 3 5 7 9]
// B:[0 2 4 6 8]
// C:[2 3 5 7 11]
// Smallest range is formed by number 1
// present in first list and 2 is present
// in both 2nd and 3rd list.

// Input:
// N = 4, K = 3
// KSortedArray[][] = {{1 2 3 4},
// {5 6 7 8},
// {9 10 11 12}}
// Output: 4 9

class Solution {
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

    static class MyComparator implements Comparator<HeapNode> {
        public int compare(HeapNode x, HeapNode y) {
            return x.val - y.val;
        }
    }

    static int[] findSmallestRange(int[][] arr, int n, int k) {
        int max = Integer.MIN_VALUE;
        int minRes = Integer.MAX_VALUE;
        int maxRes = 0;
        int diff = Integer.MAX_VALUE;
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(new MyComparator());
        int[] res = new int[2];

        // For the first elements of all k arrays
        for (int i = 0; i < k; i++) {
            // Find the maximum of them and also add all of them to the minHeap
            max = Math.max(max, arr[i][0]);
            minHeap.add(new HeapNode(arr[i][0], i, 0));
        }

        maxRes = max;
        minRes = minHeap.peek().val;
        diff = max - minRes;

        // Diff should be minimum

        while (true) {
            HeapNode minNode = minHeap.poll();

            // If max-min < diff, update diff, minRes and finMax
            if (max - minNode.val < diff) {
                diff = max - minNode.val;
                minRes = minNode.val;
                maxRes = max;
            }

            // If any one array has been traversed, break
            if (minNode.col == n - 1)
                break;

            // Update max if the next element is greater than the current one and push it to
            // the heap
            max = Math.max(max, arr[minNode.row][minNode.col + 1]);
            minHeap.add(new HeapNode(arr[minNode.row][minNode.col + 1], minNode.row, minNode.col + 1));

        }

        res[0] = minRes;
        res[1] = maxRes;
        return res;
    }
}
