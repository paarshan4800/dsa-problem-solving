// You are given an array prices where prices[i] is the price of a given stock
// on the ith day.

// You want to maximize your profit by choosing a single day to buy one stock
// and choosing a different day in the future to sell that stock.

// Return the maximum profit you can achieve from this transaction. If you
// cannot achieve any profit, return 0.

// Leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

// Input: prices = [7,1,5,3,6,4]
// Output: 5

// Input: prices = [7,6,4,3,1]
// Output: 0

// Input: prices = [2,4,1]
// Output: 2

// Brute Force Approach
// Time Complexity - O(n^2)
// Take one price and compare all prices 

// Efficient Approach
// Time Complexity - O(n)
class Solution {
    public int maxProfit(int[] prices) {

        int res = 0; // holds the result max profit

        int min = Integer.MAX_VALUE; // holds the minimum value

        // traverse the prices
        for (int i = 0; i < prices.length; i++) {
            // If prices[i] < min, should update min because a better res is possible if min
            // is lesser
            if (prices[i] < min) {
                min = prices[i];
            }
            // Update res if stock is sold today
            else {
                res = Math.max(res, prices[i] - min);
            }
        }

        return res;

    }
}