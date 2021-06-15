// Given an array Arr (distinct elements) of size N. Rearrange the elements of
// array in zig-zag fashion. The converted array should be in form a < b > c < d
// > e < f. The relative order of elements is same in the output i.e you have to
// iterate on the original array only.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion1638/1#

// Input:
// N = 7
// Arr[] = {4, 3, 7, 8, 6, 2, 1}
// Output: 3 7 4 8 2 6 1

// Input:
// N = 4
// Arr[] = {1, 4, 3, 2}
// Output: 1 4 2 3

class Solution {

    // Helper method to swap
    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void zigZag(int arr[], int n) {
        boolean smaller = true;

        for (int i = 0; i < n - 1; i++) {
            // If smaller == true, perfomr a<b check
            if (smaller) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
            // If smaller == false, perfomr a>b check
            else {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }

            // Update smaller flag
            smaller = !smaller;
        }
    }

}