// You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and
// lefti < righti.

// A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can
// be formed in this fashion.

// Return the length longest chain which can be formed.

// Leetcode - https://leetcode.com/problems/maximum-length-of-pair-chain/

// Input:
// N = 5
// P[] = {5 24 , 39 60 , 15 28 , 27 40 , 50 90}
// Output: 3

// MODIFICATION OF LONGEST INCREASING SUBSEQUENCE

class Solution {

    class SortFirst implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return a[0] - b[0];
        }
    }

    public int findLongestChain(int[][] pairs) {

        // Sort the array by either the first element or the second one
        Arrays.sort(pairs, new SortFirst());

        int[] dp = new int[pairs.length];
        int res = 1;

        for (int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
        }

        for (int j = 1; j < pairs.length; j++) {
            for (int i = 0; i < j; i++) {
                // Checking the given condition c>b where (a,b) and (c,d) are pairs
                if (pairs[j][0] > pairs[i][1]) {
                    dp[j] = Math.max(dp[j], 1 + dp[i]);
                    res = Math.max(res, dp[j]);
                }
            }
        }

        return res;

    }
}