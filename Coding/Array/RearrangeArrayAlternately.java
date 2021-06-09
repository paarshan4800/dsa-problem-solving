// Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively i.e first element should be max value, second should be min value, third should be second max, fourth should be second min and so on.

// GeeksForGeeks - https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1#

// Input:
// N = 6
// arr[] = {1,2,3,4,5,6}
// Output: 6 1 5 2 4 3

// Input:
// N = 11
// arr[]={10,20,30,40,50,60,70,80,90,100,110}
// Output:110 10 100 20 90 30 80 40 70 50 60

// Using extra space
// Time Complexity - O(n)
// Space Complexity - O(n)
// Using two pointers, store the max and min element alternatively in the extra space.

// Efficient Solution
// Time Complexity - O(n)
// Space Complexity - O(1)
// Storing two values in the same index
class Solution {

    public static boolean isEven(int n) {
        return (n % 2 == 0) ? true : false;
    }

    // temp: input array
    // n: size of array
    // Function to rearrange the array elements alternately.
    public static void rearrange(int arr[], int n) {

        int maxIndex = n - 1, minIndex = 0;
        int maxEle = arr[n - 1] + 1;

        for (int i = 0; i < n; i++) {
            if (isEven(i)) {
                arr[i] = arr[i] + (arr[maxIndex] % maxEle) * maxEle;
                maxIndex--;
            } else {
                arr[i] = arr[i] + (arr[minIndex] % maxEle) * maxEle;
                minIndex++;
            }
        }

        // If %maxEle, we get original ele
        // If /maxEle, we get ans
        for (int i = 0; i < n; i++) {
            arr[i] /= maxEle;
        }

    }

}
