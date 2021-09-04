// Given an array of integers arr, replace each element with its rank.

// The rank represents how large the element is. The rank has the following
// rules:

// Rank is an integer starting from 1.
// The larger the element, the larger the rank. If two elements are equal, their
// rank must be the same.
// Rank should be as small as possible.

// Leetcode - https://leetcode.com/problems/rank-transform-of-an-array/

// Input: arr = [40,10,20,30]
// Output: [4,1,2,3]

// Input: arr = [100,100,100]
// Output: [1,1,1]

// Input: arr = [37,12,28,9,100,56,80,5,12]
// Output: [5,3,4,2,8,6,7,1,3]

// Time Complexity - O(nlogn)
// Space Complexity - O(n)
class Solution {
    public int[] arrayRankTransform(int[] arr) {

        int[] temp = Arrays.copyOf(arr, arr.length); // Take a copy of the original array

        Arrays.sort(temp); // Sort the temp arr

        HashMap<Integer, Integer> hash = new HashMap<>(); // This hash stores the integer value and its corresponding
                                                          // rank
        int rank = 1;

        for (int i = 0; i < temp.length; i++) {
            if (hash.containsKey(temp[i])) {
                continue;
            }
            hash.put(temp[i], rank++);
        }

        // Use the temp array as result also
        for (int i = 0; i < arr.length; i++) {
            temp[i] = hash.get(arr[i]); // Get the rank of arr[i] from hash and store it in temp[i]
        }

        return temp;

    }
}