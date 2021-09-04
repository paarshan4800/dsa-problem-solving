// Given an array A of positive integers. Your task is to find the leaders in
// the array. An element of array is leader if it is greater than or equal to
// all the elements to its right side. The rightmost element is always a leader.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1#

// Input:
// n = 6
// A[] = {16,17,4,3,5,2}
// Output: 17 5 2

// Input:
// n = 5
// A[] = {1,2,3,4,0}
// Output: 4 0

class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(arr[n - 1]); // Last element will always be a leader

        // Traverse from the end
        for (int i = n - 2; i >= 0; i--) {
            // If the current element is greater than or equal to the previous leader, then
            // it is also a leader
            if (arr[i] >= res.get(res.size() - 1)) {
                res.add(arr[i]);
            }
        }

        // Reverse the result list
        Collections.reverse(res);

        return res;
    }
}