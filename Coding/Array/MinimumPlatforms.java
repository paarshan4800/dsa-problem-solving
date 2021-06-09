// Consider that all the trains arrive on the same day and leave on the same
// day. Arrival and departure time can never be the same for a train but we can
// have arrival time of one train equal to departure time of the other. At any
// given instance of time, same platform can not be used for both departure of a
// train and arrival of another train. In such cases, we need different
// platforms,

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#

// Input: n = 6
// arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
// dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
// Output: 3

// Input: n = 3
// arr[] = {0900, 1100, 1235}
// dep[] = {1000, 1200, 1240}
// Output: 1

// Brute Force Approach
// Take each interval and compare it with other intervals. If overlap, add that
// to platforms count
// Time Complexity - O(n^2)
// Space Complexity - O(1)

// Efficient Approach
class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here

        // Sort both arrival and departure array
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 1, j = 0;
        int curPlatforms = 1, res = 1;

        // Merging technique of merge sort
        while (i < n && j < n) {
            // If arrival time is greater than departure time, there will be no waiting. So
            // decrement curPlatforms and increment j
            if (arr[i] > dep[j]) {
                j++;
                curPlatforms--;
            }
            // If arrival time is less than or equal to departure time, there will be
            // waiting. So
            // increment curPlatforms and and update res and increment j
            else {
                curPlatforms++;
                res = Math.max(curPlatforms, res);
                i++;
            }
        }

        return res;
    }

}
