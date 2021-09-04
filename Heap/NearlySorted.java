// Given an array of n elements, where each element is at most k away from its
// target position, you need to sort the array optimally.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1/

// Input:
// n = 7, k = 3
// arr[] = {6,5,3,2,8,10,9}
// Output: 2 3 5 6 8 9 10
// Explanation: The sorted array will be
// 2 3 5 6 8 9 10

class Solution {
    // Function to return the sorted array.
    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Add first k to min heap
        for (int i = 0; i < k; i++)
            minHeap.add(arr[i]);

        // For the remaining elements
        for (int i = k; i < arr.length; i++) {
            // Add element to minHeap so that size would be k+1
            minHeap.add(arr[i]);
            // Top of the minHeap would have the minimum element of the window of size k+1
            res.add(minHeap.poll());
        }

        while (!minHeap.isEmpty())
            res.add(minHeap.poll());

        return res;
    }
}
