// Given an array of N integers arr[] where each element represents the max
// number of steps that can be made forward from that element. Find the minimum
// number of jumps to reach the end of the array (starting from the first
// element). If an element is 0, then you cannot move through that element.
// Note: Return -1 if you can't reach the end of the array.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1#

// YT - https://www.youtube.com/watch?v=MiqoA-yF-0M

// Input:
// N = 11
// arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
// Output: 3
// Explanation:
// First jump from 1st element to 2nd
// element with value 3. Now, from here
// we jump to 5th element with value 9,
// and from here we will jump to last.

// Dynamic Programming
// Time Complexity - O(n^2)
// Space Complexity - O(n)

class Solution {
    static int minJumps(int[] arr) {
        int[] dp = new int[arr.length];

        // If we cant move from initial state, return -1
        if (arr[0] == 0)
            return -1;

        for (int j = 1; j < arr.length; j++) {
            for (int i = 0; i < j; i++) {
                // If j is reachable from i
                if (i + arr[i] >= j) {
                    // If dp[j] == 0, store the jump from i (1) + prev subproblem (dp[i]) in dp[j]
                    if (dp[j] == 0)
                        dp[j] = 1 + dp[i];

                    // If dp[j] != 0, store the minimum of two possibilities
                    // i) i -> j is costlier than already calculated (dp[j]), so take dp[j]
                    // ii) i -> j is cheaper than already calculated (dp[j]), so take 1 + dp[i]
                    else
                        dp[j] = Math.min(dp[j], dp[i] + 1);
                }
            }
        }

        return dp[arr.length - 1] == 0 ? -1 : dp[arr.length - 1];
    }
}