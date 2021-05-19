// Given two strings s and t, return true if t is an anagram of s, and false
// otherwise. An anagram is a word or phrase formed by rearranging the letters
// of a different word or phrase, typically using all the original letters
// exactly once.
// Leetcode - https://leetcode.com/problems/valid-anagram/

// Input: s = "anagram", t = "nagaram"
// Output: true

// Input: s = "rat", t = "car"
// Output: false

// Sort both strings. If equal, they are anagram.
// Time Complexity - O(nlogn)
// Space Complexity - O(1)

// Hashing Approach
// Time Complexity - O(nlogn)
// Space Complexity - O(1)
class Solution {
    public boolean isAnagram(String s, String t) {

        int sSize = s.length();
        int tSize = t.length();

        if (sSize != tSize) {
            return false;
        }

        // Represents a hash of 26 lowercase alphabets
        int[] hash = new int[26];
        Arrays.fill(hash, 0);

        // Increment if character occurs
        for (int i = 0; i < sSize; i++) {
            char cur = s.charAt(i);
            hash[cur - 97]++;
        }

        // Decrement if character occurs
        for (int i = 0; i < tSize; i++) {
            char cur = t.charAt(i);
            hash[cur - 97]--;
        }

        // If any hash value is not equal to 0, it is not an anagram
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        return true;

    }
}