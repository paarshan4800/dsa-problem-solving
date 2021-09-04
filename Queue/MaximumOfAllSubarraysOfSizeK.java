// Given an array arr[] of size N and an integer K. Find the maximum for each
// and every contiguous subarray of size K.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1#

// Input:
// N = 9, K = 3
// arr[] = 1 2 3 1 4 5 2 3 6
// Output:
// 3 3 4 5 5 5 6

// Input:
// N = 10, K = 4
// arr[] = 8 5 10 7 9 4 15 12 90 13
// Output:
// 10 10 10 15 15 90 90

// Brute Force
// For every contiguos subarrays of size k, find max
// Time Complexity - O(n*k)
// Space Complexity - O(n*k)

// Using Max Heap
// Push first k elements into max heap. Top of the heap returns the max of contiguos 
// subarray of size k. Remove a[0] from max heap and add a[k] and so on
// Time Complexity - O(n*logk)
// Space Complexity - O(k)

// Using Deque
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    // Function to find maximum of each subarray of size k.
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        int i = 0;
        Deque<Integer> dq = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        // Process first k elements
        for (; i < k; i++) {
            // Till dq is not empty and arr[i] >= tail of dq, we remove last element from
            // dq. Anything less than or equal to arr[i] in dq is useless
            while (!dq.isEmpty() && arr[i] >= arr[dq.getLast()]) {
                dq.removeLast();
            }
            // Add i to dq
            dq.addLast(i);
        }

        for (; i < n; i++) {
            res.add(arr[dq.getFirst()]); // dq first has the max of contiguos subarray of size k

            // remove elements if they are not within the current subarray i.e i-k
            while (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }

            // REPEAT
            // Till dq is not empty and arr[i] >= tail of dq, we remove last element from
            // dq. Anything less than or equal to arr[i] in dq is useless
            while (!dq.isEmpty() && arr[i] >= arr[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);

        }
        res.add(arr[dq.getFirst()]);

        return res;
    }
}