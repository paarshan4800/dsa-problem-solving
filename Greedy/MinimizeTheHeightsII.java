// Given an array arr[] denoting heights of N towers and a positive integer K,
// you have to modify the height of each tower either by increasing or
// decreasing them by K only once. After modifying, height should be a
// non-negative integer.
// Find out what could be the possible minimum difference of the height of
// shortest and longest towers after you have modified each tower.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1#

// Input:
// K = 2, N = 4
// Arr[] = {1, 5, 8, 10}
// Output:
// 5
// Explanation:
// The array can be modified as
// {3, 3, 6, 8}. The difference between
// the largest and the smallest is 8-3 = 5.

// Input:
// K = 3, N = 5
// Arr[] = {3, 9, 12, 16, 20}
// Output:
// 11
// Explanation:
// The array can be modified as
// {6, 12, 9, 13, 17}. The difference between
// the largest and the smallest is 17-6 = 11.

class Solution {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);

        // Initial answer would be the difference of highest and lowest tower
        int res = arr[n - 1] - arr[0];

        // Initial smallest tower will be shortest + k
        int smallest = arr[0] + k;
        // Initial longest tower will be highest - k
        int largest = arr[n - 1] - k;

        for (int i = 1; i < n; i++) {
            int min = Math.min(smallest, arr[i] - k);
            int max = Math.max(largest, arr[i - 1] + k);

            if (min < 0)
                continue;

            res = Math.min(res, max - min);
        }

        return res;
    }
}
