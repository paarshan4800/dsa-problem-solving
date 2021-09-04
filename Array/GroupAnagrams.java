// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
// Leetcode - https://leetcode.com/problems/group-anagrams/

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Group by sorted string
// Time Complexity - O(n*klogk)
// Space Complexity - O(n*k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>(); // result
        HashMap<String, List<String>> hash = new HashMap<>();

        for (String str : strs) {
            // Sort the current string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // If the sorted string is not a key in the hash map, add as a key
            if (!hash.containsKey(sortedStr)) {
                hash.put(sortedStr, new LinkedList<>());
            }
            // Add the current string to list of the key - sortedStr
            hash.get(sortedStr).add(str);
        }

        // Iterate the hash map and add the lists to the result
        for (Map.Entry<String, List<String>> it : hash.entrySet()) {
            res.add(it.getValue());
        }

        return res;
    }
}

// Efficient Approach
// Instead of using the sorted string as key, use the sting alphabet count as
// key. We can avoid sorting which takes O(klogk) time.
// Time Complexity - O(n*k)
// Space Complexity - O(n*k)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> hash = new HashMap<>();

        for (String str : strs) {
            int[] alphaHash = new int[26];

            // alphaHash has the frequency of characters in str
            char[] charArray = str.toCharArray();
            for (char ele : charArray) {
                alphaHash[ele - 'a']++;
            }

            // Form a string with delimitter # from alphaHash and use it as a key
            StringBuilder temp = new StringBuilder();
            for (int val : alphaHash) {
                temp.append(val).append("#");
            }

            String strHash = temp.toString();

            if (!hash.containsKey(strHash)) {
                hash.put(strHash, new LinkedList<>());
            }
            hash.get(strHash).add(str);
        }

        for (Map.Entry<String, List<String>> it : hash.entrySet()) {
            res.add(it.getValue());
        }

        return res;
    }
}