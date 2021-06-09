// Given a string containing digits from 2-9 inclusive, return all possible
// letter combinations that the number could represent. Return the answer in any
// order.

// A mapping of digit to letters (just like on the telephone buttons) is given
// below. Note that 1 does not map to any letters.

// Leetcode -
// https://leetcode.com/problems/letter-combinations-of-a-phone-number/

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Input: digits = ""
// Output: []

// Input: digits = "2"
// Output: ["a","b","c"]

// Recursive Backtracking Solution
// Time Complexity - O(4^n) (maximum 4 characters are possible for a digit)
// Space Complexity - O(n) (call stack)
class Solution {

    public final static String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits.length() == 0) {
            return res;
        }

        // We pass the result list, digits, "" (this is the state of the current
        // combination), 0 (index of digits)
        letterCombinations(res, digits, "", 0);
        return res;

    }

    public void letterCombinations(List<String> res, String digits, String current, int index) {

        // Base condition (If true, a combination is found and add it to result)
        if (index == digits.length()) {
            res.add(current);
            return;
        }

        // Find the current digit from digits
        int currentDigit = digits.charAt(index) - '0';
        // Using currentDigit as an index, find the letter mapping
        String currentDigitCharacters = mapping[currentDigit];

        // Process the letters (currentDigitCharacters) and recur one by one
        for (int i = 0; i < currentDigitCharacters.length(); i++) {
            // We change the state of the combination by appending the current character
            // being processed. We also increment the index by 1.
            letterCombinations(res, digits, current + currentDigitCharacters.charAt(i), index + 1);
        }

    }
}

// Breadth First Search Approach
class Solution {

    public final static String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {

        LinkedList<String> res = new LinkedList<>(); // Queue and result list

        if (digits.length() == 0) {
            return res;
        }

        res.add(""); // Initially "" and we keep on building

        // Iterate digit by digit
        for (int i = 0; i < digits.length(); i++) {
            // Get the current digit
            int currentDigit = digits.charAt(i) - '0';
            // Process all the elements of the queue of level i (i.e length of element in
            // queue == i)
            while (res.peek().length() == i) {
                String current = res.remove();
                String currentDigitCharacters = mapping[currentDigit];
                // Iterate char by char in the characters of the current digit
                for (int j = 0; j < currentDigitCharacters.length(); j++) {
                    // Append to the string popped from the queue and push back
                    res.add(current + currentDigitCharacters.charAt(j));
                }
            }
        }

        return res;

        // For understanding, draw the recursion tree completely. We traverse level by
        // level.

    }

}