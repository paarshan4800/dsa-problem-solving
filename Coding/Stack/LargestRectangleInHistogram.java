// Given an array of integers heights representing the histogram's bar height
// where the width of each bar is 1, return the area of the largest rectangle in
// the histogram.

// Leetcode - https://leetcode.com/problems/largest-rectangle-in-histogram/

// Input: heights = [2,1,5,6,2,3]
// Output: 10
// Explanation: The above is a histogram where width of each bar is 1.
// The largest rectangle is shown in the red area, which has an area = 10 units.

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            // Keep stack in increasing order
            // If stack is not empty and height <= heights[stack top], compute the area for
            // the current rectangle and then pop from stack
            while (!stack.isEmpty() && height <= heights[stack.peek()]) {
                // get height of the current rectangle
                int curHeight = heights[stack.pop()];
                // If stack is empty, we need to check till the first element or check till the
                // top element in stack
                int start = stack.isEmpty() ? -1 : stack.peek();

                // compute area and update res
                int curArea = curHeight * (i - 1 - start);
                res = Math.max(res, curArea);
            }

            stack.push(i);
        }

        // Run the same algo to process the remaining elements in stack which is in
        // increasing order
        while (!stack.isEmpty()) {
            int curHeight = heights[stack.pop()];
            int start = stack.isEmpty() ? -1 : stack.peek();
            int curArea = curHeight * (heights.length - 1 - start);
            res = Math.max(res, curArea);
        }

        return res;
    }
}