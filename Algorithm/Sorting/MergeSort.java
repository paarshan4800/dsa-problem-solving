// Input - [1,20,6,7,5,8,11,3]
// Output - [1,3,5,6,7,8,11,20]

class Solution {

    public void partition(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            partition(nums, low, mid);
            partition(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1;
        int iMax = mid, jMax = high;

        int temp[] = new int[high - low + 1];
        int index = 0;

        while (i <= iMax && j <= jMax) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        for (; i <= iMax; i++) {
            temp[index++] = nums[i];
        }

        for (; j <= jMax; j++) {
            temp[index++] = nums[j];
        }

        index = low;
        for (int p = 0; p < temp.length; p++, index++) {
            nums[index] = temp[p];
        }

    }

    public int[] sortArray(int[] nums) {
        partition(nums, 0, nums.length - 1);
        return nums;
    }
}