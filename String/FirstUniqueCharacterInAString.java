// Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
// Leetcode - https://leetcode.com/problems/first-unique-character-in-a-string/

// Input: s = "leetcode"
// Output: 0

// Input: s = "loveleetcode"
// Output: 2

// Input: s = "aabb"
// Output: -1

class Solution {
    public int firstUniqChar(String s) {

        // Hashing Approach

        HashMap<Character, Integer> hashMap = new HashMap<>();

        // Traverse the string and store character with its frequency in hash map
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (hashMap.containsKey(cur)) {
                hashMap.put(cur, hashMap.get(cur) + 1);
            } else {
                hashMap.put(cur, 1);
            }

        }

        // Traverse the array. If the character has occured exactly once, return index
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (hashMap.get(cur) == 1) {
                return i;
            }
        }

        return -1;
    }
}

// Since input is only lowercase alphabets, use an integer array of size 26 (lowercase alphabets)
// as a hash rather than hash Map
// Space Complexity - O(26) ~ O(1)
