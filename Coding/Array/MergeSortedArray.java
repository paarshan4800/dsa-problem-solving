// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
// Leetcode - https://leetcode.com/problems/merge-sorted-array/
// GeeksForGeeks - Must do questions topic wise

// O(m+n) - Time Complexity
// O(n) - Space Complexity

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        
        // Using merging technique from merge sort
        int i=0,j=0,k=0;
        
        // i and j points to the beginning of nums1[] and nums2[] respectively
        while(i<m && j<n) {
            if(nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            }
            else {
                res[k++] = nums2[j++];
            }
        }
        
        // Flushing out remaining
        for(;i<m;i++) {
            res[k++] = nums1[i];
        }
        
        for(;j<n;j++) {
            res[k++] = nums2[j];
        }
        
        // Copy res to nums1
        for(int index=0;index<m+n;index++) {
            nums1[index] = res[index];
        }
        
    }
}