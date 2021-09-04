// Given an array of 0s and 1s. Find the length of the largest subarray with
// equal number of 0s and 1s.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1#

// Input:
// N = 4
// A[] = {0,1,0,1}
// Output: 4
// Explanation: The array from index [0...3]
// contains equal number of 0's and 1's.
// Thus maximum length of subarray having
// equal number of 0's and 1's is 4.

// Input:
// N = 5
// A[] = {0,0,1,0,0}
// Output: 2

class Solution {

    // arr[] : the input array containing 0s and 1s
    // N : size of the input array

    // return the maximum length of the subarray
    // with equal 0s and 1s
    int maxLen(int[] arr, int N) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        int one = 0, zero = 0;
        int res = 0;

        for (int i = 0; i < N; i++) {
            // If one, increment one's count
            if (arr[i] == 1) {
                one++;
            }
            // If zero, increment zero's count
            else {
                zero++;
            }

            // If both counts are the same, then the whole subarray (0,i) is a result
            if (one == zero)
                res = Math.max(res, i + 1);

            // If one-zero has already occured, then from i,one-zero's first occurence is
            // also a possible result
            if (hash.containsKey(one - zero)) {
                res = Math.max(res, i - hash.get(one - zero));
            }
            // Put one-zero into the hash
            else {
                hash.put(one - zero, i);
            }
        }

        // If both counts are the same, then the whole subarray (0,N) is a result
        if (one == zero)
            return N;

        return res;
    }
}
