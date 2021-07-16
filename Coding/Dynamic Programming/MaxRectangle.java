// Given a binary matrix. Find the maximum area of a rectangle formed only of 1s
// in the given matrix.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/max-rectangle/1/

// Input:
// n = 4, m = 4
// M[][] = {{0 1 1 0},
// {1 1 1 1},
// {1 1 1 1},
// {1 1 0 0}}
// Output: 8
// Explanation: For the above test case the
// matrix will look like
// 0 1 1 0
// 1 1 1 1
// 1 1 1 1
// 1 1 0 0
// the max size rectangle is
// 1 1 1 1
// 1 1 1 1
// and area is 4 *2 = 8.

// Time Complexity - O(m*n)
// Space Complexity - O(n)
class Solution {

    // Find the max area by considering the given heights as histogram
    public int computeMaxRectangleFromHistogram(int[] heights) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= heights.length; i++) {
            int height = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && height <= heights[stack.peek()]) {
                int curHeight = heights[stack.pop()];
                int start = stack.isEmpty() ? -1 : stack.peek();
                int curArea = curHeight * (i - start - 1);
                res = Math.max(res, curArea);
            }

            stack.push(i);
        }

        return res;
    }

    public int maxArea(int M[][], int n, int m) {
        int res = 0;
        int[] temp = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If first row, just copy it into temp
                if (i == 0) {
                    temp[j] = M[0][j];
                    continue;
                }
                // If M[i][j] == 0, then it cant extend from prev rectangle. So reset to zero
                // If M[i][j] != 0, then it can extend from prev rectangle. So add M[i][j] to
                // temp[j]
                temp[j] = M[i][j] == 0 ? 0 : temp[j] + M[i][j];
            }

            // Compute the area of heights in temp and update res
            res = Math.max(res, computeMaxRectangleFromHistogram(temp));
        }

        return res;
    }
}