// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// Leetcode - https://leetcode.com/problems/two-sum/

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

// Input: nums = [3,2,4], target = 6
// Output: [1,2]

// Input: nums = [3,3], target = 6
// Output: [0,1]

// O(n+n) - Time Complexity
// O(n) - Space Complexity

// Two Traversal Solution
//Traverse once and store all the values in the hash with its index
// Then traverse again. Calculate the difference between target and the current element.
// If that is present in the hash, then thats the solution


// O(n) - Time Complexity
// O(n) - Space Complexity

// Single Traversal Solution
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        
        for(int i=0;i<nums.length;i++) {
            
            //Calculate difference between target and the current element
            int diff = target - nums[i];
            
            // If the hash contains the difference, then we have already came across this value.
            // Iterator i and the value of the diff in hash are the solution
            if(hash.containsKey(diff)) {
                return new int[]{hash.get(diff),i};
            }
            
            // Else insert the current element with its index into the hash
            hash.put(nums[i],i);
        }
        
        return new int[]{0,0};
        
    }
}