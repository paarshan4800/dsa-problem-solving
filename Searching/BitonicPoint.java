// Given an array arr of n elements which is first increasing and then may be
// decreasing, find the maximum element in the array.
// Note: If the array is increasing then just print then last element will be
// the maximum value.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1#

// Input:
// n = 9
// arr[] = {1,15,25,45,42,21,17,12,11}
// Output: 45

// Input:
// n = 5
// arr[] = {1, 45, 47, 50, 5}
// Output: 50

// Time Complexity - O(logn)
class Solution {
    int findMaximum(int[] arr, int n) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If arr[mid] >= arr[mid+1], it is decreasing, the bitonic point maybe mid or
            // to the left of mid
            if (arr[mid] >= arr[mid + 1]) {
                high = mid;
            }
            // If arr[mid] < arr[mid+1], it is increasing, the bitonic point is to the right
            // of mid
            else {
                low = mid + 1;
            }
        }

        return arr[high];
    }
}