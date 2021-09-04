// You are given an array A of size N. The array contains integers and is of
// even length. The elements of the array represent N coin of values V1, V2,
// ....Vn. You play against an opponent in an alternating way.

// In each turn, a player selects either the first or last coin from the row,
// removes it from the row permanently, and receives the value of the coin.

// You need to determine the maximum possible amount of money you can win if you
// go first.
// Note: Both the players are playing optimally.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/optimal-strategy-for-a-game-1587115620/1#

// YT - https://www.youtube.com/watch?v=ww4V7vRIzSk

// Input:
// N = 4
// A[] = {5,3,7,10}
// Output: 15
// Explanation: The user collects maximum
// value as 15(10 + 5)

// Input:
// N = 4
// A[] = {8,15,3,7}
// Output: 22
// Explanation: The user collects maximum
// value as 22(7 + 15)

class solve {
    // Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n) {
        int[][] dp = new int[n][n];

        // If subproblem is of size 1, the user can take that can only
        for (int i = 0; i < n; i++)
            dp[i][i] = arr[i];

        // If subproblem is of size 2, the user can take the max of two coins
        for (int i = 0; i < n - 1; i++)
            dp[i][i + 1] = Math.max(arr[i], arr[i + 1]);

        for (int k = 2; k < n; k++) {
            for (int i = 0; i < n - k; i++) {
                int j = i + k;
                // Coins are i,i+1,i+2,...,j-2,j-1,j

                // i,j refers to coins in the array from i to j index

                // If coin i is choosed by the user
                // The opponent will choose the most optimal coin in his opportunity so that the
                // user will choose a minimum value coin next time
                int chooseLeft = arr[i] + Math.min(dp[i + 1][j - 1], dp[i + 2][j]);

                // If coin j is choosed by the user
                // The opponent will choose the most optimal coin in his opportunity so that the
                // user will choose a minimum value coin next time
                int chooseRight = arr[j] + Math.min(dp[i + 1][j - 1], dp[i][j - 2]);

                // Out of the two possibilities user will choose the best outcome
                dp[i][j] = Math.max(chooseLeft, chooseRight);
            }
        }

        return dp[0][n - 1];
    }
}
