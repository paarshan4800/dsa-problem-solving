// Given two binary strings A and B consisting of only 0s and 1s. Find the
// resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string
// should not have any leading zeros.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/add-binary-strings3805/1#

// Input:
// A = "1101", B = "111"
// Output: 10100

// For Input:
// 01001001 0110101
// your output is:
// 1111110

class Solution {

    int getNumeric(char x) {
        return x - '0';
    }

    String addBinary(String A, String B) {

        // Make sure that A is the longest string
        if (B.length() > A.length()) {
            String temp = A;
            A = B;
            B = temp;
        }

        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;

        StringBuilder res = new StringBuilder();

        // Calculate binary sum bit by bit
        while (i >= 0 && j >= 0) {
            int sum = getNumeric(A.charAt(i)) + getNumeric(B.charAt(j)) + carry;
            carry = sum / 2;
            res.append(sum % 2);

            i--;
            j--;
        }

        // If A is longer than B, process A alone
        while (i >= 0) {
            int sum = getNumeric(A.charAt(i)) + carry;
            carry = sum / 2;
            res.append(sum % 2);

            i--;
        }

        // If carry is there after processing both strings, append
        if (carry != 0) {
            res.append(carry);
        }

        int start = res.length() - 1;
        // Result shouldn't have leading zeroes. So remove them
        while (start >= 0 && res.charAt(start) == '0') {
            start--;
        }

        if (start != res.length() - 1) {
            res.delete(start + 1, res.length());
        }

        return res.reverse().toString();

    }
}