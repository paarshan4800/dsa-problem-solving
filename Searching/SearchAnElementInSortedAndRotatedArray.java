// Given a sorted and rotated array A of N distinct elements which is rotated at
// some point, and given an element K. The task is to find the index of the
// given element K in the array A.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array0959/1/?track=amazon-searching&batchId=192#

// Input:
// N = 9
// A[] = {5 6,7,8,9,10,1,2,3}
// K = 10
// Output: 5

// Input:
// N = 9
// A[] = {5 6,7,8,9,10,1,2,3}
// K = 8
// Output: 3

// Time Complexity = O(logn)
class Solution {

    static int findPivot(int arr[]) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {

            // If low == high, return either one
            if (low == high)
                return low;

            int mid = low + (high - low) / 2;

            // If mid < high and arr[mid] > arr[mid+1], then mid is the pivot
            if (mid < high && arr[mid] > arr[mid + 1])
                return mid;

            // If mid > low and arr[mid] < arr[mid-1], then mid-1 is the pivot
            if (mid > low && arr[mid] < arr[mid - 1])
                return mid - 1;

            // If arr[low] >= arr[mid] means the array might be increasing and then
            // decreasing, so
            // the pivot will lie in the range low to mid, so set high as mid-1
            if (arr[low] >= arr[mid])
                high = mid - 1;

            // Set low to mid+1
            else
                low = mid + 1;

        }
        return -1;
    }

    static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            else if (arr[mid] > target)
                high = mid - 1;

            else
                low = mid + 1;
        }

        return -1;
    }

    static int Search(int arr[], int target) {
        // Find index of pivot element
        int pivotIndex = findPivot(arr);

        // If index of pivot is -1, then the array is in proper sorted order,run normal
        // binary search
        if (pivotIndex == -1)
            return binarySearch(arr, target, 0, arr.length - 1);

        // If arr[pivotIndex] == target, retun pivotIndex
        if (arr[pivotIndex] == target)
            return pivotIndex;

        // If arr[0] > target, we dont need to search the first portion i.e 0 to
        // pivotIndex as surely the target wont lie there

        // If arr[0] <= target, run binary search from 0 to pivotIndex-1
        if (arr[0] <= target)
            return binarySearch(arr, target, 0, pivotIndex - 1);

        // Run binary search for remaining elements from pivotIndex+1 to n-1
        return binarySearch(arr, target, pivotIndex + 1, arr.length - 1);
    }
}

// Single Pass Solution
class Solution {

    static int Search(int arr[], int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            // Check if the left portion of mid is in increasing order
            if (arr[low] <= arr[mid]) {
                // Check if target lies in the range [arr[low],arr[mid]]
                // If so, set high to mid-1
                if (target >= arr[low] && target <= arr[mid])
                    high = mid - 1;
                // Else target lies in the range[arr[mid+1],arr[high]]. So update low
                else
                    low = mid + 1;
            }
            // If left portion of the array is not in increasing order
            else {
                // Check if target lies in the range [arr[mid],arr[high]]
                // If so, set low to mid+1
                if (target >= arr[mid] && target <= arr[high])
                    low = mid + 1;
                // Else target lies in the range[arr[low],arr[mid-1]]. So update high
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}