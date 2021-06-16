// Given an array arr[ ] of size N having distinct elements, the task is to find
// the next greater element for each element of the array in order of their
// appearance in the array.
// Next greater element of an element in the array is the nearest element on the
// right which is greater than the current element.
// If there does not exist next greater of current element, then next greater
// element for current element is -1. For example, next greater of the last
// element is always -1.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1#

// Input:
// N = 4, arr[] = [1 3 2 4]
// Output:
// 3 4 4 -1

// Input:
// N = 5, arr[] [6 8 0 1 3]
// Output:
// 8 -1 1 3 -1

// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    // Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n) {

        long[] res = new long[n];
        Stack<Long> stack = new Stack<>();

        // Next greater element of the last element is always -1
        res[n - 1] = -1;
        stack.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {

            // Maintain stack in strictly decreasing order
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }

            // If stack is empty, no greater element is there. So -1
            // Else top of the stack is next greater element of arr[i]
            res[i] = (stack.isEmpty()) ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        return res;
    }
}