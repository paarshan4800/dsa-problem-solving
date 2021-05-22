// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
// Leetcode - https://leetcode.com/problems/merge-sorted-array/
// GeeksForGeeks - Must do questions topic wise

// Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
// Output: [1,2,2,3,5,6]

// Input: nums1 = [1], m = 1, nums2 = [], n = 0
// Output: [1]

// O(m+n) - Time Complexity
// O(n) - Space Complexity

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];

        // Using merging technique from merge sort
        int i = 0, j = 0, k = 0;

        // i and j points to the beginning of nums1[] and nums2[] respectively
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        // Flushing out remaining
        for (; i < m; i++) {
            res[k++] = nums1[i];
        }

        for (; j < n; j++) {
            res[k++] = nums2[j];
        }

        // Copy res to nums1
        for (int index = 0; index < m + n; index++) {
            nums1[index] = res[index];
        }

    }
}

// Another Approach
// O(m+n) - Time Complexity
// O(1) - Space Complexity
// https://www.youtube.com/watch?v=LXq6wnkkeNA
// Mergin in-place without extra space
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // If m == 0, copy nums2 into nums1
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        // i and j are iterators starting from the end of nums1 and nums2
        int i = m - 1, j = n - 1;
        int fillIndex = m + n - 1; // fillIndex is iterator used to fill values in empty spaces

        // Till are values in nums2 are processed and filled in nums1
        while (j >= 0) {

            // If nums[j] >= nums1[i], fill nums[j] in fillIndex
            // i.e Fill the greater value in fillIndex
            if (nums2[j] >= nums1[i]) {
                nums1[fillIndex--] = nums2[j];
            } else {
                // Fill the greater value in fillIndex
                nums1[fillIndex--] = nums1[i];

                // Traverse nums1 backwards and shift values till we find a val < nums2[j]
                int tempI = i;
                while (tempI - 1 >= 0 && nums2[j] < nums1[tempI - 1]) {
                    nums1[tempI] = nums1[tempI - 1];
                    tempI--;
                }
                // Now tempI holds the correct index to fill nums2[j]
                nums1[tempI] = nums2[j];
            }
            j--;
        }
    }
}

// Another approach
// INSERTION SORT

// For examples like
// Input: nums1 = [3,4,5,0,0,0], m = 3, nums2 = [1,2,3], n = 3
// Output: [1,2,3,3,4,5]

// The above approach wont be efficient. Instead of doing traversing nums1
// backwards and shift values till we find a val < nums2[j], we can perform
// insertion sort as it works in O(n) for almost sorted arrays