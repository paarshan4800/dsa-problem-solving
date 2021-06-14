// Given a string s which consists of lowercase or uppercase letters, return the
// length of the longest palindrome that can be built with those letters.

// Letters are case sensitive, for example, "Aa" is not considered a palindrome
// here.

// Leetcode - https://leetcode.com/problems/longest-palindrome/

// Input: s = "abccccdd"
// Output: 7
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.

// Input: s = "a"
// Output: 1

// Input: s = "bb"
// Output: 2

// Input: s = "bananas"
// Output: 5

// Intuition - If the same character has occured twice, each of them contributes to the 
// left and right side of the palindrome.
class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> hash = new HashSet<>();
        int pairs = 0;

        for (char cur : s.toCharArray()) {
            // If already in hash set, remove that and increment pairs
            if (hash.contains(cur)) {
                hash.remove(cur);
                pairs++;
            }
            // else add to hash set
            else {
                hash.add(cur);
            }
        }

        // If hash is empty, the result is 2*pairs
        // If hash is not empty, the result is (2*pairs) + 1 (any element remaining in
        // the hash set can contribute to the +1)
        return (hash.isEmpty()) ? pairs * 2 : (pairs * 2) + 1;

    }
}