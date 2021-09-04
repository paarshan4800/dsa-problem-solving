// You are given an array arr[] of N integers including 0. The task is to find
// the smallest positive number missing from the array.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/smallest-positive-missing-number-1587115621/1/

// YT - https://www.youtube.com/watch?v=-lfHWWMmXXM

// Input:
// N = 5
// arr[] = {1,2,3,4,5}
// Output: 6
// Explanation: Smallest positive missing
// number is 6.

// Input:
// N = 5
// arr[] = {0,-10,1,3,-20}
// Output: 2
// Explanation: Smallest positive missing
// number is 2.

class Solution {
    // Function to find the smallest positive number missing from the array.

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int missingNumber(int arr[], int size) {
        int i = 0;

        // Modify array such that arr[i]-1 value sits at i
        while (i < arr.length) {
            // arr[i]<=0 and arr[i] > size number dont form valid array index
            if (arr[i] <= 0 || arr[i] > size || arr[i] == arr[arr[i] - 1]) {
                i++;
                continue;
            }

            swap(arr, i, arr[i] - 1);
        }

        for (i = 0; i < arr.length; i++) {
            if (arr[i] - 1 != i)
                return i + 1;
        }

        return size + 1;
    }
}