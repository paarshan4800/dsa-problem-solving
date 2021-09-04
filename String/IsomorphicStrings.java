// Given two strings 'str1' and 'str2', check if these two strings are
// isomorphic to each other.
// Two strings str1 and str2 are called isomorphic if there is a one to one
// mapping possible for every character of str1 to every character of str2 while
// preserving the order.
// Note: All occurrences of every character in ‘str1’ should map to the same
// character in ‘str2’

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/isomorphic-strings-1587115620/1/

// Input:
// str1 = aab
// str2 = xxy
// Output: 1
// Explanation: There are two different
// charactersin aab and xxy, i.e a and b
// with frequency 2and 1 respectively.

// Input:
// str1 = aab
// str2 = xyz
// Output: 0
// Explanation: There are two different
// charactersin aab but there are three
// different charactersin xyz. So there
// won't be one to one mapping between
// str1 and str2.

class Solution {
    // Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1, String str2) {

        // Should be of same length
        if (str1.length() != str2.length())
            return false;

        HashMap<Character, Character> hash = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            // If c1 hasn't occured yet in str1 and c2 hasn't occured yet in str2, it is a
            // new mapping. Add to map and set
            if (!hash.containsKey(c1) && !set.contains(c2)) {
                hash.put(c1, c2);
                set.add(c2);
            }
            // If c1 hasn't occured yet in str1 but c2 has occured in str2, invalid mapping.
            else if (!hash.containsKey(c1) && set.contains(c2)) {
                return false;
            }
            // If c1 has occured in str1 but c1's mapping doesn't match with c2, invalid
            else if (hash.get(c1) != c2) {
                return false;
            }
        }

        return true;
    }
}