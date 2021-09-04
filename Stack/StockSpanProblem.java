// The stock span problem is a financial problem where we have a series of n
// daily price quotes for a stock and we need to calculate the span of stock’s
// price for all n days.
// The span Si of the stock’s price on a given day i is defined as the maximum
// number of consecutive days just before the given day, for which the price of
// the stock on the current day is less than or equal to its price on the given
// day.
// For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60,
// 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4,
// 6}.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1#

// Input:
// N = 7, price[] = [100 80 60 70 60 75 85]
// Output:
// 1 1 1 2 1 4 6

// Input:
// N = 6, price[] = [10 4 5 90 120 80]
// Output:
// 1 1 2 4 5 1

// Time Complexity - O(n)
// Space Complexity - O(n)

class Solution {
    // Function to calculate the span of stockâ€™s price for all n days.
    public static int[] calculateSpan(int price[], int n) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            // For 0th day, span will be 1 only.
            // Push into stack and update res[i]
            if (i == 0) {
                stack.push(0);
                res[i] = 1;
                continue;
            }

            // Till stack is not empty and top of stack's price <= price[i], pop from stack
            // Maintain stack in descending order
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            // If stack is empty, it is the highest price. So it spans for all days. So i+1
            // Else, it spans till the previous highest price. So i-stack.peek()
            res[i] = stack.isEmpty() ? i + 1 : i - stack.peek();

            stack.push(i); // Push current price index into stack
        }

        return res;
    }

}