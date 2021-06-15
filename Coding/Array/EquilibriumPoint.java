// Given an array A of n positive numbers. The task is to find the first
// Equilibium Point in the array.
// Equilibrium Point in an array is a position such that the sum of elements
// before it is equal to the sum of elements after it.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1#

// n = 1
// A[] = {1}
// Output: 1

// Input:
// n = 5
// A[] = {1,3,5,2,2}
// Output: 3

// Brute Force Solution
// For every element, calculate the sum of its right side and left side and compare
// Time Complexity - O(n^2)
// Space Complexity - O(1)

// Efficient Approach
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {

    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.

    // Helper method to get sum
    public static long getSum(long arr[]) {
        long sum = 0;
        for (long num : arr) {
            sum += num;
        }
        return sum;
    }

    public static int equilibriumPoint(long arr[], int n) {
        // If arr length is 1, then that it is the equilibrium point
        if (arr.length == 1)
            return 1;

        long lSum = 0, rSum = getSum(arr);

        for (int i = 0; i < n; i++) {
            // Considering i'th index as the equilibrium point
            // rSum will be rSum - arr[i]

            rSum -= arr[i];

            // If lSum == rSum, i+1 is the equilibrium point
            if (lSum == rSum) {
                return i + 1;
            }

            // If not, for next iteration, lSum will lSum + arr[i]
            lSum += arr[i];
        }

        return -1;
    }
}