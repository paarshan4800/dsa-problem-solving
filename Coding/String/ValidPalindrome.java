// Given a string s, determine if it is a palindrome, considering only
// alphanumeric characters and ignoring cases.
// Leetcode -
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/

// Input: s = "A man, a plan, a canal: Panama"
// Output: true
// Explanation: "amanaplanacanalpanama" is a palindrome.

// Input: s = "race a car"
// Output: false
// Explanation: "raceacar" is not a palindrome.

// Stack based approach
// Push all characters into the stack. And the pop one by one and compare with the given string.
// Time complexity - O(n)
// Space complexity - O(n)

// Two pointer approach
// Time complexity - O(n)
// Space complexity - O(1)

class Solution {
    public boolean isPalindrome(String s) {

        // Remove whitespaces and non alpha numeric characters and convert to lowercase
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;

    }
}