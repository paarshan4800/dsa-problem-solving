// Given integer array nums, return the third maximum number in this array. If
// the third maximum does not exist, return the maximum number.

// Leetcode - https://leetcode.com/problems/third-maximum-number/

// Input: nums = [3,2,1]
// Output: 1

// Input: nums = [1,2]
// Output: 2

// Input: nums = [2,2,3,1]
// Output: 1

// Use Priority Queue (Collections.reverseOrder) which acts as a max heap.
// Push everything into the max heap and only distinct elements (by checking
// using the contains() method)
// Pop two elements and the third one is the answer
// Time Complexity - O(n)
// Space Complexity - O(n)

// Efficient Approach
// Time Complexity - O(n)
// Space Complexity - O(1)

class Solution {
    public int thirdMax(int[] nums) {
        Integer firstMax = null, secondMax = null, thirdMax = null;

        for (Integer num : nums) {
            // If duplicate element, skip
            if (num.equals(firstMax) || num.equals(secondMax) || num.equals(thirdMax)) {
                continue;
            }

            // firstMax == null ---> this is the first element
            // num > firstMax ---> we have to shift firstMax and secondMax to secondMax and
            // thirdMax respectively to make space for num to be stored in firstMax
            if (firstMax == null || num > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            }
            // secondMax == null ---> this is the second element
            // num > secondMax ---> we have to shift secondMax to thirdMax to make space for
            // num to be stored in secondMax
            else if (secondMax == null || num > secondMax) {
                thirdMax = secondMax;
                secondMax = num;
            }
            // thirdMax == null ---> this is the third element
            // num > thirdMax ---> we have to change thirdMax to num
            else if (thirdMax == null || num > thirdMax) {
                thirdMax = num;
            }
        }

        if (thirdMax != null) {
            return thirdMax;
        }

        return firstMax;

    }
}