// Given an integer array a[ ] of N elements and an integer K, the task is to
// check if the array a[ ] could be divided into K non-empty subsets with equal
// sum of elements.
// Note: All elements of this array should be part of exactly one partition.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/partition-array-to-k-subsets/1/

// Input:
// N = 5
// a[] = {2,1,4,5,6}
// K = 3
// Output:
// 1
// Explanation: we can divide above array
// into 3 parts with equal sum as (2, 4),
// (1, 5), (6)

// Input:
// N = 5
// a[] = {2,1,5,5,6}
// K = 3
// Output:
// 0
// Explanation: It is not possible to divide
// above array into 3 parts with equal sum.

class Solution {
    public int getSum(int arr[], int n) {
        int sum = 0;

        for (int val : arr)
            sum += val;

        return sum;
    }

    public boolean isKPartitionPossibleUtil(int arr[], int n, int k, int index, int currentSum, int bucketSum,
            boolean[] used) {

        // If k reaches 1, then partition is possible. Return true
        if (k == 1)
            return true;

        // If current sum of bucket reaches the required sum of a bucket, reset index
        // and current sum and move to the next bucket
        if (currentSum == bucketSum)
            return isKPartitionPossibleUtil(arr, n, k - 1, 0, 0, bucketSum, used);

        for (int i = index; i < n; i++) {
            // If the value hasn't been used yet
            if (!used[i]) {
                used[i] = true; // CHOOSE

                // Move index to next val and increase current sum of the bucket
                if (isKPartitionPossibleUtil(arr, n, k, i + 1, currentSum + arr[i], bucketSum, used))
                    return true;

                used[i] = false; // UNCHOOSE (BACKTRACK)
            }
        }

        return false;

    }

    public boolean isKPartitionPossible(int a[], int n, int k) {
        int totalSum = getSum(a, n);

        // If total sum of the array is not divisible by k, then partition not possible
        if (totalSum % k != 0)
            return false;

        // Each bucket should have a equal sum of totalSum/k
        int bucketSum = totalSum / k;

        boolean[] used = new boolean[n];

        return isKPartitionPossibleUtil(a, n, k, 0, 0, bucketSum, used);
    }
}
