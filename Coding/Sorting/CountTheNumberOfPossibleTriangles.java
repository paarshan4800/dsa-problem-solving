// Given an unsorted array arr[] of n positive integers. Find the number of
// triangles that can be formed with three different array elements as lengths
// of three sides of triangles.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1#

// Input:
// n = 3
// arr[] = {3, 5, 4}
// Output:
// 1

// Input:
// n = 5
// arr[] = {6, 4, 9, 7, 8}
// Output:
// 10

// Hint - (a+b)>c makes a valid triangle where a,b and c are three sides of a
// triangle

// Time Complexity - O(n^2)
class Solution {
    // Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n) {
        // Sort the given array
        Arrays.sort(arr);
        int res = 0;

        // Use two pointer approach beginning at the end of the array
        for (int i = n - 1; i >= 2; i--) {
            int low = 0, high = i - 1;
            while (low < high) {
                // If the arr[low] + arr[high] > arr[i] which satisfies the condition to be a
                // triangle, then arr[low+1] + arr[high] > arr[i] and
                // arr[low+2] + arr[high] > arr[i] till low < high would also satisfy the
                // triangle condition. Here comes the optimization of this problem.
                // We update res as res + (high - low)
                if (arr[low] + arr[high] > arr[i]) {
                    res += (high - low);
                    high--;
                }
                // If the arr[low] + arr[high] <= arr[i], increment low
                else {
                    low++;
                }
            }
        }

        return res;
    }
}