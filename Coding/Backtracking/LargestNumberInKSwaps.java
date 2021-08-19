
// Given a number K and string str of digits denoting a positive integer, build
// the largest number possible by performing swap operations on the digits of
// str at most K times.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps-1587115620/1/

// Input:
// K = 4
// str = "1234567"
// Output:
// 7654321
// Explanation:
// Three swaps can make the
// input 1234567 to 7654321, swapping 1
// with 7, 2 with 6 and finally 3 with 5

// Input:
// K = 3
// str = "3435335"
// Output:
// 5543333
// Explanation:
// Three swaps can make the input
// 3435335 to 5543333, swapping 3
// with 5, 4 with 5 and finally 3 with 4

// BACKTRACKING - Time Limit Exceeded (Generating all possibilities and finding the max)
class Solution {
    // Function to find the largest number after k swaps.
    static String max;

    public static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1, str.length());

        return left + jth + middle + ith + right;
    }

    public static void findMax(String str, int k, int index) {

        // If current string > max, update
        if (str.compareTo(max) > 0)
            max = str;

        // If k==0, then all four swaps have been made. So return
        if (k == 0)
            return;

        for (int i = index + 1; i < str.length(); i++) {
            // Swap only if char at RHS > char at LHS
            if (str.charAt(i) > str.charAt(index)) {
                str = swap(str, index, i); // Swap
                findMax(str, k - 1, i); // Explore
                str = swap(str, index, i); // Unswap
            }
        }

    }

    public static String findMaximumNum(String str, int k) {
        max = str;
        findMax(str, k, 0);
        return max;
    }
}

// Accepted Solution
// Instead of swapping all possible elements, find the maximum element in the
// possibility and swap it
class Solution {
    // Function to find the largest number after k swaps.
    static String max;

    public static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        String left = str.substring(0, i);
        String middle = str.substring(i + 1, j);
        String right = str.substring(j + 1, str.length());

        return left + jth + middle + ith + right;
    }

    public static void findMax(String str, int k, int index) {

        if (str.compareTo(max) > 0)
            max = str;

        if (k == 0 || index == str.length())
            return;

        // Let maxEle be charAt(index)
        // Find if there is any max character to index's right which we can swap
        char maxEle = str.charAt(index);
        for (int i = index + 1; i < str.length(); i++) {
            if (str.charAt(i) > maxEle)
                maxEle = str.charAt(i);
        }

        // If there is some element greater than charAt(index), then we need to swap
        if (maxEle != str.charAt(index)) {
            // Find the all elements which are maxEle
            for (int i = index + 1; i < str.length(); i++) {
                if (str.charAt(i) == maxEle) {
                    str = swap(str, index, i); // Swap
                    findMax(str, k - 1, index + 1); // Explore
                    str = swap(str, index, i); // Unswap
                }
            }
        }
        // If there is no element greater than charAt(index), then no need of swapping.
        // Move to next element
        else {
            findMax(str, k, index + 1);
        }

    }

    public static String findMaximumNum(String str, int k) {
        max = str;
        findMax(str, k, 0);
        return max;
    }
}