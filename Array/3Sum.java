// Given an integer array nums, return all the triplets [nums[i], nums[j],
// nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
// nums[k] == 0.

// Notice that the solution set must not contain duplicate triplets.

// Leetcode - https://leetcode.com/problems/3sum/

// Input: nums = [-1,0,1,2,-1,-4]
// Output: [[-1,-1,2],[-1,0,1]]

// Time Complexity - O(n^2)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Two Pointer Approach
        List<List<Integer>> res = new ArrayList<>();

        // If size < 3, no triplet possible
        if (nums.length < 3) {
            return res;
        }

        Arrays.sort(nums); // Sort the array

        for (int i = 0; i < nums.length - 2; i++) {

            // Condition to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    // Avoid duplicates
                    while (low < high && nums[low] == nums[low + 1]) {
                        low++;
                    }

                    // Avoid duplicates
                    while (low < high && nums[high] == nums[high - 1]) {
                        high--;
                    }

                    low++;
                    high--;
                } else if (sum > 0) {
                    high--;
                } else if (sum < 0) {
                    low++;
                }
            }
        }

        return res;
    }
}