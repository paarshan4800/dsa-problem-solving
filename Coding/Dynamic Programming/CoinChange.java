// You are given an integer array coins representing coins of different
// denominations and an integer amount representing a total amount of money.

// Return the fewest number of coins that you need to make up that amount. If
// that amount of money cannot be made up by any combination of the coins,
// return -1.

// You may assume that you have an infinite number of each kind of coin.

// Leetcode - https://leetcode.com/problems/coin-change/

// Input: coins = [1,2,5], amount = 11
// Output: 3

// Input: coins = [2], amount = 3
// Output: -1

// Input: coins = [1,5,10,25], amount = 49
// Output: 7

// Recursive Solution
// Time Complexity - O(amount ^ no. of coins)

class Solution {

    public int calculateMinCoins(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }

            int temp = calculateMinCoins(coins, amount - coin);
            minCoins = Math.min(minCoins, temp);
        }

        return (minCoins == Integer.MAX_VALUE) ? minCoins : 1 + minCoins;
    }

    public int coinChange(int[] coins, int amount) {
        int res = calculateMinCoins(coins, amount);
        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }
    }
}

// Memoization - Top Down Approach
class Solution {

    public int calculateMinCoins(int[] coins, int amount, int[] memo) {

        if (memo[amount] != -1) {
            return memo[amount];
        }

        if (amount == 0) {
            return 0;
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (amount - coin < 0) {
                continue;
            }

            int temp = calculateMinCoins(coins, amount - coin, memo);
            minCoins = Math.min(minCoins, temp);
        }

        memo[amount] = (minCoins == Integer.MAX_VALUE) ? minCoins : 1 + minCoins;
        return memo[amount];
    }

    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);

        int res = calculateMinCoins(coins, amount, memo);
        if (res == Integer.MAX_VALUE) {
            return -1;
        } else {
            return res;
        }
    }
}

// Bottom Up Approach
class Solution {

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int minCoins = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                int temp = (dp[i - coin] == Integer.MAX_VALUE) ? dp[i - coin] : dp[i - coin] + 1;
                minCoins = Math.min(minCoins, temp);
            }
            dp[i] = minCoins;

        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount];

    }
}