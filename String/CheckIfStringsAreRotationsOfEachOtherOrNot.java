// Given two strings s1 and s2. The task is to check if s2 is a rotated version
// of the string s1. The characters in the strings are in lowercase.

// GeeksForGeeks -
// https://practice.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1#

// Input:
// geeksforgeeks
// forgeeksgeeks
// Output:
// 1

// Input:
// mightandmagic
// andmagicmigth
// Output:
// 0

// Approach - Check str2 is present in str1 + str1
class Solution {
    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // Your code here
        // Should be of same length
        if (s1.length() != s2.length())
            return false;

        return (s1 + s1).contains(s2);
    }

}

// Instead of using library function, Run KMP algorithm with str1 + str1 as text
// and str2 as pattern