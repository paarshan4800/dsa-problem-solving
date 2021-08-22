// Given two numbers as stings s1 and s2. Calculate their Product.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/multiply-two-strings/1/

// Input:
// s1 = "33"
// s2 = "2"
// Output:
// 66

// Input:
// s1 = "-11"
// s2 = "23"
// Output:
// -253

class Solution {
    public String multiplyStrings(String s1, String s2) {
        boolean isResNegative = false;

        // If both negative, result is positive
        if (s1.charAt(0) == '-' && s2.charAt(0) == '-')
            isResNegative = false;
        // If any one negative, result is also negative
        else if (s1.charAt(0) == '-' || s2.charAt(0) == '-')
            isResNegative = true;

        // Remove - char from strings if there
        if (s1.charAt(0) == '-')
            s1 = s1.substring(1, s1.length());

        if (s2.charAt(0) == '-')
            s2 = s2.substring(1, s2.length());

        // max of result length will always be <= s1.length + s2.length
        int[] calc = new int[s1.length() + s2.length()];

        int carry = 0, startIndex = calc.length - 1;

        // Traverse from the end of first number
        for (int i = s1.length() - 1; i >= 0; i--) {
            carry = 0;
            // index and startIndex points to the location where intermediates are stored
            // and calculated
            int index = startIndex;
            // Traverse from the end of second number
            for (int j = s2.length() - 1; j >= 0; j--) {
                int mult = calc[index] + carry + ((s1.charAt(i) - '0') * (s2.charAt(j) - '0'));
                calc[index--] = mult % 10;
                carry = mult / 10;
            }

            // If any carry, add it to calc
            calc[index--] += carry;
            startIndex--;
        }

        StringBuilder res = new StringBuilder();

        // If result negative append - to result
        if (isResNegative)
            res.append("-");

        // Skip leading zeroes if any
        int i;
        for (i = 0; i < calc.length; i++) {
            if (calc[i] != 0)
                break;
        }

        // If any one of two strings is zero, return 0
        if (i == calc.length)
            return "0";

        for (; i < calc.length; i++)
            res.append(calc[i]);

        return res.toString();
    }
}