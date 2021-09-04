// Given n non-negative integers a1, a2, ..., an , where each represents a point
// at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
// of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
// the x-axis forms a container, such that the container contains the most
// water.

// Notice that you may not slant the container.

// Leetcode - https://leetcode.com/problems/container-with-most-water/

// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49

// Input: height = [1,1]
// Output: 1

// Input: height = [4,3,2,1,4]
// Output: 16

// Input: height = [1,2,1]
// Output: 2

// Brute Force Approach
// Time Complexity - O(n^2)
// Space Complexity - O(1)
class Solution {
    public int maxArea(int[] height) {

        int res = -1;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {

                // Find the minimum height that can be stored between i and j
                int min = Math.min(height[i], height[j]);

                // Find how long this height spans. Span is calculated by j-i
                // Update res if the current span is greater than res
                res = Math.max(res, min * (j - i));
            }
        }

        return res;

    }
}

// Two pointer Approach
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    public int maxArea(int[] height) {

        int res = -1;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            res = Math.max(res, min * (right - left));

            // Whichever is less, increment or decrement that
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;

    }
}