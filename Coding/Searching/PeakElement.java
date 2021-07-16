// A peak element in an array is the one that is not smaller than its
// neighbours.
// Given an array arr[] of size N, find the index of any one of its peak
// elements.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/peak-element/1#

// Input: array[]= {5, 10, 20, 15}
// Output: 20
// The element 20 has neighbours 10 and 15,
// both of them are less than 20.

// Input: array[] = {10, 20, 15, 2, 23, 90, 67}
// Output: 20 or 90
// The element 20 has neighbours 10 and 15,
// both of them are less than 20, similarly 90 has neighbours 23 and 67.

class Solution {
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public int peakElement(int[] arr, int n) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (
            // If mid == 0, then there is no element to its left or arr[mid] >= arr[mid-1],
            (mid == 0 || arr[mid] >= arr[mid - 1]) &&
            // If mid == arr.length-1, then there is no element to its right or arr[mid] <=
            // arr[mid+1],
                    (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]))
                // Both conditions are true, mid is the peak element
                return mid;

            // If mid is not the last element and arr[mid+1] > arr[mid], peak element lies
            // in the range mid+1 to high
            if (mid < arr.length - 1 && arr[mid + 1] > arr[mid])
                low = mid + 1;
            // peak element lies in the range low to mid-1
            else
                high = mid - 1;

        }

        return -1;
    }
}