// Given an array of non-negative integers, and a value sum, determine if there
// is a subset of the given set with sum equal to given sum.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/

// Input:
// N = 6
// arr[] = {3, 34, 4, 12, 5, 2}
// sum = 9
// Output: 1
// Explanation: Here there exists a subset with
// sum = 9, 4+3+2 = 9.

// Input:
// N = 6
// arr[] = {3, 34, 4, 12, 5, 2}
// sum = 30
// Output: 0
// Explanation: There is no subset with sum 30.

class Solution {

    static Boolean isSubsetSum(int i, int N, int[] arr, int sum) {

        // If sum == 0, return true
        if (sum == 0) {
            return true;
        }

        // Boundary condition
        if (i == N || sum < 0) {
            return false;
        }

        // Make two branches
        // i) Dont include the ith element
        // ii) Include the ith element
        if (isSubsetSum(i + 1, N, arr, sum) || isSubsetSum(i + 1, N, arr, sum - arr[i])) {
            return true;
        }
        
        return false;
    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {
        return isSubsetSum(0, N, arr, sum);
    }
}