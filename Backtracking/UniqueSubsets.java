// Given an integer array nums that may contain duplicates, return all possible
// subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in
// any order.

// Leetcode - https://leetcode.com/problems/subsets-ii/

// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

class Solution {

    public void findSubsets(int[] nums, ArrayList<Integer> current, int index, List<List<Integer>> res) {

        // Add the current set to result
        res.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            // If current character and prev character are same, then duplicates may occur.
            // So skip the current iteration
            if (i > index && nums[i] == nums[i - 1])
                continue;

            // If the above if condition fails, then surely there are no duplicates. So add
            // it to the current set and recur
            current.add(nums[i]);
            findSubsets(nums, current, i + 1, res);

            // After recurring remove the last element added to current set
            current.remove(current.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Sort the array. Makes avoiding duplicates easier.
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(nums, new ArrayList<>(), 0, res);
        return res;
    }

}