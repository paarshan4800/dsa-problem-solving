// Given a string s and a dictionary of strings wordDict, return true if s can
// be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the
// segmentation.

// Leetcode - https://leetcode.com/problems/word-break/

// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple
// pen apple".
// Note that you are allowed to reuse a dictionary word.

// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

// Recursion - BACKTRACKING
// Time Complexity - O(2^n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // For O(1) access
        HashSet<String> set = new HashSet<>(wordDict);

        return wordBreak(s, set);
    }

    public boolean wordBreak(String s, HashSet<String> dictionary) {
        // If length == 0, then the string is completely segmented. Return true
        if (s.length() == 0)
            return true;

        // For substrings (0,1) , (0,2) , (0,s.length())
        for (int i = 0; i < s.length(); i++) {
            // Say s is abcd. If ab is in the dictionary and cd can also be segmented, then
            // return true
            if (dictionary.contains(s.substring(0, i + 1)) && wordBreak(s.substring(i + 1, s.length()), dictionary))
                return true;
        }

        return false;
    }
}


// MEMOIZATION - Top Down Approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String,Boolean> memo = new HashMap<>();
        return wordBreak(s,set,memo);
    }
    
    public boolean wordBreak(String s, HashSet<String> dictionary, HashMap<String,Boolean> memo) {
        if(s.length() == 0) return true;
        
        if(memo.containsKey(s)) return memo.get(s);
        
        for(int i=0;i<s.length();i++) {
            if(dictionary.contains(s.substring(0,i+1)) && wordBreak(s.substring(i+1,s.length()),dictionary,memo)) {
                memo.put(s,true);
                return true;
            }
                
            
        }
        
        memo.put(s,false);
        return false;
    }
}