// Given an unsorted array of size N. Find the first element in array such that
// all of its left elements are smaller and all right elements to it are greater
// than it.

// Note: Left and right side elements can be equal to required element. And
// extreme elements cannot be required element.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/unsorted-array4925/1#

// Input:
// N = 4
// A[] = {4, 2, 5, 7}
// Output:
// 5

// Input:
// N = 3
// A[] = {11, 9, 12}
// Output:
// -1

class Compute {
    public int findElement(int arr[], int n) {
        boolean[] leftSmaller = new boolean[n];
        boolean[] rightGreater = new boolean[n];

        // leftSmaller[i] will be true if it is greater than or equal to all the
        // elements to its left
        leftSmaller[0] = false;
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] >= max) {
                max = arr[i];
                leftSmaller[i] = true;
            }
        }

        // rightGreater[i] will be true if it is smaller than or equal to all the
        // elements to its right
        rightGreater[n - 1] = false;
        int min = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] <= min) {
                min = arr[i];
                rightGreater[i] = true;
            }
        }

        // If both leftSmaller[i] and rightGreater[i] is true, return arr[i]
        for (int i = 0; i < n; i++) {
            if (leftSmaller[i] == true && rightGreater[i] == true) {
                return arr[i];
            }
        }

        return -1;
    }
}