// Given two integer arrays nums1 and nums2, return an array of their intersection. 
// Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
// Leetcode - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/

// O(nlogn) - Time Complexity
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        // Sorting method

        // Sort the two arrays in ascending order
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        // Arraylist to store the intersection values
        ArrayList<Integer> list = new ArrayList<>();

        // Traverse till end of any one array
        while (i < nums1.length && j < nums2.length) {
            // If so, there can't be any solution in nums1, so increment its iterator
            if (nums1[i] < nums2[j]) {
                i++;
            }
            // If so, there can't be any solution in nums2, so increment its iterator
            else if (nums1[i] > nums2[j]) {
                j++;
            }
            // If so, it is a solution (intersection), after adding it to list increment
            // both iterators
            else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] res = new int[list.size()];

        for (int c = 0; c < list.size(); c++) {
            res[c] = list.get(c);
        }

        return res;

    }
}

// O(nlogn) - Time Complexity
// Sorting and Searching method

// Sort one array and perform binary search on it instead of sorting both arrays

// O(n) - Time Complexity
// O(n) - Space Complexity
// Hashing method