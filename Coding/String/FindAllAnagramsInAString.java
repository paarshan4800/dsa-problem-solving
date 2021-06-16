// Given two strings s and p, return an array of all the start indices of p's
// anagrams in s. You may return the answer in any order.

// Leetcode - https://leetcode.com/problems/find-all-anagrams-in-a-string/

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".

// Input: s = "abab", p = "ab"
// Output: [0,1,2]

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        // Store Frequency of p in hash
        HashMap<Character, Integer> hash = new HashMap<>();
        for (Character c : p.toCharArray()) {
            if (hash.containsKey(c))
                hash.put(c, hash.get(c) + 1);
            else
                hash.put(c, 1);
        }

        List<Integer> res = new ArrayList<>();

        int left = 0, right = 0, counter = p.length();

        while (right < s.length()) {
            char cur = s.charAt(right);

            // If cur is not in the hash, keep expanding
            if (hash.containsKey(cur)) {
                // If cur is in the hash, decrement its frequency
                hash.put(cur, hash.get(cur) - 1);

                // After decrementing, if the frequency is >=0, cur contributes to the anagram.
                // So decrement counter
                if (hash.get(cur) >= 0) {
                    counter--;
                }

                // If counter == 0, the current window is a anagram
                while (counter == 0) {
                    char temp = s.charAt(left);

                    // If temp is not in the hash, keep contracting till we get a valid anagram
                    if (hash.containsKey(temp)) {
                        // If the current window length is equal to p.length, then the current window is
                        // a valid anagram. Add starting index to res
                        if (right + 1 - left == p.length()) {
                            res.add(left);
                        }

                        // Increment temp's frequency
                        hash.put(temp, hash.get(temp) + 1);

                        // After incrementing, if temp's frequency is > 0,increment counter. Need to
                        // expand the window.
                        if (hash.get(temp) > 0) {
                            counter++;
                        }
                    }

                    left++;
                }
            }

            right++;
        }

        return res;

    }
}