// Given an array of integers arr, return true if and only if it is a valid
// mountain array.

// Recall that arr is a mountain array if and only if:

// arr.length >= 3
// There exists some i with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

// https://leetcode.com/problems/valid-mountain-array/

// Input: arr = [0,2,3,4,5,2,1,0]
// Output: true

// Input: arr = [2,1]
// Output: false

// Input: arr = [3,5,5]
// Output: false

// Input: arr = [0,3,2,1]
// Output: true

class Solution {
    public boolean validMountainArray(int[] arr) {
        // Given condition
        if (arr.length < 3) {
            return false;
        }

        int i = 1;
        // Iterate till mountain peak
        while (i < arr.length && arr[i] > arr[i - 1]) {
            i++;
        }
        // If i is still 1, it means we didn't go up the mountain (there is no upwards
        // movement)
        if (i == 1) {
            return false;
        }

        i++;

        // Iterate till valley
        while (i < arr.length && arr[i] < arr[i - 1]) {
            i++;
        }

        // If full array is traversed and last two elements also satisfy the condition
        // then valid mountain
        if (i == arr.length) {
            if (arr[i - 1] < arr[i - 2]) {
                return true;
            }

        }

        return false;
    }
}
