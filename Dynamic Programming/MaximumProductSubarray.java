// Given an array Arr that contains N integers (may be positive, negative or
// zero). Find the product of the maximum product subarray.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1/

// Input:
// N = 5
// Arr[] = {6, -3, -10, 0, 2}
// Output: 180
// Explanation: Subarray with maximum product
// is 6, -3, -10 which gives product as 180.

// Input:
// N = 6
// Arr[] = {2, 3, 4, 5, -1, 0}
// Output: 120
// Explanation: Subarray with maximum product
// is 2, 3, 4, 5 which gives product as 120.

// Time Complexity - O(n)
class Solution {
    long maxProduct(int[] arr, int n) {
        long res = Integer.MIN_VALUE;

        // Atleast the result would be the maximum of given elements
        for (int num : arr)
            res = Math.max(res, num);

        // Base subproblem - subarray of size 1
        long curMax = arr[0], curMin = arr[0];

        for (int i = 1; i < n; i++) {
            long tempCurMax = curMax;

            // If curMax = arr[i] -> extending the prev subarray doesnt give a max value (so
            // start a new subarray by taking arr[i] as curMax)
            // If curMax = curMax * arr[i] -> extending the prev subarray gives a max value
            // If curMax = curMin * arr[i] -> extending the prev subarray gives a max value
            curMax = Math.max(arr[i], Math.max(curMax * arr[i], curMin * arr[i]));

            // Also get the minValue, since it might yield to max value if the next element
            // is a negative number
            curMin = Math.min(arr[i], Math.min(tempCurMax * arr[i], curMin * arr[i]));

            // Update res
            res = Math.max(res, curMax);
        }

        return res;
    }
}