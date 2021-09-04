// Given two strings of lowercase alphabets and a value K, your task is to
// complete the given function which tells if two strings are K-anagrams of each
// other or not.

// Two strings are called K-anagrams if both of the below conditions are true.
// 1. Both have same number of characters.
// 2. Two strings can become anagram by changing at most K characters in a
// string.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/check-if-two-strings-are-k-anagrams-or-not/1/

// Input:
// str1 = "fodr", str2="gork"
// k = 2
// Output:
// 1
// Explanation: Can change fd to gk

class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {

        // Should be of same length
        if (s1.length() != s2.length())
            return false;

        HashMap<Character, Integer> hash = new HashMap<>();

        // Map character and frequency
        for (char cur : s1.toCharArray()) {
            if (hash.containsKey(cur))
                hash.put(cur, hash.get(cur) + 1);
            else
                hash.put(cur, 1);
        }

        int change = 0;

        for (char cur : s2.toCharArray()) {
            // If cur is in map, reduce the frequency
            if (hash.containsKey(cur)) {
                hash.put(cur, hash.get(cur) - 1);

                // Remove the cur from map when freq reaches zero
                if (hash.get(cur) == 0)
                    hash.remove(cur);
            }
            // IF cur is not in map, it needs to be changed. So increment change
            else
                change++;
        }

        // Required condition
        if (change <= k)
            return true;

        return false;
    }
}