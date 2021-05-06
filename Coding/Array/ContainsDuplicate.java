// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
// Leetcode - https://leetcode.com/problems/contains-duplicate/

// O(nlogn) - Time Complexity
// Sort the array and check if arr[i] == arr[i+1] while traversing the array


// O(n) - Time Complexity
// O(n) - Space Complexity

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // Hash
        Set<Integer> hash = new HashSet<Integer>();
        
        // Traverse
        for(int num:nums) {
            // If num is stored in hash, then its a duplicate, return true
            if(hash.contains(num)) {
                return true;
            }

            // Add it to the hash
            hash.add(num);
        }
        
        // If the for loop executes, then no duplicate, return false
        return false;
        
    }
}