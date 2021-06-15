// Given an array arr of integers, check if there exists two integers N and M
// such that N is the double of M ( i.e. N = 2 * M).

// More formally check if there exists two indices i and j such that :

// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]

// Leetcode - https://leetcode.com/problems/check-if-n-and-its-double-exist/

// Input: arr = [10,2,5,3]
// Output: true

// Input: arr = [7,1,14,11]
// Output: true

// Input: arr = [3,1,7,11]
// Output: false

// Brute Force Approach
// Iterate the array by searching for num*2
// Time Complexity - O(n^2)
// Space Complexity - O(1)

// Hashing Approach
// If num*2 is in hash, return true. Else store num into hash
// Time Complexity - O(n)
// Space Complexity - O(n)

// Binary Search Approach
// Time Complexity - O(nlogn)
// Space Complexity - O(1)

class Solution {

    public boolean binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return true;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    public boolean checkIfExist(int[] arr) {

        Arrays.sort(arr);
        int zeroCount = 0;

        for (int num : arr) {
            if (num == 0) {
                zeroCount++;
            } else {
                // search for num*2
                if (binarySearch(arr, num * 2)) {
                    return true;
                }
            }
        }

        // If there are more than two zeroes, they satisfy the condition 0 = 2*0, so
        // return true
        return (zeroCount >= 2) ? true : false;

    }
}