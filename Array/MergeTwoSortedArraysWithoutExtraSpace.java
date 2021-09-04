// Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing
// order. Merge them in sorted order without using any extra space. Modify arr1
// so that it contains the first N elements and modify arr2 so that it contains
// the last M elements.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1#

// YT - https://www.youtube.com/watch?v=hVl2b3bLzBw

// Input:
// n = 4, arr1[] = [1 3 5 7]
// m = 5, arr2[] = [0 2 6 8 9]
// Output:
// arr1[] = [0 1 2 3]
// arr2[] = [5 6 7 8 9]

// Input:
// n = 2, arr1[] = [10, 12]
// m = 3, arr2[] = [5 18 20]
// Output:
// arr1[] = [5 10]
// arr2[] = [12 18 20]

// Insertion Sort on second array
// Start iterating the first array using i. If arr1[i] > arr2[0], swap and
// then perform insertion sort on second array
// At every iteration both the arrays are sorted
// Time Complexity - O(n*m)

// Efficient Approach
class Solution {

    // Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) {
        // If any one of the array is empty
        if (m == 0 || n == 0) {
            return;
        }

        // i starts from end of arr1 and j starts from beginning of arr2
        int i = n - 1, j = 0;
        // Till any one of them runs out
        while (i >= 0 && j < m) {
            // If a larger element is in arr1, swap it with arr2
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            // Update i and j
            i--;
            j++;
        }

        // Now all the elements are in their respective arrays
        // Sort both the arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

    }
}
