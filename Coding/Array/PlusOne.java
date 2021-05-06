// Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
// Leetcode - https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/

// O(n) - Time Complexity
class Solution {
    public int[] plusOne(int[] digits) {
        
        int i = digits.length - 1;
        // Initial carry 1 is the plus 1
        // later stages it would be the actual carry
        int carry = 1;
        
        // Iterating from the end
        while(i>=0) {
            // Add carry to digits[i]. Initially it would be +1
            digits[i] += carry;

            // If the digits[i] after addition is <= 9, then thats the solution.
            if(digits[i] <= 9) {
                // Make carry 0 for condition outside while
                carry = 0;
                break;
            } 

            // Else find carry using mod operator
            carry = digits[i] % 9;
            // After carry, digits[i] would be 0
            digits[i] = 0;
            // Decrement iterator
            i--;
        }
        
        // If carry 0 means, no overflow.
        if(carry == 0) {
            return digits;
        }
        
        // Else we need to create a new array to accomodate the extra digit and copy
        int[] res = new int[digits.length+1];
        res[0] = carry;
        for(int j=1;j<digits.length+1;j++) {
            res[j] = digits[j-1];
        }
        
        return res;
        
        
    }
}