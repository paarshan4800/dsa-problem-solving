// Given an array A[ ] of positive integers of size N, where each value
// represents the number of chocolates in a packet. Each packet can have a
// variable number of chocolates. There are M students, the task is to
// distribute chocolate packets among M students such that :
// 1. Each student gets exactly one packet.
// 2. The difference between maximum number of chocolates given to a student and
// minimum number of chocolates given to a student is minimum.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#

// Input:
// N = 8, M = 5
// A = {3, 4, 1, 9, 56, 7, 9, 12}
// Output: 6
// Explanation: The minimum difference between
// maximum chocolates and minimum chocolates
// is 9 - 3 = 6 by choosing following M packets :
// {3, 4, 9, 7, 9}.

// Input:
// N = 7, M = 3
// A = {7, 3, 2, 4, 9, 12, 56}
// Output: 2
class Solution {
    public long findMinDiff(ArrayList<Long> a, long n, long m) {

        Collections.sort(a); // Sort in ascending order

        int M = (int) m;
        long res = Long.MAX_VALUE;

        int i = 0, j = M - 1;

        // Have to find minimum a.get(i+5) - a.get(i) value

        while (j < a.size()) {
            res = Math.min(res, a.get(j) - a.get(i));
            i++;
            j++;
        }

        return res;
    }
}