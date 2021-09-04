// Given a positive integer N, count all possible distinct binary strings of
// length N such that there are no consecutive 1’s. Output your answer modulo
// 10^9 + 7.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1/

// YT - https://www.youtube.com/watch?v=Bq9lgqC1YwE

// Input:
// N = 3
// Output: 5
// Explanation: 5 strings are (000,
// 001, 010, 100, 101).

class Solution {

    long countStrings(int n) {
        long[] dpZero = new long[n + 1];
        long[] dpOne = new long[n + 1];

        // For n == 1, there are two possibilities (0,1)
        dpZero[1] = 1;
        dpOne[1] = 1;

        for (int i = 2; i <= n; i++) {
            // We can append 0 to both the string ending with 0 and 1
            dpZero[i] = (dpZero[i - 1] + dpOne[i - 1]) % 1000000007;

            // We can append 1 to only the string ending with 0
            dpOne[i] = dpZero[i - 1] % 1000000007;
        }

        return (dpZero[n] + dpOne[n]) % 1000000007;
    }
}