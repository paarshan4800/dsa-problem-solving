// Given an unsorted array A of size N that contains only non-negative integers,
// find a continuous sub-array which adds to a given number S.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1

// Input:
// N = 5, S = 12
// A[] = {1,2,3,7,5}
// Output: 2 4

// Input:
// N = 10, S = 15
// A[] = {1,2,3,4,5,6,7,8,9,10}
// Output: 1 5

// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    // Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // Your code here
        int start = 0, end = 0;
        long sum = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();

        while (end < n) {
            if (sum == s) {
                res.add(start + 1);
                res.add(end);
                return res;
            }
            // Expand the window if start and end are at the same index or sum < target
            else if (start == end || sum < s) {
                sum += arr[end];
                end++;
            }
            // Contract the window if sum > target
            else {
                sum -= arr[start];
                start++;
            }
        }

        res.add(-1);
        return res;

    }
}