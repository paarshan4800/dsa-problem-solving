// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
// Leetcode - https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

// O(n) - Time Complexity
// O(1) - Space Complexity

class Solution1 {
    public int maxProfit(int[] prices) {
        // res holds the max profit and i is the iterator
        int res = 0, i=0;
        // flag is kind of lock -> true means bought and ready to sell and false means sold and nothing bought
        boolean flag = false;
        // indices of bought and sold prices
        int bought=0,sold;
        
        // Peak and valley approach
        while(true) {
            
            // Iterate till we find a valley (to buy a stock)
            while( i<prices.length-1 && prices[i] > prices[i+1]) {
                i++;
            }
            
            // Boundary Condition
            if(i>=prices.length-1) {
                break;
            }
            
            // Buy the stock
            bought = i;
            flag = true;
            i++;
            
            // Iterate till we find a peak (to sell a stock)
            while(i<prices.length-1 && prices[i] < prices[i+1]) {
                i++;
            }
            
            // Boundary Condition
            if(i>=prices.length-1) {
                break;
            }
            
            // Sell the stock
            sold = i;
            flag = false;

            // Find profit and add it to the result
            res = res + (prices[sold] - prices[bought]);
            i++;
            
        }
        
        // If flag != false after iteration completion, then it means some stock is bought and its not sold
        if(flag == true) {
            // Check whether selling the stock on final day makes profit or not.
            // If it makes profit, add it to the result
            if(prices[prices.length-1] > prices[bought]) {
                res = res + prices[prices.length-1] - prices[bought];
            }
        }
        
        return res;
        
    }
}


class Solution2 {
    public int maxProfit(int[] prices) {
        
        // result
        int res = 0;
        
        // traverse
       for(int i=1;i<prices.length;i++) {
           
           // in consecutive transactions, if profit is possible add it to the result
           if(prices[i] > prices[i-1]) {
               res += (prices[i] - prices[i-1]);
           }
       }       
        
        return res;
    }
}
