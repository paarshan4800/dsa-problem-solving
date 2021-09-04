// Given the array nums, for each nums[i] find out how many numbers in the array
// are smaller than it. That is, for each nums[i] you have to count the number
// of valid j's such that j != i and nums[j] < nums[i].

// Return the answer in an array.

// Leetcode -
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

// Input: nums = [8,1,2,2,3]
// Output: [4,0,1,1,3]

// Input: nums = [6,5,4,8]
// Output: [2,1,0,3]

// Input: nums = [7,7,7,7]
// Output: [0,0,0,0]

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] res = new int[nums.length];
        int[] hash = new int[101];

        // Hash stores the frequency with nums[i] acting as index
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        // Answer for i is hash[i] + hash[i-1]
        for (int i = 1; i <= 100; i++) {
            hash[i] = hash[i] + hash[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            // For 0, there is no smaller number, so res[i] is 0
            if (nums[i] == 0) {
                res[i] = 0;
                continue;
            }

            // hash[nums[i]-1] has the answer for nums[i]
            res[i] = hash[nums[i] - 1];
        }

        return res;

    }
}