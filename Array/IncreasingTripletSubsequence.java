// Given an integer array nums, return true if there exists a triple of indices
// (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such
// indices exists, return false.

// Leetcode - https://leetcode.com/problems/increasing-triplet-subsequence/

// Input: nums = [1,2,3,4,5]
// Output: true

// Input: nums = [5,4,3,2,1]
// Output: false

// Input: nums = [2,1,5,0,4,6]
// Output: true

// Find the first minimum and then the second minimum. The next number which is
// greater than first and second minimum is the third element of the triplet
// Time Complexity - O(n)
// Space Complexity - O(1)

class Solution {
    public boolean increasingTriplet(int[] nums) {

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            // Find first minimum value of the triple
            if (num <= min1) {
                min1 = num;
            }
            // Find second minimum value of the triple
            else if (num <= min2) {
                min2 = num;
            }
            // Execution of else means the current num is the third element of the triplet
            else {
                return true;
            }
        }

        return false;

    }
}