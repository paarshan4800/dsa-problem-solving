// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// Leetcode - https://leetcode.com/problems/move-zeroes/

// O(n^2) - Time Complexity (Accepted)
// O(1) - Space Complexity

// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]

// Input: nums = [0]
// Output: [0]

class Solution1 {
    public void moveZeroes(int[] nums) {

        int size = nums.length;

        // If size == 1, no operation needed.
        if (size == 1) {
            return;
        }

        // Iterator i keeps track of zeroes
        int i = 0;
        // Iterate array till we reach the first zero
        for (; i < size; i++) {
            if (nums[i] == 0) {
                break;
            }
        }

        // Traverse till we reach the end
        for (; i < size - 1; i++) {
            // iterator j searches for non-zero element
            for (int j = i + 1; j < size; j++) {
                // If non-zero element found, swap it with the zero in nums[i]
                if (nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }

    }
}

// Efficient Approach
// O(n) - Time Complexity
// O(1) - Space Complexity
class Solution2 {
    public void moveZeroes(int[] nums) {

        // This holds the index of the last known non-zero element
        int lastNonZeroIndex = 0;
        int size = nums.length;

        // Traverse
        for (int i = 0; i < size; i++) {
            // If non-zero element found, make num[lastNonZeroIndex] = that non-zero element
            // and increment lastNonZeroIndex so that we keep track of that
            if (nums[i] != 0) {
                nums[lastNonZeroIndex++] = nums[i];
            }
        }

        // Then traverse till lastNonZeroIndex<size and make num[lastNonZeroIndex] = 0
        for (; lastNonZeroIndex < size; lastNonZeroIndex++) {
            nums[lastNonZeroIndex] = 0;
        }

    }
}