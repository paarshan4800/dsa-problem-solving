// Implement the next permutation, which rearranges the list of numbers into
// Lexicographically next greater permutation of list of numbers. If such
// arrangement is not possible, it must be rearranged to the lowest possible
// order i.e. sorted in an ascending order. You are given an list of numbers
// arr[ ] of size N.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/next-permutation5226/1

// Input: N = 6
// arr = {1, 2, 3, 6, 5, 4}
// Output: {1, 2, 4, 3, 5, 6}
// Explaination: The next permutation of the
// given array is {1, 2, 4, 3, 5, 6}.

// Input: N = 3
// arr = {3, 2, 1}
// Output: {1, 2, 3}
// Explaination: As arr[] is the last
// permutation. So, the next permutation
// is the lowest one.

class Solution {

    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reverse(int arr[], int low, int high) {
        while (low < high) {
            swap(arr, low, high);
            low++;
            high--;
        }
    }

    static List<Integer> nextPermutation(int N, int arr[]) {

        int peakIndex = -1;

        // Find the last peak element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                peakIndex = i;
        }

        // If the array is in decreasing order, there wont be any peak element. So
        // peakIndex will be -1
        if (peakIndex == -1) {
            // Return the array in sorted order (given in question)
            for (int i = 0; i < arr.length / 2; i++) {
                swap(arr, i, arr.length - i - 1);
            }
        }
        // If peakIndex != -1
        else {
            // Check if any other better element is there which lies in the range [
            // arr[peakIndex] , arr[correctPeakIndex] ]
            int correctPeakIndex = peakIndex;
            for (int i = peakIndex + 1; i < arr.length; i++) {
                // If any element lies in this range, update correctPeakIndex
                if (arr[i] > arr[peakIndex - 1] && arr[i] < arr[correctPeakIndex])
                    correctPeakIndex = i;
            }

            // Swap
            swap(arr, peakIndex - 1, correctPeakIndex);

            // Reverse the rest of the array to get the remaining of the array in ascending
            // order
            reverse(arr, peakIndex, arr.length - 1);

        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++)
            res.add(arr[i]);

        return res;
    }
}