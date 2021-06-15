// Given an array of integers. Find the Inversion Count in the array.

// Inversion Count: For an array, inversion count indicates how far (or close)
// the array is from being sorted. If array is already sorted then the inversion
// count is 0. If an array is sorted in the reverse order then the inversion
// count is the maximum.
// Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i <
// j.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1#

// Input: N = 5, arr[] = {2, 4, 1, 3, 5}
// Output: 3
// Explanation: The sequence 2, 4, 1, 3, 5
// has three inversions (2, 1), (4, 1), (4, 3).

// Input: N = 5
// arr[] = {2, 3, 4, 5, 6}
// Output: 0

// Brute Force Approach
// For each element, check how many elements are larger than it to its right
// side
// Time Complexity - O(n^2)
// Space Complexity - O(1)

// Efficient Approach - Merge Sort
// Time Complexity - O(nlogn)
// Space Complexity - O(n)
class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.

    public static long partition(long[] nums, int low, int high) {
        long res = 0;
        if (low < high) {
            int mid = low + (high - low) / 2;
            res += partition(nums, low, mid);
            res += partition(nums, mid + 1, high);
            res += merge(nums, low, mid, high);
        }
        return res;
    }

    public static long merge(long[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1;
        int iMax = mid, jMax = high;
        long res = 0;

        long temp[] = new long[high - low + 1];
        int index = 0;

        while (i <= iMax && j <= jMax) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                // If nums[i] > nums[j], then all elements to the right side (greater than
                // nums[i]) will also be greater than nums[j] which will all contribute to the
                // inversion count. So we add iMax - i + 1 to inversion count
                res += (iMax + 1 - i);
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

        return res;

    }

    static long inversionCount(long nums[], long N) {
        return partition(nums, 0, nums.length - 1);
    }
}