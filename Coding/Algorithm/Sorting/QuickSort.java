// Time Complexity - O(nlogn) If the pivot is the median of the current window
// Worst case Time Complexity - O(nlogn) If the pivot is no where near the median of the current window
// Space Complexity - O(1)
class Solution {

    public void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            // Find the index of the pivot Element
            int pivot = partition(nums, low, high);

            // Break the array around the pivot element
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot + 1, high);
        }
    }

    public int partition(int[] nums, int low, int high) {
        // Take the last element of the window as pivot
        int pivot = nums[high];

        // indices < i have values less than pivot
        int i = low;

        // Traverse the current window using j
        for (int j = low; j < high; j++) {
            // If nums[j] < pivot, swap nums[j] with nums[i]
            // Increment i
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        // Swap nums[i] with nums[high] i.e the pivot
        swap(nums, i, high);

        // Return i which is the index of the pivot element
        // Indices < i have values less than the value at index i and indices > i have
        // values more than the value at index i
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
}