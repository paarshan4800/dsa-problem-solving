// Given two strings s and t, return true if they are equal when both are typed
// into empty text editors. '#' means a backspace character.

// Note that after backspacing an empty text, the text will continue empty.

// Leetcode - https://leetcode.com/problems/backspace-string-compare/

// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Input: s = "ab##", t = "c#d#"
// Output: true
// Explanation: Both s and t become "".

// Input: s = "a##c", t = "#a#c"
// Output: true
// Explanation: Both s and t become "c".

// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

// Stack Based Approach
// Simulating an undo operation, push into stack if it is not a '#' and pop from stack if it is one
// Compare both the stacks by popping one at a time.
// If they are the same, return true else false
// Time Complexity - O(n)
// Space Complexity - O(n)

// No extra space
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
    public boolean backspaceCompare(String s, String t) {

        // Traverse from the end
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                // If #, increment skipS
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                }
                // If not # and skipS>0, this character should be skipped as it will be erased
                // by a backspace
                else if (skipS > 0) {
                    skipS--;
                    i--;
                }
                // If not # and skipS not > 0, break
                else
                    break;
            }

            // Do the same for another string
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else
                    break;
            }

            // If s[i] and t[j] are not same, return false
            if (i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
                return false;

            // If any one of the string is traversed completely, return false
            if ((i >= 0) != (j >= 0))
                return false;

            i--;
            j--;
        }

        return true;

    }
}