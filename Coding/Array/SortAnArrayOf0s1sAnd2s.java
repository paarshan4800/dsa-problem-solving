// Given an array of size N containing only 0s, 1s, and 2s; sort the array in
// ascending order.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1#

// Input: {0, 1, 2, 0, 1, 2}
// Output: {0, 0, 1, 1, 2, 2}

// Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
// Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

class Solution {

    // Helper method for swapping two elements of an array
    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort012(int a[], int n) {

        // All 0s should be from 0,low
        // All 1s should be from low+1,mid
        // All 2s should be from mid+1,a.length-1

        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else if (a[mid] == 2) {
                swap(a, mid, high);
                high--;
            }
        }
    }
}