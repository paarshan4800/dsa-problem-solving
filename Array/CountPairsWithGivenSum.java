// Given an array of N integers, and an integer K, find the number of pairs of
// elements in the array whose sum is equal to K.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#

// Input:
// N = 4, K = 6
// arr[] = {1, 5, 7, 1}
// Output: 2
// Explanation:
// arr[0] + arr[1] = 1 + 5 = 6
// and arr[1] + arr[3] = 5 + 1 = 6.

// Input:
// N = 4, X = 2
// arr[] = {1, 1, 1, 1}
// Output: 6
// Explanation:
// Each 1 will produce sum 2 with any 1.

class Solution {
    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int res = 0;

        for (int val : arr) {
            int diff = k - val;

            if (hash.containsKey(diff)) {
                res += hash.get(diff);
            }

            if (hash.containsKey(val)) {
                hash.put(val, hash.get(val) + 1);
            } else {
                hash.put(val, 1);
            }
        }

        return res;
    }
}
