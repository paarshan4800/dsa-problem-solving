// A celebrity is a person who is known to all but does not know anyone at a
// party. If you go to a party of N people, find if there is a celebrity in the
// party or not.
// A square NxN matrix M[][] is used to represent people at the party such that
// if an element of row i and column j is set to 1 it means ith person knows jth
// person. Here M[i][i] will always be 0.
// Note: Follow 0 based indexing.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#

// Input:
// N = 3
// M[][] = {{0 1 0},
// {0 0 0},
// {0 1 0}}
// Output: 1
// Explanation: 0th and 2nd person both
// know 1. Therefore, 1 is the celebrity.

// Input:
// MATRIX = { {0, 0, 1, 0},
// {0, 0, 1, 0},
// {0, 0, 0, 0},
// {0, 0, 1, 0} }
// Output:id = 2
// Explanation: The person with ID 2 does not
// know anyone but everyone knows him

// Input:
// MATRIX = { {0, 0, 1, 0},
// {0, 0, 1, 0},
// {0, 1, 0, 0},
// {0, 0, 1, 0} }
// Output: No celebrity
// Explanation: There is no celebrity.

class Solution {
    // Helper method which tells whether i knows j or not
    boolean knows(int M[][], int i, int j) {
        return (M[i][j] == 1) ? true : false;
    }

    // Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
        Stack<Integer> stack = new Stack<>();

        // Push everyone into the stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // Eliminate one by one till only one remain
        while (stack.size() > 1) {
            int i = stack.pop();
            int j = stack.pop();

            // If i knows j, i cant be a celebrity and there is possibility that j can be a
            // celebrity. So push j
            if (knows(M, i, j)) {
                stack.push(j);
            }
            // Else there is possibility that i can be a
            // celebrity. So push i
            else {
                stack.push(i);
            }
        }

        // At the end, we will have only one possibility
        int celeb = stack.pop();

        for (int i = 0; i < n; i++) {
            if (i == celeb) {
                continue;
            }

            // If celeb knows i or i doesnt know celeb, there is no celebrity
            if (knows(M, celeb, i) || !knows(M, i, celeb)) {
                return -1;
            }
        }

        return celeb;
    }
}