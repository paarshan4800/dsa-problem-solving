// Input:
// N = 5
// arr[] = {4, 1, 3, 9, 7}
// Output:
// 1 3 4 7 9

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/selection-sort/1#

// Time Complexity - O(n^2)
// Space Complexity - O(1)
class Solution {
    // This method returns the index of the minimum element of the current window
    // i.e >=i
    int select(int arr[], int i) {
        int minIndex = i;

        for (; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        return minIndex;
    }

    void selectionSort(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            // Find the index of the minimum value
            int minIndex = select(arr, i);

            // Swap it with i
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            // After every iteration, <= i are in sorted order
        }
    }
}