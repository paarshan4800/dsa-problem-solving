// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
// Leetcode - https://leetcode.com/problems/missing-number/
// GeeksForGeeks - Must do questions topic wise

// Input: nums = [3,0,1]
// Output: 2

// Input: nums = [0,1]
// Output: 2

// Input: nums = [9,6,4,2,3,5,7,0,1]
// Output: 8

// Input: nums = [0]
// Output: 1

// O(n) - Time Complexity
// O(n) - Space Complexity
class Solution1 {
    public int missingNumber(int[] nums) {
        // Hashing Logic  

        // By default initializes to false
        boolean[] hash = new boolean[nums.length+1];
        
        // with num as index, change hash[num] to true i.e we have come past this number
        for(int num:nums) {
            hash[num] = true;
        }
        
        // Traverse through the hash, return the index of the element which is false
        // i.e we haven't come past this number
        for(int i=0;i<hash.length;i++) {
            if(!hash[i]) {
                return i;
            }
        }
        
        return -1;
    }
}

// O(n) - Time Complexity
// O(1) - Space Complexity
class Solution2 {
    public int missingNumber(int[] nums) {
        
        // Find the sum of n natural numbers logic (as they given constraints in the question)

        // Find sum of first n natural numbers by using n(n+1)/2
        int n = nums.length;
        int sumOfNNaturalNumbers = n*(n+1)/2;

        // Find the sum of all elements in the given array
        int sum=0;
        for(int i=0;i<nums.length;i++) {
            sum+=nums[i];
        }
        
        // Difference between these two is the answer
        return sumOfNNaturalNumbers-sum;
    }
}
