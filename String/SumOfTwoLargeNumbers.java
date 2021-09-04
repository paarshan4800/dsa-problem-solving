// Given two strings denoting non-negative numbers X and Y. Calculate the sum of
// X and Y.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/sum-of-numbers-or-number1219/1/

// Input:
// X = "25", Y = "23"
// Output:
// 48
// Explanation:
// The sum of 25 and 23 is 48.

// Input:
// X = "2500", Y = "23"
// Output:
// 2523
// Explanation:
// The sum of 2500 and 23 is 2523.

class Solution {
    String findSum(String X, String Y) {
        StringBuilder res = new StringBuilder();

        if (X.length() < Y.length()) {
            String temp = X;
            X = Y;
            Y = temp;
        }

        int i = X.length() - 1, j = Y.length() - 1;
        int carry = 0;

        while (j >= 0) {
            int x = X.charAt(i) - '0';
            int y = Y.charAt(j) - '0';

            int sum = carry + x + y;
            res.append(sum % 10);
            carry = sum / 10;

            i--;
            j--;
        }

        if (i >= 0) {
            while (i >= 0) {
                int x = X.charAt(i) - '0';

                int sum = carry + x;
                res.append(sum % 10);
                carry = sum / 10;

                i--;
            }
        }

        if (carry != 0)
            res.append(carry);

        res = res.reverse();

        for (i = 0; i < res.length(); i++) {
            if (res.charAt(i) != '0')
                break;
        }

        if (i == res.length())
            return "0";

        return res.substring(i, res.length());

    }
}