// Given an array of positive integers. Find the length of the longest
// sub-sequence such that elements in the subsequence are consecutive integers,
// the consecutive numbers can be in any order.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1#

// Input:
// N = 7
// a[] = {2,6,1,9,4,5,3}
// Output:
// 6
// Explanation:
// The consecutive numbers here
// are 1, 2, 3, 4, 5, 6. These 6
// numbers form the longest consecutive
// subsquence.

// Input:
// N = 7
// a[] = {1,9,3,10,4,20,2}
// Output:
// 4
// Explanation:
// 1, 2, 3, 4 is the longest
// consecutive subsequence.

class Solution {
    // arr[] : the input array
    // N : size of the array arr[]

    // Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int arr[], int N) {
        Set<Integer> hash = new HashSet<>();
        int res = 1;

        // Add all numbers to the set
        for (int val : arr)
            hash.add(val);

        for (int val : arr) {
            // If one number less than val is in the hash, continue
            if (hash.contains(val - 1))
                continue;

            // If one number less than val is not in the hash, it must be the starting of
            // one consecutive subsequence. Check for numbers + 1 than that
            int count = 1;
            while (hash.contains(val + 1)) {
                count++;
                val++;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}