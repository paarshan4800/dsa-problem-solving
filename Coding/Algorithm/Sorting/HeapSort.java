// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/heap-sort/1#

// Time Complexity - O(nlogn)
// Space Complexity - O(1)

class Solution {

    // Helper method to swap to elements of an array
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Function to build a Heap from array.
    void buildHeap(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

    }

    // Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i) {
        int largest = i; // Set current node as largest

        // Calculate index of left and right child
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // If left child is valid and arr[leftChild] > arr[largest], set largest =
        // leftChild
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

        // If right child is valid and arr[right] > arr[largest], set largest =
        // rightChild
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

        // If largest != current node i.e i, then need to swap largest and current node
        if (largest != i) {
            swap(arr, largest, i);

            // Recur down the heap by calling heapify at largest
            heapify(arr, n, largest);
        }
    }

    // Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n) {
        // Build the max heap
        buildHeap(arr, n);

        for (int i = n - 1; i >= 0; i--) {
            // To pop out the top of max heap, Swap the first and last element.
            swap(arr, 0, i);

            // After swapping, to maintain heap structure, call heapify from 0th index
            heapify(arr, i, 0);
        }
    }
}
