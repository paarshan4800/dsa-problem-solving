// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You
// may assume that the majority element always exists in the array.

// Leetcode - https://leetcode.com/problems/majority-element/

// Input: nums = [3,2,3]
// Output: 3

// Input: nums = [2,2,1,1,1,2,2]
// Output: 2

// Use HashMap and store values with their frequencies.
// Return the val with freq > n/2
// Time Complexity - O(n)
// Space Complexity - O(n)

// Another Approach
// Sort the given array. arr[n/2] is the majority element because they have
// given that the majority element should have a frequency greater than n/2 (so
// it will cover atleast half of the array)
// Time Complexity - O(nlogn)
// Space Complexity - O(1)

// Boyer-Moore Voting Algorithm
// Intuition - If we had some way of counting instances of the majority element as
//  +1 and instances of any other element as -1, summing them would make it
//  obvious that the majority element is indeed the majority element.
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // If count == 0, set current num as candidate (reset)
            if (count == 0) {
                candidate = num;
            }

            // If num == candidate, increment count
            if (num == candidate) {
                count += 1;
            }
            // Else decrement count
            else {
                count -= 1;
            }
        }

        return candidate;
    }
}