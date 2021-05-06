// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// Leetcode - https://leetcode.com/problems/single-number/

// Input: nums = [2,2,1]
// Output: 1

// Input: nums = [4,1,2,1,2]
// Output: 4

// Input: nums = [1]
// Output: 1

// O(n) - Time Complexity
// O(n) - Space Complexity

//Hash Map Approach. Hash stores val and count. Value with 1 as count is the result


// O(n) - Time Complexity
// O(1) - Space Complexity
class Solution {
    public int singleNumber(int[] nums) {

        // XOR Logic
        // XOR of two same numbers is zero. So they get cancelled out.
        // XOR of any number with zero is itself. So that remains at the end.
        
        int res = 0;
        
        for(int num:nums) {
            res ^= num;
        }
        
        return res;
        
    }
}