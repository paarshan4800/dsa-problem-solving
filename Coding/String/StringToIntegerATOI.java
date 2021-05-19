// Implement the myAtoi(string s) function, which converts a string to a 32-bit
// signed integer (similar to C/C++'s atoi function).

// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/884/

// Input: s = "42"
// Output: 42

// Input: s = " -42"
// Output: -42

// Input: s = "4193 with words"
// Output: 4193

// Input: s = "words and 987"
// Output: 0

// Input: s = "-91283472332"
// Output: -2147483648

class Solution {
    public int myAtoi(String s) {

        int length = s.length();
        int res = 0, i = 0;

        // Skip whitespaces at the beginning
        for (; i < length; i++) {
            char curChar = s.charAt(i);
            if (curChar != ' ') {
                break;
            }
        }

        // If empty string after skipping all the white spaces
        if (length == 0 || i == length) {
            return 0;
        }

        // Check whether the given number is negative or not
        boolean negativeNumber;
        if (s.charAt(i) == '-') {
            negativeNumber = true;
        } else {
            negativeNumber = false;
        }

        // Set the iterator i according to the sign given
        i = (s.charAt(i) == '-' || s.charAt(i) == '+') ? i + 1 : i;

        // Traverse
        for (; i < length; i++) {
            char curChar = s.charAt(i); // Get the character
            int curInt = curChar; // Get the ASCII value of the character

            // If whitespace, break
            if (curChar == ' ') {
                break;
            }

            // If not a numeric character (0-9), break
            if (curInt < 48 || curInt > 57) {
                break;
            }

            int num = curChar - '0'; // Get the actual int
            // Add it to result. Cast to long to prevent overflow
            long temp = ((long) res * 10) + (long) num;

            // Check if overflow has occured
            if (temp > Integer.MAX_VALUE) {
                // Set res to max value of int
                res = (int) Math.pow(2, 31);
                res = (negativeNumber) ? res + 1 : res; // Range [2^31,2^31-1]
                break;
            }

            // Cast temp back to int
            res = (int) temp;

        }

        // If negative number, multiply with -1
        return (negativeNumber) ? (res * -1) : res;

    }
}