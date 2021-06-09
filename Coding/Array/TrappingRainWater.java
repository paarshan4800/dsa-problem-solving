// Given an array arr[] of N non-negative integers representing the height of
// blocks. If width of each block is 1, compute how much water can be trapped
// between the blocks during the rainy season.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1#

// Input:
// N = 6
// arr[] = {3,0,0,2,0,4}
// Output:
// 10

// Input:
// N = 4
// arr[] = {7,4,0,9}
// Output:
// 10

// One solution would be finding the left and right max of the current block on the go.
// Time Complexity - O(n^2)
// Space Complexity - O(1)

// Efficient Approach (Precompute and left and right max)
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.

    // Compute the left max array (for each element it has the max value to its left
    // side)
    static int[] getMaxLeftArr(int arr[], int n) {
        int[] maxLeft = new int[n];
        int curMax = arr[0];

        for (int i = 0; i < n; i++) {
            maxLeft[i] = curMax;
            curMax = Math.max(curMax, arr[i]);
        }
        return maxLeft;
    }

    // Compute the right max array (for each element it has the max value to its
    // right side)
    static int[] getMaxRightArr(int arr[], int n) {
        int[] maxRight = new int[n];
        int curMax = arr[n - 1];

        for (int i = n - 1; i >= 0; i--) {
            maxRight[i] = curMax;
            curMax = Math.max(curMax, arr[i]);
        }
        return maxRight;
    }

    static int trappingWater(int arr[], int n) {

        // Precompute left and right max array
        int[] maxLeft = getMaxLeftArr(arr, n);
        int[] maxRight = getMaxRightArr(arr, n);

        int res = 0;
        // Skip and first and last block since they cant store any water
        for (int i = 1; i < n - 1; i++) {
            // Find maximum water level of the current block
            int waterLevel = Math.min(maxLeft[i], maxRight[i]);

            // If waterLevel <= arr[i], water cant be stored in arr[i]
            // Else, update res
            if (waterLevel > arr[i]) {
                res += (waterLevel - arr[i]);
            }
        }

        return res;

    }
}
