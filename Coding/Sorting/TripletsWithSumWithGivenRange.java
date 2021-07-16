// Given an array Arr[] of N distinct integers and a range from L to R, the task
// is to count the number of triplets having a sum in the range [L, R].

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/triplets-with-sum-with-given-range/1/#

// Input:
// N = 5
// Arr = {5, 1, 4, 3, 2}
// L = 2, R = 7
// Output: 2

// Input : arr[] = {2, 7, 5, 3, 8, 4, 1, 9}
// range = [8, 16]
// Output : 36

// Brute Force Approach
// Generate all possible triplets with three for loops
// Time Complexity - O(n^3)

// Efficient Approach
// Two Pointer Approach
// Time Complexity - O(n^2)

class Solution {

    static int findTripletsLessThan(int[] arr, int val) {
        int res = 0;

        for (int i = arr.length - 1; i >= 2; i--) {
            int low = 0, high = i - 1;
            while (low < high) {
                int sum = arr[low] + arr[high] + arr[i];
                if (sum <= val) {
                    res += (high - low);
                    low++;
                } else {
                    high--;
                }
            }
        }

        return res;
    }

    static int countTriplets(int arr[], int N, int L, int R) {
        Arrays.sort(arr); // Sort the given array

        // Find the number of triplets whose sum are less than or equal to the upper
        // bound
        // Find the number of triplets whose sum are less than the lower bound
        // Subtract those two which is the result

        return findTripletsLessThan(arr, R) - findTripletsLessThan(arr, L - 1);
    }
}
