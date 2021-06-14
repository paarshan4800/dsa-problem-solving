// We define the usage of capitals in a word to be right when one of the
// following cases holds:

// All letters in this word are capitals, like "USA".
// All letters in this word are not capitals, like "leetcode".
// Only the first letter in this word is capital, like "Google".
// Given a string word, return true if the usage of capitals in it is right.

// Leetcode - https://leetcode.com/problems/detect-capital/

// Input: word = "USA"
// Output: true

// Input: word = "FlaG"
// Output: false

class Solution {
    public boolean detectCapitalUse(String word) {

        if (word.length() == 1)
            return true;

        boolean checkCapital = false;

        // If first two letters are capital, the whole string should be capital, set
        // checkCapital to true
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                checkCapital = true;
            }
        }

        for (int i = 1; i < word.length(); i++) {
            char cur = word.charAt(i);

            // If checkCapital, check for capital letters
            if (checkCapital) {
                if (cur < 'A' || cur > 'Z') {
                    return false;
                }
            }
            // If not checkCapital, check for lowercase letters
            else {
                if (cur < 'a' || cur > 'z') {
                    return false;
                }
            }
        }

        return true;
    }
}