// Time Complexity - O(n^2)
// Time Complexity - O(n) when array is almost sorted
// Space Complexity - O(1)
class Solution {

    public void insertionSort(int[] nums) {
        // Indices <i are in sorted order after each iteration
        for (int i = 1; i < nums.length; i++) {
            // Hold the current element which is processed
            int current = nums[i];
            int j = i;

            // Trace backwards and find a place to insert current by shifting elements
            // towards the right
            while (j - 1 >= 0 && nums[j - 1] > current) {
                nums[j] = nums[j - 1];
                j--;
            }

            // j is the right place to insert current
            nums[j] = current;
        }

    }

    public int[] sortArray(int[] nums) {
        insertionSort(nums);
        return nums;
    }
}