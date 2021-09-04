// You are given a string S of 2N characters consisting of N ‘[‘ brackets and N
// ‘]’ brackets. A string is considered balanced if it can be represented in the
// for S2[S1] where S1 and S2 are balanced strings. We can make an unbalanced
// string balanced by swapping adjacent characters. Calculate the minimum number
// of swaps necessary to make a string balanced.
// Note - Strings S1 and S2 can be empty.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/minimum-swaps-for-bracket-balancing2704/1#

// Input : []][][
// Output : 2
// Explanation :
// First swap: Position 3 and 4
// [][]][
// Second swap: Position 5 and 6
// [][][]

// Input : [[][]]
// Output : 0
// Explanation:
// String is already balanced.

class Solution {
    static int minimumNumberOfSwaps(String s) {
        int open = 0, close = 0;
        int res = 0, imbalance = 0;

        for (int i = 0; i < s.length(); i++) {
            // If open bracket
            if (s.charAt(i) == '[') {
                open++; // Increment open
                // If there is imbalance
                if (imbalance > 0) {
                    res += imbalance; // Add imbalance to res
                    imbalance--; // Decrement imbalance
                }
            }
            // If close bracket
            else {
                close++; // Increment open
                // To check if there is any imbalance, do close - open
                imbalance = close - open;
            }
        }

        return res;
    }
}