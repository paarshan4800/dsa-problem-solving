// Given an array nums of non-negative integers, return an array consisting of
// all the even elements of nums, followed by all the odd elements of nums.

// You may return any answer array that satisfies this condition.

// Leetcode - https://leetcode.com/problems/sort-array-by-parity/

// Input: nums = [3,1,2,4]
// Output: [2,4,3,1]
// The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

// Two traversal method
// First traverse and store even elements and then traverse again and store odd ones
// Time Complexity - O(2n)
// Space Complexity - O(n)

// In-place (Quick Sort Method)
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {

    public boolean isEven(int n) {
        return (n % 2 == 0) ? true : false;
    }

    public int[] sortArrayByParity(int[] nums) {

        int i = 0, j = nums.length - 1;

        while (i < j) {
            // If nums[i] is odd and nums[j] is even, swap
            if (!isEven(nums[i]) && isEven(nums[j])) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            // If nums[i] is even, go to next element (i++)
            if (isEven(nums[i])) {
                i++;
            }

            // If nums[j] is odd, go to next element (j--)
            if (!isEven(nums[j])) {
                j--;
            }
        }

        return nums;

    }
}
