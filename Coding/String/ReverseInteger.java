// Given a signed 32-bit integer x, return x with its digits reversed. If
// reversing x causes the value to go outside the signed 32-bit integer range
// [-231, 231 - 1], then return 0.
// Leetcode - https://leetcode.com/problems/reverse-integer/

// Input: x = 123
// Output: 321

// Input: x = -123
// Output: -321

// Input: x = 120
// Output: 21

// Input: x = 0
// Output: 0

class Solution {
    public int reverse(int x) {

        int res = 0;
        int inp = Math.abs(x); // Get non-negative number
        int factor = 10;

        // If input is minumum integer value, return 0.
        // Math.abs(Integer.MIN_VALUE) = Integer.MIN_VALUE
        // Since, Math.abs(-2147483648) = 2147483648 (which overflows) and becomes
        // -2147483648
        if (inp == Integer.MIN_VALUE) {
            return 0;
        }

        // Process one number at a time by using % and / operators
        while (inp > 9) {
            // Cast to long to prevent overflow
            long temp = ((long) res * (long) factor) + ((long) inp % 10L);

            // If overflows, return 0
            if (temp > Integer.MAX_VALUE) {
                return 0;
            }

            res = (int) temp; // Update res. Cast back to int
            inp = inp / 10; // Cut off the last digit

        }

        long temp = ((long) res * (long) factor) + ((long) inp % 10);
        if (temp > Integer.MAX_VALUE) {
            return 0;
        }

        res = (int) temp;

        // If input is negative, multiply by -1 and return
        return (x > 0) ? res : res * -1;

    }
}
